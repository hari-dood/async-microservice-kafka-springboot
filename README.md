# Async Microservice Kafka Spring Boot

## Overview
This project demonstrates an **asynchronous microservice architecture** using **Spring Boot** and **Apache Kafka** for event-driven communication. It focuses on **producer-consumer messaging**, ensuring real-time data transfer between services while maintaining **scalability and fault tolerance** in a distributed system.

## Project Goal
The primary aim of this project is to implement **Kafka-based asynchronous communication** between microservices. Whenever an **employee's data** is saved in the producer service, the same data is immediately sent to the consumer service, ensuring efficient data transfer and storage synchronization.

## Tech Stack
- **Java** (Spring Boot)
- **Apache Kafka** (Messaging Broker)
- **Spring Kafka** (Integration with Spring Boot)
- **PostgreSQL** (Database for Producer)
- **MongoDB** (Database for Consumer)
- **Docker** (Containerization)

## Architecture
1. **Producer Service:**
   - Saves employee data to its **PostgreSQL** database.
   - Publishes an event to a Kafka topic.
   
2. **Consumer Service:**
   - Listens to the Kafka topic.
   - Receives the employee data and saves it into its **MongoDB** database.

## Setup Instructions
### Prerequisites
- Install **Java 17+**
- Install **Apache Kafka**
- Install **PostgreSQL**
- Install **MongoDB**
- Install **Docker** (Optional for containerization)

### Steps to Run
#### 1. Start Kafka Server
Ensure Zookeeper and Kafka brokers are running:
```sh
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
```

#### 2. Start the Producer Service
```sh
cd producer-service
mvn spring-boot:run
```

#### 3. Start the Consumer Service
```sh
cd consumer-service
mvn spring-boot:run
```

## API Endpoints
### Producer API
- **Save Employee Data**
  ```http
  POST /api/v1/employees
  ```
  **Request Body:**
  ```json
  {
  "employeeName": "Premkumar",
  "department": "HR",
  "salary": "75000",
  "dateOfBirth": "1995-06-15",
  "experience": "5 years"
}



## Future Enhancements
- Implement **error handling & retry mechanisms**.
- Add **Spring Security** for authentication.
- Monitor Kafka topics using **Kafka UI tools**.

## License
This project is open-source and available under the **MIT License**.

