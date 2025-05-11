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
    const [filterData, setFilterData] = useState([]);
    const [matchedData, setMatchedData] = useState([]);

    const handleImageSubmit = async (url) => {
        try {
            setImageUrl(url)
            const response = await fetch("https://facedetector-production-71e7.up.railway.app/api/face", {
              //  const response = await fetch("http://localhost:8081/api/face", {
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

    const handleMachSubmit = async (url) => {
        try {
            setImageUrl(url);
             const response = await fetch("https://facedetector-production-71e7.up.railway.app/api/face/getSimilar", {
           // const response = await fetch("http://localhost:8081/api/face/getSimilar", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({url})
            });
            const data = await response.json();
            setMatchedData(data);
        } catch(error) {
            console.error("Błąd pobierania danych:", error);
        }
    }


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
                            <FaceResult faceData={faceData} view={view} />
                        </div>
                    </>
                )}

                {view === "filter" && (
                    <>
                        {filterData.length === 0 ? (
                            <div className="hud-panel">
                                <p style={{ color: "white", textAlign: "center" }}>Brak wyników pasujących do filtrów.</p>
                            </div>
                        ) : (
                            filterData.map((face, index) => (
                                <div key={index} className="content-wrapper">
                                    <FaceImagePreview imageUrl={face.url} faceData={face}/>
                                    <FaceResult faceData={face} view={view} />
                                </div>
                            ))
                        )}
                    </>
                )}

                {view === "verify" && (
                    <>
                        <FaceAppForm onSubmit={handleMachSubmit}/>
                        {matchedData.length === 0 ? (
                            <div className="hud-panel">
                                <p style={{ color: "white", textAlign: "center" }}>Brak wyników z dopasowaniem.
                                Interfejs zwraca 3 najbardziej dopasowane twarze.</p>
                            </div>
                        ) : (
                            matchedData.map((face, index) => (
                                <div key={index} className="content-wrapper">
                                    <FaceImagePreview imageUrl={face.url} faceData={face}/>
                                    <FaceResult faceData={face} view={view} />
                                </div>
                            ))
                        )}
                    </>
                )}

                {view === "about" && (
                    <div className="hud-panel">
                        <h2>O AUTORZE</h2>
                        <p><strong>Autor:</strong> Grzegorz Kowalczyk</p>

                        <h4>🛠 Technologie</h4>
                        <ul>
                            <li>Frontend: React.js</li>
                            <li>Backend: Spring Boot WebFlux + MongoDB</li>
                            <li>AI: Azure Face API + Face++</li>
                        </ul>

                        <h4>🎯 Funkcjonalności aplikacji</h4>
                        <ul>
                            <li>Analiza twarzy z obrazów URL</li>
                            <li>Wizualizacja cech: wiek, emocje, zarost, okulary, makijaż</li>
                            <li>Filtrowanie twarzy z bazy danych</li>
                            <li>Weryfikacja tożsamości – porównywanie twarzy</li>
                            <li>Zapis dopasowań do bazy danych (MongoDB)</li>
                        </ul>

                        <h4>💡 Oparte na technologii Azure AI Face</h4>
                        <p>
                            Aplikacja wykorzystuje Azure AI Face Service, która to dostarcza algorytmy do wykrywania, rozpoznawania i analizowania ludzkich twarzy w obrazach. Przykładowe scenariusze użycia to:
                        </p>
                        <ul>
                            <li> Weryfikacja tożsamości użytkownika (one-to-one)</li>
                            <li> Identyfikacja twarzy w grupie (one-to-many)</li>
                            <li> Kontrola dostępu bezdotykowego</li>
                            <li> Analiza emocji i atrybutów (wiek, zarost, uczesanie itd.)</li>
                            <li> Detekcja liveness (czy osoba jest fizycznie obecna)</li>
                        </ul>

                                               <p><strong>Repozytorium projektu:</strong> <br />
                                                   <a href="https://github.com/..." target="_blank" rel="noreferrer">
                                https://github.com/gkowalczyk/Face_Detector
                            </a></p>
                        <h4>📸 Wymagania dotyczące zdjęć</h4>
                        <p>W celu skutecznej analizy twarzy, przesyłane zdjęcia muszą spełniać poniższe wymagania techniczne i jakościowe:</p>

                        <ul>
                            <li><strong>Format pliku:</strong> JPEG, PNG, BMP, WEBP (brak wsparcia dla TIFF, HEIC)</li>
                            <li><strong>Maksymalny rozmiar pliku:</strong> 6 MB</li>
                            <li><strong>Zalecany rozmiar twarzy:</strong> co najmniej 200x200 pikseli</li>
                            <li><strong>Twarz powinna zajmować min. 50% zdjęcia i być wyśrodkowana</strong></li>
                            <li><strong>Oświetlenie:</strong> zdjęcie dobrze doświetlone, bez cieni i bez efektu czerwonych oczu</li>
                            <li><strong>Pozycja:</strong> twarz zwrócona na wprost, oczy otwarte, usta zamknięte, brak przechylenia głowy</li>
                            <li><strong>Jedna twarz na zdjęciu</strong> – aplikacja analizuje tylko jedną osobę</li>
                        </ul>

                        <h4>🚫 Unikać:</h4>
                        <ul>
                            <li>Okularów przeciwsłonecznych, maseczek, czapek, słuchawek zakrywających twarz</li>
                            <li>Zdjęć z niską jakością (rozmycie, szum, słaba rozdzielczość)</li>
                            <li>Tła z dużym kontrastem lub z elementami rozpraszającymi</li>
                                                    </ul>
                    </div>
                )}
            </div>
        </div>
    );
}

export default App;