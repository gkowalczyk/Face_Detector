import React from 'react';

const FaceResult = ({faceData, view}) => {
    if (!faceData)
        return null;

    const translateHairColor = (color) => {
        const colorMap = {
            brown: "brązowy",
            black: "czarny",
            blond: "blond",
            red: "rudy",
            gray: "siwy",
            white: "biały",
            other: "inny"
        };
        return colorMap[color] || color;
    };

    const formatHair = (hair) => {
        return hair
            .filter(color => color.confidence > 0.1)
            .map(color => `${translateHairColor(color.color)} (${(color.confidence * 100).toFixed(1)}%)`)
            .join(', ');
    };

    if (!faceData || !faceData.faceAttributes) return null;
    const face = faceData;


    const handleSaveData = async () => {
        if (!faceData || !faceData.url) {
            alert("Not found image URL");
            return;
        }

        try {
            const response = await fetch('http://localhost:8081/api/face/save', {
             // const response = await fetch('https://facedetector-production-71e7.up.railway.app/api/face/save', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({url: faceData.url}),
            });

            if (response.ok) {
                alert("Dane zapisane do bazy!");
            } else {
                alert("Błąd podczas zapisu.");
            }
        } catch (error) {
            console.error("Błąd połączenia:", error);

        }
    };

    return (
        <div className="hud-panel">

            <h2 style={{textAlign: "center"}}>Wynik analizy</h2>

            <p><strong>Wiek:</strong> {face.faceAttributes.age}</p>
            <p><strong>Płeć:</strong> {face.faceAttributes.gender.value === 'Male' ? 'Mężczyzna' : 'Kobieta'}</p>
            <p><strong>Uśmiech:</strong> {(face.faceAttributes.smile * 100).toFixed(1)}%</p>
            <p><strong>Okulary:</strong> {face.faceAttributes.glasses === 'NoGlasses' ? 'Nie' : 'Tak'}</p>

            <h4>Emocje:</h4>
            <p><strong>Radość:</strong> {(face.faceAttributes.emotion.happiness).toFixed(1)}%</p>
            <p><strong>Neutralność:</strong> {(face.faceAttributes.emotion.neutral).toFixed(1)}%</p>
            <p><strong>Zaskoczenie:</strong> {(face.faceAttributes.emotion.surprise).toFixed(1)}%</p>
            <p><strong>Smutek:</strong> {(face.faceAttributes.emotion.sadness).toFixed(1)}%</p>
            <p><strong>Złość:</strong> {(face.faceAttributes.emotion.anger).toFixed(1)}%</p>
            <p><strong>Wstręt:</strong> {(face.faceAttributes.emotion.disgust).toFixed(1)}%</p>
            <p><strong>Strach:</strong> {(face.faceAttributes.emotion.fear).toFixed(1)}%</p>

            <h4>Uroda:</h4>
            <p><strong>Ocena przez kobiety:</strong> {face.faceAttributes.beauty.female_score.toFixed(1)}% / 100%</p>
            <p><strong>Ocena przez mężczyzn:</strong> {face.faceAttributes.beauty.male_score.toFixed(1)}% / 100%</p>

            <h4>Stan skóry:</h4>
            <p><strong>Zdrowie:</strong> {face.faceAttributes.skinstatus.health.toFixed(1)}%</p>
            <p><strong>Przebarwienia:</strong> {face.faceAttributes.skinstatus.stain.toFixed(1)}%</p>
            <p><strong>Cienie pod oczami:</strong> {face.faceAttributes.skinstatus.dark_circle.toFixed(1)}%</p>
            <p><strong>Trądzik:</strong> {face.faceAttributes.skinstatus.acne.toFixed(1)}%</p>

            <h4>Włosy:</h4>
            <p><strong>Kolory:</strong> {formatHair(face.faceAttributes.hair.hairColor)}</p>
            <p><strong>Łysina:</strong> {(face.faceAttributes.hair.bald * 100).toFixed(1)}%</p>
            <p><strong>Włosy niewidoczne:</strong> {face.faceAttributes.hair.invisible ? 'Tak' : 'Nie'}</p>

            <h4> Zarost:</h4>
            <p><strong>Wąsy:</strong> {(face.faceAttributes.facialHair.moustache * 100).toFixed(0)}%</p>
            <p><strong>Broda:</strong> {(face.faceAttributes.facialHair.beard * 100).toFixed(0)}%</p>
            <p><strong>Baki:</strong> {(face.faceAttributes.facialHair.sideburns * 100).toFixed(0)}%</p>

            <h4> Makijaż:</h4>
            <p><strong>Oczy:</strong> {face.faceAttributes.makeup.eyeMakeup ? 'Tak' : 'Nie'}</p>
            <p><strong>Usta:</strong> {face.faceAttributes.makeup.lipMakeup ? 'Tak' : 'Nie'}</p>

            <h4>Jakość i ekspozycja:</h4>
            <p>
                <strong>Rozmycie:</strong> {face.faceAttributes.blur.blurLevel} ({(face.faceAttributes.blur.value * 100).toFixed(0)}%)
            </p>
            <p>
                <strong>Ekspozycja:</strong> {face.faceAttributes.exposure.exposureLevel} ({(face.faceAttributes.exposure.value * 100).toFixed(0)}%)
            </p>
            <p>
                <strong>Szum:</strong> {face.faceAttributes.noise.noiseLevel} ({(face.faceAttributes.noise.value * 100).toFixed(0)}%)
            </p>

            <h4>Przesłonięcia:</h4>
            <p><strong>Czoło zakryte:</strong> {face.faceAttributes.occlusion.foreheadOccluded ? 'Tak' : 'Nie'}
            </p>
            <p><strong>Oczy zakryte:</strong> {face.faceAttributes.occlusion.eyeOccluded ? 'Tak' : 'Nie'}</p>
            <p><strong>Usta zakryte:</strong> {face.faceAttributes.occlusion.mouthOccluded ? 'Tak' : 'Nie'}</p>

            <h4> Jakość rozpoznania:</h4>
            <p><strong>Poziom:</strong> {face.faceAttributes.qualityForRecognition}</p>

            {view === "analyze" && (
                <div style={{textAlign: "center", marginTop: "1rem"}}>
                    <button className="save-button" onClick={handleSaveData}>💾 Zapisz dane do bazy</button>
                </div>
            )}
        </div>

    );
};
export default FaceResult;
