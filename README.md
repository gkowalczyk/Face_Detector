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

### 🔹 Face Analysis
<video src="https://github.com/gkowalczyk/Face_Detector/raw/main/src/main/resources/analiza_twarzy.mp4" controls width="600"></video>

### 🔹 Filtering Faces
<video src="https://github.com/gkowalczyk/Face_Detector/raw/main/src/main/resources/filtrowanie_twarzy.mp4" controls width="600"></video>

### 🔹 Video Analysis
<video src="https://github.com/gkowalczyk/Face_Detector/raw/main/src/main/resources/analiza%20z%20video.mp4" controls width="600"></video>

### 🔹 Identity Verification
<video src="https://github.com/gkowalczyk/Face_Detector/raw/main/src/main/resources/weryfikacja_to%C5%BCsamosci.mp4" controls width="600"></video>
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


# 🧠 Aplikacja do analizy twarzy

Futurystyczna aplikacja full-stack analizująca cechy twarzy z wykorzystaniem **Azure Face API** oraz **Face++**.  
Zbudowana z użyciem **frontendu w React**, **backendu w Spring Boot** oraz bazy danych **MongoDB Atlas**.

🌐 **Demo online:** [https://face-detector-app.netlify.app/](https://face-detector-app.netlify.app/)

---

## 📸 Funkcje

- Wprowadzenie adresu URL zdjęcia i analiza atrybutów twarzy
- Wykrywane cechy obejmują:
  - ✅ Wiek, płeć, uśmiech
  - ✅ Okulary, zarost, makijaż
  - ✅ Kolor włosów, łysienie, widoczność włosów
  - ✅ Rozmycie, ekspozycja, szumy, jakość rozpoznania
- Podgląd twarzy na canvasie z ramką
- Filtrowanie twarzy na podstawie wybranych atrybutów
- Architektura full-stack:
  - **Frontend:** React
  - **Backend:** Spring Boot
  - **API:** Azure Face API + Face++
  - **Baza danych:** MongoDB Atlas

---

## 🧪 Praktyczne zastosowania

- 🔍 **Wyszukiwanie osób i kryminalistyka**  
  Identyfikacja nieznanych lub poszukiwanych osób na podstawie analizy twarzy i dopasowania do bazy.

- 🎥 **Analiza scen wideo**  
  Wysyłanie wideo, wyodrębnianie klatek na podstawie czasów wykrycia twarzy i analiza cech.

- 🧪 **Badania psychologiczne lub marketingowe**  
  Analiza mimiki w celu oceny zaangażowania, zadowolenia lub zmęczenia.

- 🛂 **Kontrola dostępu i weryfikacja tożsamości**  
  Analiza cech twarzy w celu wspomagania systemów bezpieczeństwa.

---

## 📈 Wyniki testów wydajnościowych (Gatling)

**`/api/face/filter`**
- 50 równoległych żądań
- 100% sukcesu
- Średni czas: 503 ms
- Maksymalny czas: 767 ms  
  👉 [Zobacz raport](src/test/java/simulations/index_filter.html)

**`/api/face`**
- 50 równoległych żądań
- 100% sukcesu
- Średni czas: ~1300–1400 ms
- Maksymalny czas: 2946 ms  
  👉 [Zobacz raport](src/test/java/simulations/index_analyzeByUrl.html)

---

## 🧩 Architektura systemu i przetwarzanie

### 🔹 Przegląd ogólny

- Cel: analiza, porównanie, filtrowanie i zapisywanie danych twarzy. Wykrywanie twarzy na zdjęciach i filmach przy użyciu zewnętrznych API.
- Technologie: React, Spring Boot, MongoDB Atlas, Azure Face API, Face++, FFmpeg

### 🔹 Dokumentacja API

- Swagger UI: [Zobacz tutaj](https://facedetector-production-71e7.up.railway.app/webjars/swagger-ui/index.html)

---

## 🧬 Mapowanie danych (DTO Java)

### Klasa: `FaceObject`

| Klucz JSON      | Pole           | Typ            | Opis                                       |
|----------------|----------------|----------------|--------------------------------------------|
| face_token     | faceToken      | String         | Unikalny identyfikator twarzy              |
| url            | url            | String         | URL źródła zdjęcia                         |
| faceRectangle  | faceRectangle  | FaceRectangle  | Ramka ograniczająca twarz                  |
| faceLandmarks  | faceLandmarks  | FaceLandmarks  | Punkty charakterystyczne (oczy, nos, usta) |
| faceAttributes | faceAttributes | FaceAttributes | Wykryte cechy twarzy                       |

### Klasa: `FaceAttributes`

Zawiera m.in. pola:
- `smile`, `age`, `gender`
- `facialHair`, `glasses`, `makeup`
- `blur`, `exposure`, `noise`
- `occlusion`, `hair`, `emotion`, `beauty`, `skinStatus`

Obiekty zagnieżdżone:
- `HeadPose`, `FacialHair`, `Blur`, `Exposure`, `Noise`, `Hair`, `Emotion`, `Makeup`, `Occlusion`, `SkinStatus`, `Beauty`

---

## 🔍 Filtrowanie twarzy

- Endpoint `/api/face/filter` przyjmuje obiekt `FaceAttributeRequestDto`
- Serwer porównuje atrybuty z zapisanymi w bazie danych
- Zwraca strumień `Flux<FaceObject>` spełniający kryteria filtrujące

---

## 🧠 Dopasowanie twarzy ze zdjęcia

- Metoda `getSimilarFaces(ImgUrl)` wysyła zapytanie do Face++
- Zwracane są identyfikatory podobnych twarzy (`faceToken`)
- Serwis dopasowuje je do danych w bazie i zwraca `Flux<FaceObject>`

---

## 🎥 Wykrywanie twarzy z wideo

1. Wideo jest przesyłane do Azure przez `uploadVideo(...)` (`AzureVideoIndexClient`)
2. Po zakończeniu indeksowania, wywoływana jest metoda `analyzeVideo(...)`
3. Otrzymywane są czasy wystąpienia twarzy
4. `VideoFrameExtractor` używa FFmpeg do wycięcia odpowiednich klatek
5. Obrazy są analizowane i zapisywane jako obiekty `FaceObject`

---

## 🎞️ Nagrania demo

### 🔹 Face Analysis
<video src="https://github.com/gkowalczyk/Face_Detector/raw/main/src/main/resources/analiza_twarzy.mp4" controls width="600"></video>

### 🔹 Filtering Faces
<video src="https://github.com/gkowalczyk/Face_Detector/raw/main/src/main/resources/filtrowanie_twarzy.mp4" controls width="600"></video>

### 🔹 Video Analysis
<video src="https://github.com/gkowalczyk/Face_Detector/raw/main/src/main/resources/analiza%20z%20video.mp4" controls width="600"></video>

### 🔹 Identity Verification
<video src="https://github.com/gkowalczyk/Face_Detector/raw/main/src/main/resources/weryfikacja_to%C5%BCsamosci.mp4" controls width="600"></video>
---

## 🧩 Zastosowane wzorce projektowe

- **Wzorzec adaptera (Adapter)** – łączy dane z API Azure i Face++ w spójną strukturę
- **Wzorzec budowniczego (Builder)** – do budowy obiektów filtrujących
- **Programowanie reaktywne** – użycie `Mono` i `Flux` (Spring WebFlux)

---

## 🚀 Plany rozwoju i potencjał komercyjny

Planowane i możliwe do wdrożenia rozszerzenia:

- 📊 **Eksport raportów do PDF**
- 🔐 **Logowanie i rejestracja użytkowników z podziałem na role**
- 🎞️ **Interfejs do przeglądania filmów, klatek i wykrytych twarzy**
- 🧑‍💼 **Baza osób poszukiwanych i możliwość porównania twarzy z rekordami**
- 📝 **Dodawanie danych personalnych do analizowanych twarzy**
- 📂 **Historia analiz i logi aktywności użytkowników**
- 📶 **Obsługa strumieni RTSP (kamery IP)**
- 🌐 **Wielojęzyczny interfejs (np. angielski/polski)**
- 📡 **WebSocket – powiadomienia w czasie rzeczywistym**
- 🧠 **Integracja z AI (np. GPT/LLM) do interpretacji wyników**
- 🧪 **Tryb wsadowy – analiza wielu plików naraz**
- 📊 **Dashboard z analizami statystycznymi (np. najczęstszy wiek)**
- 🔒 **Autoryzacja tokenami API**
- 📎 **Integracja z zewnętrznymi bazami danych (np. Interpol)**
