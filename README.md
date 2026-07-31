# Book Search

Book Search is an intermediate Spring Boot project built while following a course on Java, Maven, Spring Boot, PostgreSQL, and Docker. The goal is to create a full-text searchable book catalog, expose REST APIs for search and analytics, and package the database for an easy local development workflow.

## Project Overview

This repository is the starting point for a course project that covers:

- Building a RESTful API with Java and Spring Boot
- Designing a PostgreSQL schema for book data and search-friendly queries
- Importing public book data into a relational database
- Containerizing PostgreSQL with Docker
- Testing and documenting endpoints with tools like Postman or VS Code extensions

At the moment, the project includes a minimal Spring Boot application, a sample health-style endpoint, and a PostgreSQL schema script that creates the core book tables.

## Learning Objectives

The course and project focus on the following outcomes:

- Build a RESTful API using modern Java and Spring Boot with full-text search capabilities on book data.
- Design and implement a PostgreSQL schema for storing and querying books efficiently.
- Ingest and validate book data from a public archive.
- Use Docker to run PostgreSQL locally in a repeatable way.
- Test and document API endpoints for reliability and maintainability.

## Tech Stack

- Java
- Maven
- Spring Boot
- PostgreSQL
- Docker

## Repository Structure

```text
book-search/
├── db/
│   └── create_schema.sql
├── docker-compose.yml
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/a2/
    │   │   ├── App.java
    │   │   ├── DbImporter.java
    │   │   ├── HelloController.java
    │   │   ├── controller/
    │   │   │   └── BookController.java
    │   │   ├── entity/
    │   │   │   └── Book.java
    │   │   ├── repository/
    │   │   │   └── BookRepository.java
    │   │   └── service/
    │   │       └── BookService.java
    │   └── resources/
    │       └── application.properties
    └── test/
        ├── java/com/a2/
        │   ├── AppTest.java
        │   ├── controller/
        │   │   └── BookControllerTest.java
        │   ├── repository/
        │   │   └── BookRepositoryTest.java
        │   └── service/
        │       └── BookServiceTest.java
        └── resources/
            └── application.properties
```

## Current Features

- Spring Boot application bootstrap in App.java
- Book search endpoint at GET /books/search
- Service-layer validation for empty or null search terms
- Repository layer for database-backed book search
- PostgreSQL schema for book data and search support
- Docker Compose setup for running PostgreSQL 16 locally

## Database Design

The schema in `db/create_schema.sql` creates:

- `books` for core book metadata such as title, rating, description, language, ISBN, pages, publisher, and publication dates
- `authors` for author records
- `book_authors` for the many-to-many relationship between books and authors

This structure is a good base for later search features, filters, and analytics by year, author, publisher, or format.

## Prerequisites

- Java 17 or later
- Maven
- Docker and Docker Compose
- VS Code with Java support if you want to follow the course workflow closely

## Running the Project

### 1. Start PostgreSQL

```bash
docker compose up -d
```

This starts a PostgreSQL 16 container named `library-db` and initializes the schema from `db/create_schema.sql`.

### 2. Run the Spring Boot app

```bash
mvn spring-boot:run
```

### 3. Try the sample endpoint

```bash
curl http://localhost:8080/hello
```

Expected response:

```text
Hello, Spring Boot!
```

## Configuration

The database container uses the following defaults in `docker-compose.yml`:

- Database: `library`
- User: `admin`
- Password: `admin123`
- Port: `5432`

Update these values before using the project in a shared or production-like environment.

## Planned API Ideas

The course describes several features that can be added next:

- Search books by keyword using PostgreSQL full-text search
- Filter results by publication year, author, language, or publisher
- Return aggregate insights such as top authors or yearly publication counts
- Add validation, error handling, and API documentation

## Development Notes

- The repository currently contains a minimal scaffold rather than the full course implementation.
- The schema script is already wired into Docker Compose through PostgreSQL init scripts.
- As the project grows, consider adding a dedicated data import pipeline and integration tests.

## License

Add a license here if you want to share or publish the project.