# Bite Buddies - API

A backend application for lunch planner.

## Overview

The BiteBuddies project is a Java-based application developed using the Spring Boot framework. It provides a foundation
for building a web application with data persistence using Spring Data JPA, Flyway for database migration, and includes
tools like Lombok and MapStruct for simplified development.

## Prerequisites

- Java 17
- [Spring Boot 3.2.1](https://spring.io/projects/spring-boot)
- [Flyway](https://flywaydb.org/) for database migration
- [Lombok](https://projectlombok.org/) for reducing boilerplate code
- [MapStruct](https://mapstruct.org/) for object mapping
- [H2 Database](https://www.h2database.com/html/main.html) for runtime database

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/PremRanjanDev/BiteBuddies-API.git
   cd BiteBuddies-API
   ```

2. Build the project:
   ```bash
   ./gradlew build
   ```

3. Run the application:

   ```bash
   ./gradlew bootRun
   ```

The application will be accessible at http://localhost:8080

## Configuration

The main configuration file is `application.yml` in the `src/main/resources` directory. Customize it according to
your requirements.

## Database Migration

Flyway is used for database migration. Place your SQL migration scripts in `src/main/resources/db/migration`.

## Development Tools

The project
includes [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html)
for automatic application restarts during development.

## Testing

The project uses JUnit 5 for testing. You can run tests using:

## Endpoints

### Endpoint: /user

#### Sign-up user

- Description: Register a new user.
- Endpoint: `/user/sign-up`
- Method: `POST`
- Request Body: `{ "name": "Full Name", "username": "Username of choice", "password": "password123" }`

#### Sign-in user

- Description: Login exiting user.
- Endpoint: `/user/login`
- Method: `POST`
  Request Body: `{ "username": "Username", "password": "password123" }`

#### Get all users

- Description: Get all user's basic details.
- Endpoint: `/user/all`
- Method: `GET`

### Endpoint: /session

#### Get all Sessions (only session overview)

- Description: Get the list of all sessions.
- Endpoint: `/session/all`
- Method: `GET`

#### Get active Sessions (only session overview)

- Description: Get the list of all active sessions.
- Endpoint: /session/active
- Method: `GET`

#### Get Session detail

- Description: Get the session detail.
- Endpoint: /session/{id}
- Method: `GET`

#### Initiate session

- Description: Initiate/create a new session.
- Endpoint: `/session`
- Method: `POST`
- Request
  Body: `{ "name": "Lunch Session", "description": "Team lunch for release Q2 2024", startsAt: "01/06/2024 11:00:
  00", initiatedByUserId: 2 }`

#### Update session

- Description: Update existing session.
- Endpoint: `/session`
- Method: `PUT`
- Request
  Body: `{ "id": 2, "name": "Lunch Session", "description": "Team lunch for release Q2 2024", startsAt: "01/06/2024 11:00:00", initiatedByUserId: 2 }`

#### Delete session

- Description: Delete the existing session.
- Endpoint: /session/{id}
- Method: DELETE

#### Invite user to session

- Description: Invite given users to an existing session.
- Endpoint: `/session/{id}/invite`
- Method: `PUT`
- Request Body:  `[1, 2, 4]`

#### Join session

- Description: Join invited user to the existing session.
- Endpoint: `/session/{id}/join`
- Method: `PUT`
- Query Parameter: `requesterId`

#### End session

- Description: End the existing active session.
- Endpoint: `/session/{id}/end`
- Method: `PUT`
- Query Parameter: `requesterId`

### Endpoint: /restaurant

#### Get all restaurants

- Description: Get the list of all restaurants.
- Endpoint: `/restaurant/all`
- Method: `GET`

#### Get a restaurant

- Description: Get the restaurant detail.
- Endpoint: `/restaurant/{id}`
- Method: `GET`

#### Submit a restaurant to the session

- Description: Add a restaurant to existing session
- Endpoint: `/restaurant/submit/{sessionId}`
- Method: `PUT`
- Request
  Body:  `{"name": "Restaurant name", "location": "Restaurants location/address", imageUrl: "Banner URL", "websiteUrl": "Website URL"}`
- Query Parameter: `requesterId`

