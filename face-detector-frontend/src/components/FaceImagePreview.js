import React, { useEffect, useRef } from "react";

const FaceImagePreview = ({ imageUrl, faceData }) => {
    const canvasRef = useRef(null);

    useEffect(() => {
        if (!imageUrl || !faceData || !faceData.faceRectangle) return;

        const canvas = canvasRef.current;
        const ctx = canvas.getContext("2d");
        const img = new Image();
        img.src = imageUrl;

        img.onload = () => {
            canvas.width = img.width;
            canvas.height = img.height;
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            ctx.drawImage(img, 0, 0);

            const { faceRectangle, faceLandmarks } = faceData;

            ctx.strokeStyle = "#00ffff";
            ctx.lineWidth = 3;
            ctx.shadowColor = "#00ffff";
            ctx.shadowBlur = 15;
            ctx.strokeRect(
                faceRectangle.left,
                faceRectangle.top,
                faceRectangle.width,
                faceRectangle.height
            );


            if (faceLandmarks) {
                ctx.fillStyle = "lime";
                ctx.shadowColor = "lime";
                ctx.shadowBlur = 10;

                Object.entries(faceLandmarks).forEach(([name, point]) => {
                    ctx.beginPath();
                    ctx.arc(point.x, point.y, 3, 0, 2 * Math.PI);
                    ctx.fill();
                });
            }
        };
    }, [imageUrl, faceData]);

    if (!imageUrl || !faceData || !faceData.faceRectangle) {
        return null;
    }

    return (
        <div className="hud-frame">
            <h2 className="preview-title">PODGLĄD TWARZY</h2>
            <div className="hud-canvas-wrapper">
                <canvas ref={canvasRef} className="canvas-frame" />
            </div>
        </div>
    );
};

export default FaceImagePreview;
