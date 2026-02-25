 Weather API – Spring Boot Application 

 Overview

The Weather API is a RESTful backend application built using Spring Boot. It provides endpoints to retrieve weather data within a specific date range and generate monthly temperature statistics such as minimum, maximum, and median values. The application uses MySQL for data storage and Spring Data JPA for database operations.

This project demonstrates clean architecture using Controller, Service, and Repository layers.

---

 Features

* Retrieve weather records between two date-time ranges
* Calculate monthly temperature statistics:

  * Minimum temperature
  * Maximum temperature
  * Median temperature
* MySQL database integration
* RESTful API design
* Layered architecture (Controller, Service, Repository)
* Maven-based project structure

---

 Tech Stack

* Java 21
* Spring Boot 3
* Spring Data JPA
* Hibernate ORM
* MySQL Database
* Maven
* REST API

---

 Project Structure

```
WeatherAPI
│
├── controller
│   └── WeatherController.java
│
├── service
│   └── WeatherService.java
│
├── serviceImpl
│   └── WeatherServiceImpl.java
│
├── repository
│   └── WeatherRepository.java
│
├── entity
│   └── Weather.java
│
├── resources
│   ├── application.properties
│   └── testset.csv
│
└── WeatherApplication.java
```

---
 API Endpoints

 1. Get Weather Data by Date Range

Endpoint:

```
GET /weather/range
```

Parameters:

```
start – Start date-time
end – End date-time
```

Example:

```
GET /weather/range?start=2024-01-01T00:00:00&end=2024-01-31T23:59:59
```

---

 2. Get Monthly Temperature Statistics

Endpoint:

```
GET /weather/monthly-stats
```

Parameter:

```
year – Year value
```

Example:

```
GET /weather/monthly-stats?year=2024
```

Response includes:

* Minimum temperature
* Maximum temperature
* Median temperature

---

 Database Configuration

Configured in:

```
src/main/resources/application.properties
```

Example:

```
spring.datasource.url=jdbc:mysql://localhost:3306/weather_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

 How to Run the Project

 Step 1: Clone the repository

```
git clone https://github.com/Lavanya-123770/WeatherAPI.git
```

 Step 2: Navigate to project folder

```
cd WeatherAPI
```

 Step 3: Run the application

Using Maven:

```
mvn spring-boot:run
```

Or run:

```
 Running using Eclipse

1. Open project in Eclipse
2. Right click on WeatherApplication.java
3. Click Run As → Spring Boot App
4. Application will start on http://localhost:8082
```

---

 Output

Application runs on:

```
http://localhost:8082
```

---

 Learning Outcomes

This project demonstrates:

* Spring Boot application development
* REST API creation
* Database integration using JPA
* Layered architecture implementation
* Git and GitHub version control

---

 Author

Lavanya M
Bachelor of Engineering – Electrical and Electronics Engineering

---
