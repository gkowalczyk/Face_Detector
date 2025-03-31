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
                placeholder="Wklej link do zdjęcia"
            />
            <button type="submit" className="neon-button">Analizuj</button>
        </form>
    );
};
export default FaceAppForm;
