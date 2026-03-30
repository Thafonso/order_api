# 📦 Order API

A RESTful API for order management built with **Java** and **Spring Boot**.

---

## 🚀 Technologies

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (testing)
- **PostgreSQL** (dev)
- **Maven**

---

## ✨ Features

- Create, read, update, and delete orders (CRUD)

---

## 🗂️ Project Structure

```
order_api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/thafonsotest/orderapi/
|   |   |       ├── config/
│   │   │       ├── controller/
|   |   |           ├──exceptions
|   |   |       ├── entities/
|   |   |           ├── pk
|   |   |       ├── enums/
│   │   │       ├── repositories/
│   │   │       ├── service/
|   |   |           ├── exceptions
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-test.properties
│   └── test/
├── pom.xml
└── README.md
```

---

## ⚙️ Configuration

### Testing (H2)

In `application-test.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### Production (PostgreSQL)

In `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/orderdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

---

## ▶️ How to Run

### Prerequisites

- Java 21+
- Maven
- PostgreSQL (for production)

### Steps

```bash
# Clone the repository
git clone https://github.com/Thafonso/order_api.git

# Navigate to the project folder
cd order_api

# Run with Maven
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## 🔗 API Endpoints

| Method | Endpoint          | Description         |
|--------|-------------------|---------------------|
| GET    | `/orders`         | List all orders     |
| GET    | `/orders/{id}`    | Get order by ID     |
| POST   | `/orders`         | Create a new order  |
| PUT    | `/orders/{id}`    | Update an order     |
| DELETE | `/orders/{id}`    | Delete an order     |

---
