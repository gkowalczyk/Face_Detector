import React, {useState} from 'react';

const VideoUploadForm = ({onStart}) => {
    const [videoUrl, setVideoUrl] = useState('');
    const [loading, setLoading] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);

        try {
            //const response = await fetch('http://localhost:8081/api/video/add?videoUrl=' + encodeURIComponent(videoUrl), {
                const response = await fetch('https://facedetector-production-71e7.up.railway.app/api/video/add?videoUrl='  + encodeURIComponent(videoUrl), {
                method: 'POST'
            });
            const data = await response.json();
            onStart(data.id);

        } catch (error) {
            console.error("Upload error:", error);
        } finally {
            setLoading(false);

        }
    };
    return (
        <form onSubmit={handleSubmit}>
            <input type="text"
                   value={videoUrl}
                   onChange={(e) => setVideoUrl(e.target.value)}
                   placeholder="Wklej link URL do video"
                   className="neon-input"
            />
            <button type="submit" className="neon-button"> Prześlij</button>
            {loading && <p style={{color: 'white'}}>⏳ Przesyłanie...</p>}
            <div style={{ color: '#ccc', fontSize: '0.85rem', marginTop: '1rem' }}>
                ⚠️ Wideo musi być dostępne publicznie jako plik (np. <code>.mp4</code>).<br />
                Maks. rozmiar: <strong>30 GB</strong>, długość: do <strong>6h</strong>. <br />
                Niedozwolone są linki do YouTube czy Vimeo.
            </div>
        </form>
    );
};
export default VideoUploadForm;



