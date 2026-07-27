# Urban Flow – Smart Urban Planning Platform

## Overview

Urban Flow is a cloud-based urban planning platform developed using a microservices architecture. The system enables municipalities and urban planners to manage city assets, districts, events, and impact analysis through independent, scalable services deployed on Microsoft Azure.

The project demonstrates the use of cloud computing, distributed systems, REST APIs, and microservices to build a scalable smart city solution.

---

## Features

- User management
- District management
- Asset management
- Event management
- Urban impact analysis
- RESTful APIs
- Cloud deployment on Microsoft Azure
- Microservices architecture
- Database integration

---

## Microservices

| Service | Description |
|----------|-------------|
| User Service | Manages users and authentication |
| District Service | Handles district information |
| Asset Service | Manages city assets |
| Event Service | Stores and manages urban events |
| Impact Analysis Service | Performs urban impact analysis |

---

## Technologies Used

### Backend

- Java
- Spring Boot
- Maven

### Cloud

- Microsoft Azure App Service
- Azure SQL Database

### Development

- Eclipse IDE
- Git
- GitHub
- Postman

---

## Project Structure

```
Urban Planning Project
│
├── assetservice/
├── district-service/
├── event-service/
├── impactanalysisservice/
├── user-service/
│
├── docs/
├── videos/
├── README.md
└── .gitignore
```

---

## System Architecture

The application follows a microservices architecture where each service is independently responsible for a specific business function.

```
Client
   │
   ▼
REST APIs
   │
   ├── User Service
   ├── District Service
   ├── Asset Service
   ├── Event Service
   └── Impact Analysis Service
            │
            ▼
      Azure SQL Database
```

---

## Azure Deployment

Each microservice was deployed using Microsoft Azure App Service, allowing independent deployment and scalability.

Deployment includes:

- Azure App Service
- Azure SQL Database
- REST API communication
- Cloud hosting

---

## API Testing

All REST endpoints were tested using Postman.

Testing included:

- CRUD operations
- Request validation
- Error handling
- Service communication

---

## Project Demonstration

Video demonstrations are available in the `videos` folder.

They include:

- User Interface demonstration
- Azure deployment walkthrough
- API testing

---

## Documentation

Project documentation can be found in the `docs` folder.

This includes:

- Final report
- Presentation
- Supporting documentation

---

## Future Improvements

- API Gateway
- Service Discovery
- Authentication and Authorization
- Docker containers
- Kubernetes deployment
- Azure Monitor integration

---

## License

This project is intended for educational purposes.


