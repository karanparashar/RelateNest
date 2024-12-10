# RelateNest Application

RelateNest is a Spring Boot microservice that dynamically forms hierarchical relationships from flat database entries and serves them as nested JSON structures. The application demonstrates efficient parent-child relationship mapping, custom annotations, and RESTful API design.

## Features
- **Database Management**:
    - Uses H2 in-memory database.
    - Populates database using REST API or predefined data.
- **Dynamic Nesting**:
    - Converts flat relational data into a nested JSON structure.
- **RESTful APIs**:
    - Endpoints to retrieve flat and hierarchical data.
- **Custom Annotation**:
    - Logs method parameters for debugging and auditing purposes.


## **Swagger Documentation**
Access the Swagger UI: [relate nest Swagger UI](http://relatenest.ap-south-1.elasticbeanstalk.com/swagger-ui/index.html#/)

## Technologies Used
- Spring Boot 3+
- H2 Database
- Java 17+
- Maven

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.8 or higher
- An IDE (e.g., IntelliJ IDEA, Eclipse)

### Steps to Run
1. Clone the repository:
   ```bash
   git clone <repository_url>
   cd <repository_directory>

## API Endpoints
- **GET /characters**: Fetch all flat data.
- **GET /characters/nested**: Fetch nested JSON relationships.
- **POST /characters**: Add new entries to the database.