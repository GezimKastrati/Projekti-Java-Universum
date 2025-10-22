



This Spring Boot REST API project was originally scaffolded for a college assignment. I have continued the implementation and added significant personalizations to demonstrate my understanding of Spring Boot development.



 Core Functionality
- **Complete CRUD Operations** for Test entity management
- **RESTful API Design** with proper HTTP status codes
- **Data Transfer Objects (DTOs)** with validation
- **Entity Mapping** between DTOs and JPA entities
- **Pagination & Sorting** support for data retrieval


Security & Error Handling
- **Global Exception Handler** with consistent `ErrorResponse` format
- **Dual Security Configuration:**
  - Keycloak OAuth2/JWT (production)
  - Simple in-memory auth (development)

- **Input Validation** with proper error messages

 **Swagger/OpenAPI Integration** with personalized metadata
- **Interactive API Documentation** at `/swagger-ui.html`
- **Custom API Info** showing personalization details

 Testing & Quality
- **Unit Tests** for service layer (`TestServiceTest`)
- **Integration Tests** for controller layer (`TestControllerTest`)
- **MockMvc Testing** for HTTP endpoints
- **Test Coverage** for critical business logic

 Development Features
- **Health Check Endpoint** (`/api/health`) with personalization info
- **Seed Data Endpoint** (`/api/data/seed`) for quick testing
- **H2 Database Support** for simplified local development
- **Multiple Profiles** (production with MariaDB, development with H2)

##  How to Run

### Prerequisites
- Java 17+ installed
- `JAVA_HOME` environment variable set

### Option 1: Simple Development Mode (Recommended)
```bash
cd c:\gezim-repo\Projekti-Java-Universum
.\gradlew.bat bootRun --args='--spring.profiles.active=simple-auth'
```

### Option 2: Production Mode (with Docker)
```bash
# Start MariaDB and Keycloak
docker-compose up -d

# Run application
.\gradlew.bat bootRun
```

##  API Endpoints

### Core Endpoints
- `GET /api/health` - Health check with personalization info
- `POST /api/data/seed` - Create sample test data
- `GET /api/tests/getAll` - Get all tests (paginated)
- `POST /api/tests/save` - Create new test
- `GET /api/tests/{id}` - Get test by ID
- `PUT /api/tests/{id}` - Update test
- `DELETE /api/tests/{id}` - Delete test

### Documentation
- `GET /swagger-ui.html` - Interactive API documentation
- `GET /v3/api-docs` - OpenAPI specification

## Authentication

### Development Mode (simple-auth profile)
- **Username:** `student`
- **Password:** `password`
- **Method:** HTTP Basic Auth

### Production Mode
- **Method:** OAuth2/JWT via Keycloak
- **Realm:** `backend`
- **Client:** `rest-api`

## Database Configuration

### Development (H2 In-Memory)
```properties
spring.profiles.active=simple-auth
# H2 Console: http://localhost:3000/testManagement-backend/h2-console
```

### Production (MariaDB)
```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/TestManagement_db
```

## Testing

Run tests with:
```bash
.\gradlew.bat test
```

**Test Coverage:**
- Service layer unit tests with Mockito
- Controller integration tests with MockMvc
- Exception handling validation
- CRUD operations verification

##  Project Structure

```
src/main/java/com/backend/testManagement/
├── config/           # Configuration classes
│   ├── SwaggerConfiguration.java    # API documentation
│   ├── GlobalExceptionHandler.java  # Error handling
│   ├── SecurityConfig.java          # Simple auth
│   └── WebSecurityConfiguration.java # OAuth2/JWT
├── controller/       # REST endpoints
├── dto/             # Data transfer objects
├── exceptions/      # Custom exceptions
├── mapper/          # Entity-DTO mapping
├── model/           # JPA entities
├── repository/      # Data access layer
└── services/        # Business logic
```

## Learning Outcomes Demonstrated

1. **Spring Boot Mastery:** Configuration, auto-configuration, profiles
2. **REST API Design:** Proper HTTP methods, status codes, pagination
3. **Security Implementation:** OAuth2, JWT, basic auth, role-based access
4. **Testing Practices:** Unit tests, integration tests, mocking
5. **Documentation:** Swagger/OpenAPI integration
6. **Error Handling:** Global exception handling, validation
7. **Database Integration:** JPA, multiple database support
8. **DevOps Basics:** Docker, profiles, environment configuration

##  Recent Personalizations Added

-  **Unit & Integration Tests** - Comprehensive test suite
-  **Simplified Security Config** - Easy local development
-  **H2 Database Support** - No external dependencies needed
-  **Health & Seed Endpoints** - Development utilities
-  **Enhanced Documentation** - Complete API documentation
-  **Multiple Profiles** - Development vs production configurations

---
Gezim Kastrati