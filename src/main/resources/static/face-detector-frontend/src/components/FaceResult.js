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



                </div>
            ))}
        </div>
    );
};
export default FaceResult;
