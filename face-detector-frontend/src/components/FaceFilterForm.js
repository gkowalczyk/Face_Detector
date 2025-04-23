import React, {useState} from "react";

const FaceFilterForm = ({onFilter}) => {
    const [formData, setFormData] = useState({
        ageMin: "0",
        ageMax: "100",
        smileMin: "",
        smileMax: "",
        moustacheMin: "",
        moustacheMax: "",
        beardMin: "",
        beardMax: "",
        sideburnsMin: "",
        hairBaldMin: "",
        hairBaldMax: "",
        sideburnsMax: "",
        glasses: "",
        makeup: {eyeMakeup: '', lipMakeup: ''},
        occlusion: {foreheadOccluded: '', eyeOccluded: '', mouthOccluded: ''},
        hairColor: ""
    });

    const handleChange = (e) => {
        const {name, value, type, checked} = e.target;

        const keys = name.split(".");

        const finalValue = type === "checkbox" ? checked : value;

        if (keys.length === 2) {
            const [parentKey, childKey] = keys;
            setFormData((prevData) => ({
                ...prevData,
                [parentKey]: {
                    ...prevData[parentKey],
                    [childKey]: finalValue,
                },
            }));
        } else {
            setFormData((prevData) => ({
                ...prevData,
                [name]: finalValue,
            }));
        }
    };


    const handleSubmit = (e) => {
        e.preventDefault();
        onFilter(formData);
    };
    return (
        <form onSubmit={handleSubmit} className="filter-form">

            <div>
                <label>Wiek od:</label>
                <input
                    type="number"
                    name="ageMin"
                    value={formData.ageMin}
                    onChange={handleChange}
                />
            </div>

            <div>
                <label>Wiek do:</label>
                <input
                    type="number"
                    name="ageMax"
                    value={formData.ageMax}
                    onChange={handleChange}
                />
            </div>


            <div>
                <label>Uśmiech:</label>
                <select name="smileRange" onChange={(e) => {
                    const value = e.target.value;
                    if (value === "yes") {
                        setFormData(prev => ({...prev, smileMin: 0.5, smileMax: 1.0}));
                    } else if (value === "no") {
                        setFormData(prev => ({...prev, smileMin: 0.0, smileMax: 0.49}));
                    } else if (value === "") {
                        setFormData(prev => ({...prev, smileMin: "", smileMax: ""}));
                    }
                }}>
                    <option value="">Dowolny</option>
                    <option value="yes">Tak</option>
                    <option value="no">Nie</option>
                </select>
            </div>

            <div>
                <label>Wąsy:</label>
                <select name="moustacheRange" onChange={(e) => {
                    const value = e.target.value;
                    if (value === "yes") {
                        setFormData(prev => ({...prev, moustacheMin: 0.5, moustacheMax: 1.0}));
                    } else if (value === "no") {
                        setFormData(prev => ({...prev, moustacheMin: 0.0, moustacheMax: 0.49}));
                    } else {
                        setFormData(prev => ({...prev, moustacheMin: "", moustacheMax: ""}));
                    }
                }}>
                    <option value="">Dowolnie</option>
                    <option value="yes">Tak</option>
                    <option value="no">Nie</option>
                </select>
            </div>

            <div>
                <label>Broda:</label>
                <select name="beardRange" onChange={(e) => {
                    const value = e.target.value;
                    if (value === "yes") {
                        setFormData(prev => ({...prev, beardMin: 0.5, beardMax: 1.0}));
                    } else if (value === "no") {
                        setFormData(prev => ({...prev, beardMin: 0.0, beardMax: 0.49}));
                    } else {
                        setFormData(prev => ({...prev, beardMin: "", beardMax: ""}));
                    }
                }}>
                    <option value="">Dowolnie</option>
                    <option value="yes">Tak</option>
                    <option value="no">Nie</option>
                </select>
            </div>

            <div>
                <label>Baki:</label>
                <select name="sideburnsRange" onChange={(e) => {
                    const value = e.target.value;
                    if (value === "yes") {
                        setFormData(prev => ({...prev, sideburnsMin: 0.5, sideburnsMax: 1.0}));
                    } else if (value === "no") {
                        setFormData(prev => ({...prev, sideburnsMin: 0.0, sideburnsMax: 0.49}));
                    } else {
                        setFormData(prev => ({...prev, sideburnsMin: "", sideburnsMax: ""}));
                    }
                }}>
                    <option value="">Dowolnie</option>
                    <option value="yes">Tak</option>
                    <option value="no">Nie</option>
                </select>
            </div>

            <div>
                <label>Okulary:</label>
                <select name="glasses" onChange={(e) => {
                    const value = e.target.value;
                    if (value === "ReadingGlasses") {
                        setFormData(prev => ({...prev, glasses: "ReadingGlasses"}));
                    } else if (value === "NoGlasses") {
                        setFormData(prev => ({...prev, glasses: "NoGlasses"}));
                    } else if (value === "Sunglasses") {
                        setFormData(prev => ({...prev, glasses: "Sunglasses"}));
                    } else if (value === "SwimmingGoggles") {
                        setFormData(prev => ({...prev, glasses: "SwimmingGoggles"}));
                    } else {
                        setFormData(prev => ({...prev, glasses: ""}));
                    }
                }}>
                    <option value="">Dowolne</option>
                    <option value="NoGlasses">Nie</option>
                    <option value="ReadingGlasses">Okulary do czytania</option>
                    <option value="Sunglasses">Okulary przeciwsłoneczne</option>
                    <option value="SwimmingGoggles">Okulary pływackie</option>

                </select>
            </div>

            <div>
                <label>Makijaż oczu:</label>
                <select
                    name="makeup.eyeMakeup"
                    value={formData.makeup.eyeMakeup}
                    onChange={handleChange}
                >
                    <option value="">Dowolne</option>
                    <option value="true">Tak</option>
                    <option value="false">Nie</option>
                </select>
            </div>

            <div>
                <label>Makijaż ust:</label>
                <select
                    name="makeup.lipMakeup"
                    value={formData.makeup.lipMakeup}
                    onChange={handleChange}
                >
                    <option value="">Dowolne</option>
                    <option value="true">Tak</option>
                    <option value="false">Nie</option>
                </select>
            </div>

            <div>
                <label>Czoło zakryte:</label>
                <select
                    name="occlusion.foreheadOccluded"
                    value={formData.occlusion.foreheadOccluded}
                    onChange={handleChange}
                >
                    <option value="">Dowolne</option>
                    <option value="true">Tak</option>
                    <option value="false">Nie</option>
                </select>
            </div>


            <div>
                <label>Usta zakryte:</label>
                <select
                    name="occlusion.mouthOccluded"
                    value={formData.occlusion.mouthOccluded}
                    onChange={handleChange}
                >
                    <option value="">Dowolne</option>
                    <option value="true">Tak</option>
                    <option value="false">Nie</option>
                </select>
            </div>

            <div>
                <label>Oczy zakryte</label>
                <select
                    name="occlusion.eyeOccluded"
                    value={formData.occlusion.eyeOccluded}
                    onChange={handleChange}
                >
                    <option value="">Dowolne</option>
                    <option value="true">Tak</option>
                    <option value="false">Nie</option>
                </select>
            </div>

            <div>
                <label>Łysina:</label>
                <select name="hairBaldRange" onChange={(e) => {
                    const value = e.target.value;
                    if (value === "yes") {
                        setFormData(prev => ({...prev, hairBaldMin: 0.5, hairBaldMax: 1.0}));
                    } else if (value === "no") {
                        setFormData(prev => ({...prev, hairBaldMin: 0.0, hairBaldMax: 0.49}));
                    } else {
                        setFormData(prev => ({...prev, hairBaldMin: "", hairBaldMax: ""}));
                    }
                }}>
                    <option value="">Dowolnie</option>
                    <option value="yes">Tak</option>
                    <option value="no">Nie</option>
                </select>

            </div>

            <div>
                <label>Kolor włosów:</label>
                <select name="hairColor" value={formData.hairColor} onChange={handleChange}>
                    <option value="">Dowolny</option>
                    <option value="black">Czarny</option>
                    <option value="brown">Brązowy</option>
                    <option value="blond">Blond</option>
                    <option value="red">Rudy</option>
                    <option value="gray">Siwy</option>
                    <option value="white">Biały</option>
                    <option value="unknown">Inny</option>
                </select>
            </div>

            <button type="submit">Filtruj</button>
        </form>
    );
};

export default FaceFilterForm;
