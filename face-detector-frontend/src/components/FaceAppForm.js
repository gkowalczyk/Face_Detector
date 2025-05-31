import React, {useState} from 'react';

const FaceAppForm = ({onSubmit}) => {
    const [imageUrl, setImageUrl] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (imageUrl) {
            onSubmit(imageUrl);
        }
    };

    return (
        <form onSubmit={handleSubmit} className="form-wrapper">
            <input
                className="neon-input"
                type="text"
                value={imageUrl}
                onChange={(e) => setImageUrl(e.target.value)}
                placeholder="Wklej link URL do zdjęcia"
            />
            <button type="submit" className="neon-button">Analizuj</button>
            <div style={{ color: '#ccc', fontSize: '0.85rem', marginTop: '1rem' }}>
                📷 Wymagania dla zdjęcia:<br />
                • Format: JPG, PNG, BMP, WEBP<br />
                • Rozmiar twarzy min. <strong>200x200 px</strong><br />
                • Twarz powinna zajmować ≥ 50% obrazu i być wyśrodkowana<br />
                • Dobrze oświetlona, bez cieni, patrząca na wprost
            </div>
        </form>
    );
};
export default FaceAppForm;
