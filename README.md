# 🌾 KisanMitra – Backend API

KisanMitra is a Smart Agriculture Backend System built using Java, Spring Boot, and MySQL. It helps farmers manage crops, report diseases, get fertilizer recommendations, and check market prices through REST APIs.

---

# 🚀 Features

- User Registration & Login
- Crop Management
- Disease Reporting
- Fertilizer Recommendation
- Market Price Tracking
- RESTful APIs
- MySQL Database Integration

---

# 🛠️ Tech Stack

## Backend
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

## Database
- MySQL

## Tools
- Postman
- Git & GitHub
- VS Code

---

# 📂 Project Structure

```text
backend/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/
│   │   │   ├── entity/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── BackendApplication.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── pom.xml
└── mvnw
```

---

# 🔗 REST APIs

## 👤 User APIs

### Register User
```http
POST /api/users/auth/register
```

```json
{
  "name": "Prachi",
  "email": "prachi@gmail.com",
  "password": "123456",
  "phone": "9876543210",
  "village": "Amravati"
}
```

### Login User
```http
POST /api/users/auth/login
```

```json
{
  "email": "prachi@gmail.com",
  "password": "123456"
}
```

---

## 🌾 Crop APIs

### Add Crop
```http
POST /api/crops/add
```

```json
{
  "cropName": "Wheat",
  "soilType": "Black Soil",
  "season": "Rabi",
  "sowingDate": "2026-11-10",
  "harvestDate": "2027-03-20",
  "user": {
    "id": 101
  }
}
```

### Update Crop
```http
PUT /api/crops/update-crop/2001
```

### Delete Crop
```http
DELETE /api/crops/delete/2001
```

---

## 🍂 Disease Report APIs

### Add Disease Report
```http
POST /api/diseases/add-report
```

```json
{
  "imageUrl": "https://example.com/wheat.jpg",
  "description": "Leaves are turning yellow",
  "user": {
    "id": 101
  }
}
```

### Update Disease Report
```http
PUT /api/diseases/update-report/7771
```

### Delete Disease Report
```http
DELETE /api/diseases/delete/7771
```

---

## 🌱 Fertilizer APIs

### Get All Fertilizers
```http
GET /api/fertilizers
```

### Get Recommendation
```http
GET /api/fertilizers/recommend?cropType=Cotton&soilType=Red Soil
```

---

## 💰 Market APIs

### Get Market Prices
```http
GET /api/market
```

### Search Market Price
```http
GET /api/market/search?cropName=Wheat
```

---

# ▶️ Run Project

## Clone Repository

```bash
git clone https://github.com/prachu25/KisanMitra.git
```

## Navigate to Backend

```bash
cd backend
```

## Run Application

```bash
.\mvnw.cmd spring-boot:run
```

---

# ⚙️ Configuration

Create:

```text
src/main/resources/application.properties
```

Add:

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

---

# 🧪 API Testing

- Postman
- Thunder Client

---

# ✨ Future Improvements

- JWT Authentication
- Weather API
- Image Upload
- AI Disease Detection

---

# 📌 Author

Prachi Gorde

Java Developer | Spring Boot | MySQL
