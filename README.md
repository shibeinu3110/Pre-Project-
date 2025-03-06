# Employee Management System

An Employee Management System designed to handle employee data, roles, and authentication securely, using Spring Boot and JWT. This project follows monolithic architecture principles and focuses on efficient and scalable solutions for handling data and images.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Packages and Architecture](#packages-and-architecture)
- [Authentication and Authorization](#authentication-and-authorization)
- [Image Storage](#image-storage)
- [Stored Procedures](#stored-procedures)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [License](#license)

## Project Overview

This project, created between November 2024 and January 2025, implements a secure and scalable employee management system. It is divided into packages following standard monolithic architecture principles and is designed with several core features such as role-based access control, image storage, and optimized database operations.

## Technologies Used

- **Java Core**
- **Spring Boot**
- **Spring Security + JWT**
- **MySQL**
- **Minio** (for image storage)
- **Stored Procedure Query**

## Features

- **Role-Based Authentication**: Different roles like manager, leader, and employee with appropriate access levels.
- **JWT-based Authentication**: Secure token-based authentication and authorization.
- **Image Storage**: High-performance and scalable image storage using Minio.
- **Validation and Standardized Responses**: Ensures data integrity with validation and a consistent response format.
- **Stored Procedures**: Used for efficient database interactions and maintenance.

## Packages and Architecture

The project follows a standard monolithic architecture, organized into the following core packages:

- **Model**: Contains all the entity classes representing the database tables.
- **Controller**: Handles HTTP requests and returns appropriate responses.
- **Service**: Implements business logic and communicates between the controller and repository.
- **Repository**: Handles database operations, using stored procedures instead of Spring Data JPA for optimized performance.
- **Utility**: Includes validation, standardized response formats, and exception handling.

## Authentication and Authorization

The system uses **Spring Security** with **JWT** for secure authentication and authorization based on user roles (manager, leader, employee). This ensures that users have access to only the appropriate sections and features of the application.

## Image Storage

Minio is used for storing employee images. This provides a scalable and efficient solution for image storage, ensuring high performance even when dealing with large volumes of images.

## Stored Procedures

The project replaces the standard Spring Data JPA with **stored procedures** to enhance efficiency and scalability. This approach simplifies maintenance for complex database operations and queries, which are crucial for the smooth functioning of an employee management system.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/shibeinu3110/Pre-Project-.git
    cd Pre-Project-
    ```

2. Set up the database:
    - Create a MySQL database and configure connection settings in `application.properties` or `application.yml`.
    - Apply the required stored procedures.

3. Install dependencies and build the project:
    ```bash
    ./mvnw clean install
    ```

4. Set up Minio (for image storage):
    - Install and run Minio locally or connect to an existing Minio instance.
    - Configure Minio settings in the application.

## Running the Application

To start the application locally, use:

```bash
./mvnw spring-boot:run
