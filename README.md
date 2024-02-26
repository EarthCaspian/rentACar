# Rent-A-Car Web Application Backend Project | Java Spring Boot Project

## Overview

This repository hosts the backend codebase for rent a car, a sophisticated Rent-A-Car web application crafted as a pivotal component of the [TOBETO](https://www.linkedin.com/company/tobeto/) Java-React Full-Stack Developer program. This meticulously engineered application empowers users to seamlessly peruse, explore, and lease vehicles from an extensive catalog within a virtual car rental ecosystem.

## Backend Operations

### Database Connection

The backend handles database operations using Java Spring Boot and Hibernate ORM. It establishes a connection to the PostgreSQL database, where vehicle information, user data, and rental history are stored.

### CRUD Operations

The backend facilitates basic CRUD (Create, Read, Update, Delete) operations to interact with the database:

- **Create**: Enables the addition of new vehicles, user accounts, and rental records.
- **Read**: Retrieves vehicle information, user details, and rental history.
- **Update**: Allows modification of vehicle details, user profiles, and rental information.
- **Delete**: Permits the removal of vehicles from the catalog, user accounts, and rental records.

These operations ensure the smooth functioning of the Rent-A-Car platform, providing users with a seamless experience while managing data efficiently.


For further insights, we invite you to explore the [frontend repository](https://github.com/EarthCaspian/project-rbride).

## Contributors
- [Hazar Akatay](https://github.com/EarthCaspian)
- [Senem Yılmaz](https://github.com/senemyilmazz)
- [Duygu Şen Tosunoğlu](https://github.com/duygusen)
- [İnci Gülçin Durak Yolcu](https://github.com/InciGulcinDY)

## N-Layered Architecture

Our project is structured with an N-layered architecture, meticulously designed to promote clean code and scalability. This architectural approach allows for the separation of concerns and modularization of components, ensuring ease of maintenance, extensibility, and testability.

### Key Layers:

- **Controller Layer**: Responsible for handling user interaction and interface rendering. It includes components such as controllers, views, and UI-related logic.

- **Business Layer**: Contains the core business logic and rules of the application. This layer orchestrates data processing, validation, and business workflows.

- **Data Access Layer**: Handles interactions with the database and data persistence. It encapsulates database operations and ensures data integrity and consistency.

- **Entity Layer**:  The Entity Layer represents the domain model of our application, encapsulating the business entities and their relationships. These entities are the building blocks of our data model and closely mirror the real-world objects and concepts our application deals with.

### Benefits:

- **Modularity**: Each layer is self-contained, promoting code reusability and maintainability. New features or changes can be implemented with minimal impact on other layers.

- **Scalability**: The architecture accommodates growth and evolution by allowing additional layers or components to be seamlessly integrated.

- **Clean Code**: Clear separation of concerns and well-defined boundaries between layers result in cleaner, more readable code. This fosters collaboration and simplifies debugging and troubleshooting.

- **Flexibility**: The layered structure facilitates the adoption of new technologies or frameworks. Adding new databases, integrating external services, or adopting microservices architecture becomes straightforward, thanks to the clear separation of concerns and modular design.

By adhering to this robust N-layered architecture, our project exemplifies a commitment to best practices, ensuring a solid foundation for current and future development endeavors.

## Technologies Used

### Development Tools
- Java
- Spring

### DataBase
- PostgreSQL 

### Libraries
- JPA
- Hibernate
- Lombok
- Model Mapper
- Json Web Token

## Getting Started

### Prerequisites
Before proceeding, ensure you have the following installed on your system:
- Java Development Kit (JDK)
- Maven
- PostgreSQL database

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/EarthCaspian/rentACar/tree/main
2. Navigate to the project directory:
    ```bash
    cd rent-a-car
3. Set up the database:
- Create a PostgreSQL database named rent_a_car
- Create application.properties with your database credentials
4. Build and Run the Backend:
    ```bash
    cd backend
    mvn spring-boot:run
5. Install Frontend Dependencies:
    ```bash
    cd frontend
    npm install
6. Start the Frontend Server:
    ```bash
    npm start
7. Access the application at http://localhost:3000 in your web browser.

### Usage
Once the application is running, you can sign up for an account, browse available vehicles, search for specific vehicles, reserve them for specific dates, and view your rental history.

### Additional Notes
Ensure that the backend server is running before starting the frontend server to enable communication between the frontend and backend.
Make sure to configure any necessary environment variables or settings according to your specific development environment.

## Acknowledgements
We extend our sincere appreciation to [Halit Enes Kalaycı](https://github.com/halitkalayci) for his invaluable guidance throughout the [TOBETO](https://www.linkedin.com/company/tobeto/) Java-React Full-Stack Developer program, conducted under the auspices of the [İstanbul Kodluyor Project](https://www.linkedin.com/in/istanbul-kodluyor-09b981288/).
