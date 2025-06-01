# 🧠 Face Analysis App

A futuristic full-stack application that analyzes facial features using **Azure Face API** and **Face++**.  
Built with a **React frontend**, **Spring Boot backend**, and a **MongoDB Atlas** database.

🌐 **Live demo:** [https://face-detector-app.netlify.app/](https://face-detector-app.netlify.app/)

---

## 📸 Features

- Submit a photo URL and analyze facial attributes
- Extracted features include:
  - ✅ Age, gender, smile
  - ✅ Glasses, facial hair, makeup
  - ✅ Hair color, baldness, visibility
  - ✅ Blur, exposure, noise, recognition quality
- Live canvas preview with facial bounding box
- Filter faces by attributes using a dynamic form
- Full-stack architecture:
  - **Frontend:** React
  - **Backend:** Spring Boot
  - **APIs:** Azure Face API + Face++
  - **Database:** MongoDB Atlas

---

## 🧪 Practical Use Cases

- 🔍 **Person Search & Forensics**  
  Identify unknown or wanted individuals by analyzing facial traits and matching them to a stored database.

- 🎥 **Video Scene Analysis**  
  Upload videos, extract frames based on face detection timestamps, and analyze facial features.

- 🧪 **Psychological or Marketing Research**  
  Examine expressions to assess engagement, happiness, or fatigue.

- 🛂 **Access Control & Identity Validation**  
  Analyze detailed features to support identity verification in secure environments.

---

## 📈 Performance Test Result (Gatling)

**`/api/face/filter`**
- 50 parallel requests
- 100% success
- Avg: 503 ms
- Max: 767 ms  
  👉 [View report](src/test/java/simulations/index_filter.html)

**`/api/face`**
- 50 parallel requests
- 100% success
- Avg: ~1300–1400 ms
- Max: 2946 ms  
  👉 [View report](src/test/java/simulations/index_analyzeByUrl.html)

---

## 🧩 System Architecture & Workflow

### 🔹 General Overview

- Purpose: Analyze, compare, filter and store face data. Detect faces in images and videos using external APIs.
- Technologies: React, Spring Boot, MongoDB Atlas, Azure Face API, Face++, FFmpeg

### 🔹 API Documentation

- Swagger UI: [View here](https://facedetector-production-71e7.up.railway.app/webjars/swagger-ui/index.html)

---

## 🧬 Data Mapping (Java DTOs)

### Class: `FaceObject`

| JSON Key       | Field         | Type           | Description                                 |
|----------------|---------------|----------------|---------------------------------------------|
| face_token     | faceToken     | String         | Unique face ID                              |
| url            | url           | String         | Source image URL                            |
| faceRectangle  | faceRectangle | FaceRectangle  | Bounding box of the detected face           |
| faceLandmarks  | faceLandmarks | FaceLandmarks  | Key facial landmarks (eyes, nose, mouth...) |
| faceAttributes | faceAttributes| FaceAttributes | Attributes extracted from the face          |

### Class: `FaceAttributes`

Includes fields such as:
- `smile`, `age`, `gender`
- `facialHair`, `glasses`, `makeup`
- `blur`, `exposure`, `noise`
- `occlusion`, `hair`, `emotion`, `beauty`, `skinStatus`

Nested objects:
- `HeadPose`, `FacialHair`, `Blur`, `Exposure`, `Noise`, `Hair`, `Emotion`, `Makeup`, `Occlusion`, `SkinStatus`, `Beauty`

---

## 🔍 Filtering Faces

- The endpoint `/api/face/filter` accepts a `FaceAttributeRequestDto` object
- Server compares attributes to stored data
- Returns a reactive `Flux<FaceObject>` stream that matches the filtering criteria

---

## 🧠 Face Matching by Image

- The method `getSimilarFaces(ImgUrl)` queries the Face++ API
- Similar face tokens are retrieved
- The service matches these tokens with database entries and returns a `Flux<FaceObject>`

---

## 🎥 Face Detection from Video

1. Video is uploaded to Azure using `uploadVideo(...)` via `AzureVideoIndexClient`
2. After Azure completes indexing, `analyzeVideo(...)` is called
3. Timestamps for detected faces are returned
4. `VideoFrameExtractor` uses FFmpeg to extract image frames based on timestamps
5. Extracted images are analyzed and saved as `FaceObject` entries

---

## 🎞️ Demo Recordings

- 🎥 [Face Analysis](https://github.com/gkowalczyk/Face_Detector/blob/main/src/main/resources/analiza_twarzy.mp4)
- 🎥 [Filtering Faces](https://github.com/gkowalczyk/Face_Detector/blob/main/src/main/resources/filtrowanie_twarzy.mp4)
- 🎥 [Video Analysis](https://github.com/gkowalczyk/Face_Detector/blob/main/src/main/resources/analiza%20z%20video.mp4)
- 🎥 [Identity Verification](https://github.com/gkowalczyk/Face_Detector/blob/main/src/main/resources/weryfikacja_to%C5%BCsamosci.mp4)

---

## 🧩 Design Patterns Used

- **Adapter Pattern** – combines and normalizes results from Azure and Face++ APIs
- **Builder Pattern** – for constructing filtering requests 
- **Reactive Programming** – uses `Mono` and `Flux` (Spring WebFlux)

---

## 🚀 Future Improvements & Commercial Potential

Planned and potential enhancements include:

- 📊 **PDF Reporting**  
  Export analysis results and match reports as downloadable PDF files for archival and audit purposes.

- 🔐 **User Authentication & Roles**  
  Implement login and registration with role-based access (e.g., admin vs. investigator).

- 🎞️ **Video & Face Review Interface**  
  Add a dedicated layout to browse uploaded videos, review extracted frames, and inspect detected faces.

- 🧑‍💼 **Missing Persons Database**  
  Build and manage a structured database of wanted or missing individuals for identity verification.

- 📝 **Custom Metadata Input**  
  Allow users to input personal details (e.g., name, ID, case number) to associate with analyzed faces.

- 📂 **Face Analysis History & Audit Trail**  
  Maintain a searchable history of past analyses, including timestamps and user activity logs.

- 📶 **Live RTSP Stream Support**  
  Analyze faces in real time from security camera feeds or public IP cameras.

- 🌐 **Multilingual Interface**  
  Add language switching (e.g., English/Polish) for international or public safety use cases.

- 📡 **WebSocket Notifications**  
  Use WebSockets to notify frontend in real time when video analysis is complete or faces are detected.

- 🧠 **LLM Integration (e.g., GPT)**  
  Summarize emotional profiles, suggest matches, or provide context-aware insights using AI models.

- 🧪 **Batch Upload & Analysis Mode**  
  Support uploading and processing multiple images or videos in one session.

- 📊 **Dashboard Analytics**  
  Provide admin users with statistical summaries (e.g., most common age range, smile level trends).

- 🔒 **Secure API Key Access**  
  Add authentication tokens for controlled access to public endpoints.

- 📎 **Integration with External Databases (e.g., Interpol)**  
  Match detected faces against global datasets via standardized APIs.