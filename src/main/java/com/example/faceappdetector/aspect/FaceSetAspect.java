package com.example.faceappdetector.aspect;

import com.example.faceappdetector.client.AddDataToFaceSetApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class FaceSetAspect {

    private final AddDataToFaceSetApi addDataToFaceSetApi;

    @AfterReturning(
            pointcut = "@annotation(com.example.faceappdetector.aspect.AddToFaceSetAfterSave)",
            returning = "result"
    )
    public void afterSaveReturnToken(Mono<String> result) {
        result
                .flatMap(faceToken -> {
                    log.info("Adding face token to face set: {}", faceToken);
                    return addDataToFaceSetApi.addFaceToFaceSet(faceToken)
                            .doOnSuccess(response -> log.info("Face token added successfully to face set"))
                            .doOnError(error -> log.error("Failed to add face token to face set", error));
                })
                .subscribe();
    }
}
