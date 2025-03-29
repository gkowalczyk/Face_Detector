import React from 'react';

const FaceResult = ({faceData}) => {
    if (!Array.isArray(faceData) || faceData.length === 0) return null;

    const formatHair = (hair) => {
        return hair
            .filter(color => color.confidence > 0.1)
            .map(color => `${color.color} (${(color.confidence * 100).toFixed(1)}%)`)
            .join(', ');
    };

    return (
        <div style={{textAlign: "left", marginTop: "1rem"}}>
            <h2>Wynik analizy</h2>
            {faceData.map((face, index) => (
                <div key={index} style={{marginBottom: "1rem"}}>
                    <p><strong>Wiek:</strong> {face.faceAttributes.age}</p>
                    <p><strong>Uśmiech:</strong> {(face.faceAttributes.smile * 100).toFixed(1)}%</p>
                    <p><strong>Okulary:</strong> {face.faceAttributes.glasses}</p>

                    <h4>💇 Włosy:</h4>
                    <p><strong>Kolory:</strong> {formatHair(face.faceAttributes.hair.hairColor)}</p>
                    <p><strong>Łysina:</strong> {(face.faceAttributes.hair.bald* 100).toFixed(1)}%</p>
                    <p><strong>Włosy niewidoczne:</strong> {face.faceAttributes.hair.invisible ? 'Tak' : 'Nie'}</p>

                    <h4>🧔 Zarost:</h4>
                    <p><strong>Wąsy:</strong> {(face.faceAttributes.facialHair.moustache * 100).toFixed(0)}%</p>
                    <p><strong>Broda:</strong> {(face.faceAttributes.facialHair.beard * 100).toFixed(0)}%</p>
                    <p><strong>Baki:</strong> {(face.faceAttributes.facialHair.sideburns * 100).toFixed(0)}%</p>

                    <h4>💄 Makijaż:</h4>
                    <p><strong>Oczy:</strong> {face.faceAttributes.makeup.eyeMakeup ? 'Tak' : 'Nie'}</p>
                    <p><strong>Usta:</strong> {face.faceAttributes.makeup.lipMakeup ? 'Tak' : 'Nie'}</p>

                    <h4>📸 Jakość i ekspozycja:</h4>
                    <p><strong>Rozmycie:</strong> {face.faceAttributes.blur.blurLevel} ({(face.faceAttributes.blur.value * 100).toFixed(0)}%)</p>
                    <p><strong>Ekspozycja:</strong> {face.faceAttributes.exposure.exposureLevel} ({(face.faceAttributes.exposure.value * 100).toFixed(0)}%)</p>
                    <p><strong>Szum:</strong> {face.faceAttributes.noise.noiseLevel} ({(face.faceAttributes.noise.value * 100).toFixed(0)}%)</p>

                    <h4>🙈 Przesłonięcia:</h4>
                    <p><strong>Czoło zakryte:</strong> {face.faceAttributes.occlusion.foreheadOccluded ? 'Tak' : 'Nie'}</p>
                    <p><strong>Oczy zakryte:</strong> {face.faceAttributes.occlusion.eyeOccluded ? 'Tak' : 'Nie'}</p>
                    <p><strong>Usta zakryte:</strong> {face.faceAttributes.occlusion.mouthOccluded ? 'Tak' : 'Nie'}</p>

                    <h4>📈 Jakość rozpoznania:</h4>
                    <p><strong>Poziom:</strong> {face.faceAttributes.qualityForRecognition}</p>


                </div>
            ))}
        </div>
    );
};
export default FaceResult;
