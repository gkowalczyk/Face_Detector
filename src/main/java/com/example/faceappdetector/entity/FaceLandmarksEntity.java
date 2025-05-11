package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class FaceLandmarksEntity {
    private PupilLeftEntity pupilLeft;
    private PupilRightEntity pupilRight;
    private NoseTipEntity noseTip;
    private MouthLeftEntity mouthLeft;
    private MouthRightEntity mouthRight;
    private EyebrowLeftOuterEntity eyebrowLeftOuter;
    private EyebrowLeftInnerEntity eyebrowLeftInner;
    private EyeLeftOuterEntity eyeLeftOuter;
    private EyeLeftTopEntity eyeLeftTop;
    private EyeLeftBottomEntity eyeLeftBottom;
    private EyeLeftInnerEntity eyeLeftInner;
    private EyebrowRightInnerEntity eyebrowRightInner;
    private EyebrowRightOuterEntity eyebrowRightOuter;
    private EyeRightInnerEntity eyeRightInner;
    private EyeRightTopEntity eyeRightTop;
    private EyeRightBottomEntity eyeRightBottom;
    private EyeRightOuterEntity eyeRightOuter;
    private NoseRootLeftEntity noseRootLeft;
    private NoseRootRightEntity noseRootRight;
    private NoseLeftAlarTopEntity noseLeftAlarTop;
    private NoseRightAlarTopEntity noseRightAlarTop;
    private NoseLeftAlarOutTipEntity noseLeftAlarOutTip;
    private NoseRightAlarOutTipEntity noseRightAlarOutTip;
    private UpperLipTopEntity upperLipTop;
    private UpperLipBottomEntity upperLipBottom;
    private UnderLipTopEntity underLipTop;
    private UnderLipBottomEntity underLipBottom;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
