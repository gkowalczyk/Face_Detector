# 🧠 Face Analysis App

A futuristic full-stack application that analyzes facial features using the **Azure Face API**.  
Built with a **React frontend** and a **Spring Boot backend**, wrapped in a sci-fi inspired user interface.

🌐 **Live demo:** [https://face-detector-app.netlify.app/](https://face-detector-app.netlify.app/)

---

## 📸 Features

- Paste a URL to a photo
- Analyze facial attributes such as:
  - Age, gender, smile
  - Glasses, facial hair, makeup
  - Hair color, baldness, visibility
  - Blur, exposure, noise, recognition quality
- Live canvas preview with bounding box
- Beautiful HUD-style interface
- Full-stack setup using React + Spring Boot + Azure API


---

## 📸 Features

- Paste a URL to a photo and analyze facial attributes
- Extracted features include:
  - ✅ Age, gender, smile
  - ✅ Glasses, facial hair, makeup
  - ✅ Hair color, baldness, visibility
  - ✅ Blur, exposure, noise, quality for recognition
- Live canvas preview with facial bounding box
- Modern neon / HUD-style user interface
- Full-stack architecture:
  - **Frontend:** React 
  - **Backend:** Spring Boot + Azure Face API
  - **Database:** MongoDB Atlas
- Filtering faces by attributes via dynamic form


---

## 💻 Preview

![screenshot](src/main/resources/preview.bmp) 

---
## 🧪 Practical Use Cases

This facial analysis application can be adapted for various real-world scenarios:

- 🔍 **Person Search & Forensics**  
  Match unknown or wanted individuals by analyzing facial traits against a database (without using faceId).

- 🎥 **Video Scene Analysis** *(planned)*  
  Upload video clips to automatically extract frames and analyze faces within them.

- 🧪 **Psychological or Marketing Research**  
  Analyze facial expressions to measure emotions (e.g. smile, attention, or fatigue levels).

- 🛂 **Access Control & Identity Validation**  
  Validate facial features for access systems (e.g., check for glasses, makeup, facial hair).


## 📈 Performance Test Result  (Gatling)

Tests were created for the  `/api/face/filter` endpoint:
- 50 parallel requests
- 100% successful OK
- Average response time: 503 ms
- Maximum response time : 767 ms

👉 [View full report](src/test/java/simulations/index_filter.html)

Tests were created for the  `/api/face` endpoint:
- 50 parallel requests
- 100% successful OK
- Average response time: ~1300–1400 ms — a bit high, but reasonable if the backend is calling an external service
- Maximum response time : 2946ms

👉 [View full report](src/test/java/simulations/index_analyzeByUrl.html)