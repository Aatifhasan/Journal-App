# Journal App 📔

An end-to-end encrypted personal journaling application built with Spring Boot. This project features user authentication, journal management, automated sentiment analysis, and integrations with Redis, Kafka, and external Weather APIs.

---

## 🚀 Features

- **User Authentication**: Secure signup and login using Spring Security and JWT.
- **Journal Management**: Full CRUD operations for personal journal entries.
- **Sentiment Analysis**: Automated weekly analysis of journal entries to track emotional trends.
- **Weather Integration**: Real-time weather data fetching with Redis caching for performance.
- **Automated Notifications**: Weekly sentiment reports sent via Kafka or Email.
- **Security**: Environment-based configuration for sensitive credentials.

---

## 🛠️ Tech Stack

- **Backend**: Java 8, Spring Boot 2.7.16
- **Database**: MongoDB (NoSQL)
- **Caching**: Redis
- **Messaging**: Apache Kafka
- **Security**: Spring Security, JWT
- **Build Tool**: Maven
- **Utilities**: Lombok, Spring Scheduler, JavaMailSender

---

## 📋 Prerequisites

Before running the application, ensure you have the following installed:
- JDK 8
- Maven 3.x
- MongoDB (Local or Atlas)
- Redis Server
- Apache Kafka (Local or Confluent Cloud)

---

## ⚙️ Configuration

The application uses `spring-dotenv` to manage sensitive information. Create a `.env` file in the root directory (or set environment variables) with the following keys:

```env
# MongoDB
MONGODB_URI=your_mongodb_uri

# Redis
REDIS_HOST=your_redis_host
REDIS_PORT=your_redis_port
REDIS_PASSWORD=your_redis_password

# Kafka
KAFKA_BOOTSTRAP_SERVERS=your_kafka_bootstrap_servers
KAFKA_USERNAME=your_kafka_username
KAFKA_PASSWORD=your_kafka_password

# Mail (Gmail SMTP)
EMAIL_USERNAME=your_email@gmail.com
EMAIL_PASSWORD=your_app_specific_password

# Weather API
WEATHER_API_KEY=your_weather_api_key
WEATHER_API_URL=https://api.weatherstack.com/current
```

---

## 🏃 Getting Started

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd journalApp
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```
   The application will start on `http://localhost:8080/journal`.

---

## 🛣️ API Endpoints

### Public Endpoints
- `POST /public/signup` - Register a new user.
- `POST /public/login` - Authenticate and receive a JWT.

### Journal Endpoints (Requires JWT)
- `GET /journal` - Get all journal entries for the authenticated user.
- `POST /journal` - Create a new journal entry.
- `GET /journal/id/{id}` - Get a specific entry by ID.
- `PUT /journal/id/{id}` - Update an existing entry.
- `DELETE /journal/id/{id}` - Delete an entry.

### User Endpoints (Requires JWT)
- `PUT /user` - Update user profile (email, password).
- `DELETE /user` - Delete user account.

---

## 🧠 Architecture Overview

1. **Controller Layer**: Handles REST requests and interacts with the Security Context.
2. **Service Layer**: Contains business logic, including transactional journal saving and weather data caching.
3. **Repository Layer**: Interfaces with MongoDB using Spring Data MongoDB.
4. **Scheduler**: A background task (`userScheduler`) runs periodically to calculate user sentiments.
5. **Messaging**: Sentiment data is published to a Kafka topic for asynchronous processing by `SentimentConsumerService`.
