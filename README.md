# Book API

## Overview

Book API is a RESTful backend application built using Spring Boot.
It allows users to manage books with operations such as create, read, update, and delete.

The API is secured using Spring Security and documented using Swagger UI.

## Technologies Used

* Spring Boot
* Spring Security
* MongoDB
* Spring Data MongoDB
* Swagger / OpenAPI
* Maven
* Postman (for API testing)

## Features

* Create new books
* Retrieve all books
* Update book details
* Delete books
* Basic authentication with roles (ADMIN, USER)
* Interactive API documentation using Swagger

## Project Structure

```
src/main/java/com/example/bookapi
│
├── controller
├── service
├── repository
├── entity
├── config
```

## Running the Application

### 1. Start MongoDB

Make sure MongoDB service is running.

### 2. Run the Application

Run the Spring Boot application using your IDE or:

```
mvn spring-boot:run
```

### 3. Access the API

Base URL:

```
http://localhost:8080
```

### Swagger Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

### OpenAPI Specification

```
http://localhost:8080/v3/api-docs
```

## API Endpoints

| Method | Endpoint    | Description       |
| ------ | ----------- | ----------------- |
| GET    | /books      | Get all books     |
| POST   | /books      | Create a new book |
| PUT    | /books/{id} | Update a book     |
| DELETE | /books/{id} | Delete a book     |

## Database

MongoDB is used as the database.
Books are stored in the `books` collection.

## Security

Spring Security is configured with role-based access:

* USER → Read books
* ADMIN → Create, update, delete books

## Testing

APIs can be tested using:

* Swagger UI
* Postman

## Author

Created as part of Spring Boot backend practice.
