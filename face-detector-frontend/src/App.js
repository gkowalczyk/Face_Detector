import React, {useState} from "react";
import FaceResult from "./components/FaceResult";
import FaceAppForm from "./components/FaceAppForm";
import FaceImagePreview from "./components/FaceImagePreview";
import "./App.css"

function App() {
    const [faceData, setFaceData] = useState(null);
    const [imageUrl, setImageUrl] = useState('');


    const handleImageSubmit = async (url) => {
        try {
            setImageUrl(url)
            const response = await fetch("https://facedetector-production-71e7.up.railway.app/api/face", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({url})
            });
            const data = await response.json();
            setFaceData(data);

        } catch (error) {
            console.error("Błąd pobierania danych:", error);
        }
    };

    return (
        <div className="app-container">
            <h1 className="title">RAPORT ANALIZY TWARZY</h1>
            <FaceAppForm onSubmit={handleImageSubmit}/>
            <div className="content-wrapper">
                <FaceImagePreview imageUrl={imageUrl} faceData={faceData}/>
                <FaceResult faceData={faceData}/>
            </div>
        </div>
            );
            }

            export default App;
