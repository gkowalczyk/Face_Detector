import React, { useState } from "react";
import FaceResult from "./components/FaceResult";
import FaceAppForm from "./components/FaceAppForm";

function App() {
    const [faceData, setFaceData] = useState(null);

    const handleImageSubmit = async (url) => {
        try {
            const response = await fetch("http://localhost:8081/api/face", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ url })
            });
            const data = await response.json();
            setFaceData(data);
        } catch (error) {
            console.error("Błąd pobierania danych:", error);
        }
    };

    return (
        <div style={{ padding: "2rem" }}>
            <h2>Analiza twarzy </h2>
            <FaceAppForm onSubmit={handleImageSubmit} />
            <FaceResult faceData={faceData} />
        </div>
    );
}

export default App;
