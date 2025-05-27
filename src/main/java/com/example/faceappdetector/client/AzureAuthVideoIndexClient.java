package com.example.faceappdetector.client;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AzureAuthVideoIndexClient {

    private final WebClient webClient;
    @Value("${azure.auth.url}")
    private String azureAuthUrl;
    @Value("${azure.auth.tenant-id}")
    private String tenantId;
    @Value("${azure.auth.client-id}")
    private String clientId;
    @Value("${azure.auth.client-secret}")
    private String clientSecret;
    @Value("${azure.video.client.subscription-id}")
    private String subscriptionId;
    private final String resourceGroup = "zasob1";
    private final String accountName = "AzureVideoApi";
    private final String apiVersion = "2025-01-01";

    public Mono<String> getAccessToken() {
        String uri = String.format("/%s/oauth2/token", tenantId);

        return WebClient.builder()
                .baseUrl(azureAuthUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .build()
                .post()
                .uri(uri)
                .body(BodyInserters
                        .fromFormData("grant_type", "client_credentials")
                        .with("client_id", clientId)
                        .with("client_secret", clientSecret)
                        .with("resource", "https://management.azure.com/"))
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(token -> token.get("access_token").asText());
    }

    public Mono<String> generateVideoIndexToken() {
        return getAccessToken()
                .flatMap(token -> {

                    String url = String.format(
                            "https://management.azure.com/subscriptions/%s/" +
                                    "resourceGroups/%s/" +
                                    "providers/Microsoft.VideoIndexer/" +
                                    "accounts/%s/" +
                                    "generateAccessToken?api-version=%s",
                            subscriptionId, resourceGroup, accountName, apiVersion);

                    return webClient.post()
                            .uri(url)
                            .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                            .body(BodyInserters.fromValue("""
                                    {
                                      "permissionType": "Contributor",
                                      "scope": "Account"
                                    }
                                    """))
                            .retrieve()
                            .bodyToMono(JsonNode.class)
                            .map(json -> json.get("accessToken").asText())
                            .doOnSuccess(code -> {
                                System.out.println("Access token retrieved successfully: " + code);
                            })
                            .doOnError(error -> {
                                System.err.println("Error retrieving access token: " + error.getMessage());
                            });
                });
    }
}