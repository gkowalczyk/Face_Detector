package com.example.faceappdetector.service;

import com.example.faceappdetector.model.dto.FaceAttributeRequestDto;
import com.example.faceappdetector.model.FaceObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class FaceDetectorService {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public Mono<List<FaceObject>> filterFaces(FaceAttributeRequestDto faceAttributes) {

        assert faceAttributes.getHair() != null;
        assert faceAttributes.getHair() != null;
        assert faceAttributes.getHair() != null;
        Query query = new Query(new Criteria()
                .andOperator(Stream.of(
                                Optional.ofNullable(faceAttributes.getAgeMin())

                                        .map(ageMin -> Criteria.where("faceAttributes.age").gte(ageMin)),

                                Optional.ofNullable(faceAttributes.getAgeMax())

                                        .map(ageMax -> Criteria.where("faceAttributes.age").lte(ageMax)),

                                Optional.ofNullable(faceAttributes.getSmileMin())
                                        .map(min -> Criteria.where("faceAttributes.smile").gte(min)),
                                Optional.ofNullable(faceAttributes.getSmileMax())
                                        .map(max -> Criteria.where("faceAttributes.smile").lte(max)),

                                Optional.ofNullable(faceAttributes.getGender())
                                        .map(gender -> Criteria.where("faceAttributes.gender").is(gender)),

                                Optional.ofNullable(faceAttributes.getHeadPose())
                                        .map(hp -> Criteria.where("faceAttributes.headPose.pitch").is(hp.getPitch())),
                                Optional.ofNullable(faceAttributes.getHeadPose())
                                        .map(hp -> Criteria.where("faceAttributes.headPose.roll").is(hp.getRoll())),
                                Optional.ofNullable(faceAttributes.getHeadPose())
                                        .map(hp -> Criteria.where("faceAttributes.headPose.yaw").is(hp.getYaw())),

                                Optional.ofNullable(faceAttributes.getMoustacheMin())

                                        .map(min -> Criteria.where("faceAttributes.facialHair.moustache").gte(min)),

                                Optional.ofNullable(faceAttributes.getMoustacheMax())
                                        .map(max -> Criteria.where("faceAttributes.facialHair.moustache").lte(max)),

                                Optional.ofNullable(faceAttributes.getSideburnsMin())
                                        .map(fh -> Criteria.where("faceAttributes.facialHair.sideburns").gte(fh)),

                                Optional.ofNullable(faceAttributes.getSideburnsMax())
                                        .map(fh -> Criteria.where("faceAttributes.facialHair.sideburns").lte(fh)),

                                Optional.ofNullable(faceAttributes.getBeardMin())
                                        .map(min -> Criteria.where("faceAttributes.facialHair.beard").gte(min)),

                                Optional.ofNullable(faceAttributes.getBeardMax())
                                        .map(max -> Criteria.where("faceAttributes.facialHair.beard").lte(max)),

                                Optional.ofNullable(faceAttributes.getGlasses())
                                        .filter(glasses -> !glasses.isEmpty())
                                        .map(glasses -> Criteria.where("faceAttributes.glasses").is(glasses)),

                                Optional.ofNullable(faceAttributes.getBlur())
                                        .map(blur -> Criteria.where("faceAttributes.blur.blurLevel").is(blur.getBlurLevel())),
                                Optional.ofNullable(faceAttributes.getBlur())
                                        .map(blur -> Criteria.where("faceAttributes.blur.value").is(blur.getValue())),

                                Optional.ofNullable(faceAttributes.getExposure())
                                        .map(exposure -> Criteria.where("faceAttributes.exposure.exposureLevel").is(exposure.getExposureLevel())),
                                Optional.ofNullable(faceAttributes.getExposure())
                                        .map(exposure -> Criteria.where("faceAttributes.exposure.value").is(exposure.getValue())),

                                Optional.ofNullable(faceAttributes.getNoise())
                                        .map(noise -> Criteria.where("faceAttributes.noise.noiseLevel").is(noise.getNoiseLevel())),
                                Optional.ofNullable(faceAttributes.getNoise())
                                        .map(noise -> Criteria.where("faceAttributes.noise.value").is(noise.getValue())),

                                Optional.ofNullable(faceAttributes.getMakeup())
                                        .filter(makeup -> makeup.getEyeMakeup() != null)
                                        .map(makeup -> Criteria.where("faceAttributes.makeup.eyeMakeup").is(makeup.getEyeMakeup())),

                                Optional.ofNullable(faceAttributes.getMakeup())
                                        .filter(makeup -> makeup.getLipMakeup() != null)
                                        .map(makeup -> Criteria.where("faceAttributes.makeup.lipMakeup").is(makeup.getLipMakeup())),

                                Optional.ofNullable(faceAttributes.getOcclusion())
                                        .filter(face -> face.getForeheadOccluded() != null)
                                        .map(occ -> Criteria.where("faceAttributes.occlusion.foreheadOccluded").is(occ.getForeheadOccluded())),

                                Optional.ofNullable(faceAttributes.getOcclusion())
                                        .filter(face -> face.getEyeOccluded() != null)
                                        .map(occ -> Criteria.where("faceAttributes.occlusion.eyeOccluded").is(occ.getEyeOccluded())),

                                Optional.ofNullable(faceAttributes.getOcclusion())
                                        .filter(face -> face.getMouthOccluded() != null)
                                        .map(occ -> Criteria.where("faceAttributes.occlusion.mouthOccluded").is(occ.getMouthOccluded())),

                                Optional.ofNullable(faceAttributes.getHairBaldMin())
                                        .map(min -> Criteria.where("faceAttributes.hair.bald").gte(min)),

                                Optional.ofNullable(faceAttributes.getHairBaldMax())
                                        .map(max -> Criteria.where("faceAttributes.facialHair.moustache").lte(max)),

                                Optional.ofNullable(faceAttributes.getHair())
                                        .map(hair -> Criteria.where("faceAttributes.hair.invisible").is(hair.getInvisible())),

                                Optional.ofNullable(faceAttributes.getHairColor())
                                        .filter(color -> !color.isEmpty())
                                        .map(color -> Criteria.where("faceAttributes.hair.hairColor.0.color").is(color)),

                                Optional.ofNullable(faceAttributes.getQualityForRecognition())
                                        .map(q -> Criteria.where("faceAttributes.qualityForRecognition").is(q))
                        ).flatMap(Optional::stream)
                        .toArray(Criteria[]::new)));

        return reactiveMongoTemplate.find(query, FaceObject.class)
                .doOnNext(faceObject -> log.info("Found face object: {}", faceObject))
                .onErrorResume(e -> {
                    log.info("Error occurred while filtering faces: {}", e.getMessage());
                    return Mono.empty();
                })
                .collectList();
    }
}

