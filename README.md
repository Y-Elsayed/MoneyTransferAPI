# MoneyTransfer API Using Spring

This project is part of the Banque Misr Internship, one of the largest banks in Egypt. During this internship, the backend team was tasked with building a Money Transfer API using the Spring framework. The API follows the Model-View-Controller (MVC) architecture pattern, ensuring separation of concerns and a clean, maintainable codebase.

## Table of Contents
- [About](#about)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [API Documentation](#api-documentation)

## About
The Money Transfer API allows for secure and efficient processing of money transfers between accounts. It provides endpoints for initiating, tracking, and managing transfers while ensuring high reliability and scalability. This project was designed to meet the needs of Banque Misr’s backend infrastructure while adhering to industry best practices.

## Features
- **Account Management**: Create and manage accounts for customers.
- **Money Transfers**: Secure transfer of funds between accounts.
- **Transaction History**: View and track past transactions.
- **Validation and Error Handling**: Ensures that transactions are valid and handled correctly with appropriate error responses.
  
## Technologies Used
- **Spring Framework**: For building the backend application.
- **Spring Boot**: To simplify project setup and configuration.
- **Spring Data JPA**: For interacting with the database.
- **MySQL**: For the database design and management.
- **Postman**: For testing and documenting API endpoints.
- **Swagger**: For generating interactive API documentation and providing an easy way to explore the API's functionality.
- **Maven**: Dependency management and build automation.
  
## Setup and Installation

To run the project locally, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Y-Elsayed/MoneyTransferAPI.git

2. **Navigate to the project directory:**
   ```bash
   cd MoneyTransferAPI

3. **Build the project using Maven:**
    ```bash
    mvn clean install

4. **Run the application:**
    ```bash
    mvn spring-boot:run

The API will now be running locally on `http://localhost:8080`

## API Documentation
Refer to the [Swagger documentation](https://documenter.getpostman.com/view/34937434/2sA3rwLtmV)
