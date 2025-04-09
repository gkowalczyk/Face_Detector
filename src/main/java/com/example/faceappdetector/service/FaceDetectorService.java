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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class FaceDetectorService {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public Mono<List<FaceObject>> filterFaces(FaceAttributeRequestDto faceAttributes) {
        List<Criteria> criteriaList = Stream.of(
                        Optional.ofNullable(faceAttributes.getAge())
                                .map(age -> Criteria.where("faceAttributes.age").is(age)),

                        Optional.ofNullable(faceAttributes.getSmile())
                                .map(smile -> Criteria.where("faceAttributes.smile").is(smile)),

                        Optional.ofNullable(faceAttributes.getGender())
                                .map(gender -> Criteria.where("faceAttributes.gender").is(gender)),

                        Optional.ofNullable(faceAttributes.getHeadPose())
                                .map(hp -> Criteria.where("faceAttributes.headPose.pitch").is(hp.getPitch())),
                        Optional.ofNullable(faceAttributes.getHeadPose())
                                .map(hp -> Criteria.where("faceAttributes.headPose.roll").is(hp.getRoll())),
                        Optional.ofNullable(faceAttributes.getHeadPose())
                                .map(hp -> Criteria.where("faceAttributes.headPose.yaw").is(hp.getYaw())),

                        Optional.ofNullable(faceAttributes.getFacialHair())
                                .map(fh -> Criteria.where("faceAttributes.facialHair.moustache").is(fh.getMoustache())),
                        Optional.ofNullable(faceAttributes.getFacialHair())
                                .map(fh -> Criteria.where("faceAttributes.facialHair.beard").is(fh.getBeard())),
                        Optional.ofNullable(faceAttributes.getFacialHair())
                                .map(fh -> Criteria.where("faceAttributes.facialHair.sideburns").is(fh.getSideburns())),

                        Optional.ofNullable(faceAttributes.getGlasses())
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
                                .map(makeup -> Criteria.where("faceAttributes.makeup.eyeMakeup").is(makeup.getEyeMakeup())),
                        Optional.ofNullable(faceAttributes.getMakeup())
                                .map(makeup -> Criteria.where("faceAttributes.makeup.lipMakeup").is(makeup.getLipMakeup())),

                        Optional.ofNullable(faceAttributes.getOcclusion())
                                .map(occ -> Criteria.where("faceAttributes.occlusion.foreheadOccluded").is(occ.getForeheadOccluded())),
                        Optional.ofNullable(faceAttributes.getOcclusion())
                                .map(occ -> Criteria.where("faceAttributes.occlusion.eyeOccluded").is(occ.getEyeOccluded())),
                        Optional.ofNullable(faceAttributes.getOcclusion())
                                .map(occ -> Criteria.where("faceAttributes.occlusion.mouthOccluded").is(occ.getMouthOccluded())),

                        Optional.ofNullable(faceAttributes.getHair())
                                .map(hair -> Criteria.where("faceAttributes.hair.bald").is(hair.getBald())),
                        Optional.ofNullable(faceAttributes.getHair())
                                .map(hair -> Criteria.where("faceAttributes.hair.invisible").is(hair.getInvisible())),

                        Optional.ofNullable(faceAttributes.getHairColor())
                                .map(color -> Criteria.where("faceAttributes.hair.hairColor.color").is(color)),

                        Optional.ofNullable(faceAttributes.getQualityForRecognition())
                                .map(q -> Criteria.where("faceAttributes.qualityForRecognition").is(q))

                ).flatMap(Optional::stream)
                .collect(Collectors.toList());

        Query query = new Query(new Criteria()
                .andOperator(criteriaList.toArray(new Criteria[0])));

        return reactiveMongoTemplate.find(query, FaceObject.class).collectList();
    }
}

