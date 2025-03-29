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
        <form onSubmit={handleSubmit} style={{marginBottom: "1rem"}}>
            <input
                type="text"
                value={imageUrl}
                onChange={(e) => setImageUrl(e.target.value)}
                placeholder="Wklej link do zdjęcia"
                style={{width: "300px", padding: "8px"}}/>
            <button type="submit" style={{padding: "8px", marginLeft: "1rem"}}>Analizuj</button>
        </form>
    );
};
export default FaceAppForm;
