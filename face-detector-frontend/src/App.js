import React, {useState} from "react";
import FaceResult from "./components/FaceResult";
import FaceAppForm from "./components/FaceAppForm";
import FaceImagePreview from "./components/FaceImagePreview";
import SideBarMenu from "./components/SideBarMenu";
import FaceFilterForm from "./components/FaceFilterForm";

import "./App.css"

function App() {
    const [faceData, setFaceData] = useState(null);
    const [imageUrl, setImageUrl] = useState('');
    const [view, setView] = useState("analyze");
    const [filterData, setFilterData] = useState(null);


    const handleImageSubmit = async (url) => {
        try {
            setImageUrl(url)
            const response = await fetch("https://facedetector-production-71e7.up.railway.app/api/face", {
                //const response = await fetch("http://localhost:8081/api/face", {
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
    }
    const handleFilterSubmit = async (filterData) => {


        try {
            //const response = await fetch("http://localhost:8081/api/face/filter", {
            const response = await fetch("https://facedetector-production-71e7.up.railway.app/api/face/filter", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(filterData)

            });
            console.log("Wysyłane dane filtracji:", filterData);
            const data = await response.json();
            console.log("Odebrane dane z backendu:", data);
            setFilterData(data);

        } catch (error) {
            console.error("Błąd pobierania danych:", error);
        }
    };

    return (
        <div className="app-with-sidebar" style={{display: "flex"}}>
            <div className="sidebar-container">
                <SideBarMenu onMenuItemClick={setView}/>
                {view === "filter" && <FaceFilterForm onFilter={handleFilterSubmit}/>}
            </div>

            <div className="app-container">
                <h1 className="title">RAPORT ANALIZY TWARZY</h1>

                {view === "analyze" && (
                    <>
                        <FaceAppForm onSubmit={handleImageSubmit}/>
                        <div className="content-wrapper">
                            <FaceImagePreview imageUrl={imageUrl} faceData={faceData}/>
                            <FaceResult faceData={faceData}/>
                        </div>
                    </>
                )}

                {view === "filter" && filterData && filterData.map((face, index) => (
                    <div key={index} className="content-wrapper">
                        <FaceImagePreview imageUrl={face.imageUrl} faceData={[face]}/>
                        <FaceResult faceData={[face]}/>
                    </div>
                ))}

                {view === "verify" && (
                    <div className="hud-panel">
                        <p> Analiza twarzy i ocena podobieństwa z wykorzystaniem technologii rozpoznawania
                            biometrycznego - w trakcie tworzenia</p>
                    </div>
                )}

                {view === "about" && (
                    <div className="hud-panel">
                        <h2>O AUTORZE</h2>
                        <p> Autor: Grzegorz Kowalczyk</p>
                        <p>Aplikacja wykorzystuje Azure Face API, Spring Boot i React.</p>
                        <p> Cel: analiza i porównywanie cech twarzy w celach edukacyjnych i demonstracyjnych.</p>
                    </div>
                )}
            </div>
        </div>
    );
}

export default App;