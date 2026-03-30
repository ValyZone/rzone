# RZone

A Spring Boot web application for tournament management with blogging capabilities. Features user registration and login, an admin panel for publishing blog posts, and a scoreboard system.

## Tech Stack

- **Backend:** Java 21, Spring Boot 3.4.3, Spring Data JPA
- **Frontend:** Thymeleaf, HTML5, CSS3, JavaScript
- **Database:** PostgreSQL
- **Build:** Maven (Maven Wrapper included)

## Prerequisites

- Java 21+
- PostgreSQL running on `localhost:5433`
  - Database name: `Users`
  - Username: `postgres`
  - Password: `postgres`

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/ValyZone/rzone.git
   cd rzone
   ```

2. Create the PostgreSQL database:
   ```sql
   CREATE DATABASE "Users";
   ```

3. Run the application (Hibernate will auto-create tables on first run):
   ```bash
   # Linux / macOS
   ./mvnw spring-boot:run

   # Windows
   mvnw.cmd spring-boot:run
   ```

The app will be available at `http://localhost:8080`.

## Build

```bash
# Linux / macOS
./mvnw clean package

# Windows
mvnw.cmd clean package
```

The packaged JAR is output to `target/`.

## Project Structure

```
src/main/java/com/rzone/tournament_web_app/
├── controller/       # HTTP request handlers (Home, Admin, Main)
├── entity/           # JPA entities (User, BlogPost)
├── dao/              # Spring Data repositories
├── model/            # Form-binding models
└── services/         # Business logic (user, blog)

src/main/resources/
├── application.yml   # Database and JPA configuration
├── templates/        # Thymeleaf HTML templates
│   ├── home/         # Login and registration pages
│   ├── admin/        # Admin panel
│   └── main/         # Blog and scoreboard views
└── static/           # CSS and images
```

## Features

- User registration and login
- Admin panel for creating and publishing blog posts
- Blog post listing with timestamps
- User balance tracking (initial balance: 500)
- Scoreboard (in progress)

## Configuration

Database connection is configured in `src/main/resources/application.yml`. The defaults expect a local PostgreSQL instance on port `5433`. Adjust credentials there if your setup differs.
