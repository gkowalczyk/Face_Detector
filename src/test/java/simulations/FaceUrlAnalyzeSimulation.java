package simulations;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class FaceUrlAnalyzeSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8081")
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");

    String jsonBody = """
        {
          "imageUrl": "https://img.freepik.com/premium-zdjecie/szczesliwa-piekna-brunetka-dziewczyna-z-dlugimi-prostymi-wlosami_900168-1270.jpg"
                }
        """;

    ScenarioBuilder scn = scenario("Analyze FaceObjects by Url")
            .exec(
                    http("POST /api/face")
                            .post("/api/face")
                            .body(StringBody(jsonBody)).asJson()
                            .check(status().is(200))
            );
    {
        setUp(
                scn.injectOpen(atOnceUsers(50))
        ).protocols(httpProtocol);
    }
}
