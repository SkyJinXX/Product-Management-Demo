# Product-Management-Demo

This is a demo project for Product Management built to demonstrate the use of various Spring Boot technologies in a microservice architecture. The project includes three main services: **Product-Service**, **Inventory-Service**, and **Gateway-Service**, all working together using technologies like Nacos, Spring Gateway, Feign, Redis, MySQL, Docker, and MyBatis.

## Project Overview

This project simulates an Amazon-like product management system with functionalities to add, update, delete, and retrieve products. Additionally, it integrates inventory management for products, allowing the quantity of products to be handled through the **Inventory-Service**.

### Services

1. **Gateway-Service**: The entry point for the microservice architecture, handling routing and forwarding requests to other services.
2. **Product-Service**: Manages CRUD operations for product information, such as name, description, and price. Also integrates with **Inventory-Service** to manage product quantity.
3. **Inventory-Service**: Responsible for managing the quantity of products and ensuring product inventory information is stored and retrieved correctly.

## Technologies Used

- **Spring Boot**: Core framework for building the microservices.
- **Nacos**: Service discovery and configuration management.
- **Spring Cloud Gateway**: For routing and load balancing between services.
- **Feign**: Declarative HTTP client for service-to-service communication.
- **Redis**: Used for caching product inventory data.
- **MySQL**: The database for storing product data.
- **MyBatis**: ORM framework for database interaction.
- **Docker**: Containerization for running services.

## Features

- **Product CRUD Operations**: Add, update, delete, and fetch products.
- **Inventory Management**: Track product quantity using **Inventory-Service**.
- **Service Discovery and Load Balancing**: Nacos is used for registering services and managing service instances.
- **API Gateway**: Centralized API gateway for routing requests to microservices.
- **Caching**: Redis is used to cache frequently accessed inventory data.

## Setup and Running the Project

### Prerequisites

- Docker and Docker Compose installed
- MySQL and Redis set up locally or via Docker
- Java 17+
- Maven

### Endpoints
**Product-Service:**

- `GET /products/db`: Get the list of all products with inventory.
- `GET /products/{id}`: Get a single product with its inventory by product ID.
- `POST /products`: Add a new product along with its initial inventory.
- `PUT /products/{id}`: Update an existing product.
- `DELETE /products/{id}`: Delete a product and its associated inventory.

**Inventory-Service:**

- `GET /inventory/{productId}`: Get the inventory quantity for a specific product.
- `POST /inventory`: Add a new inventory record for a product.
- `PUT /inventory/{productId}`: Update the inventory quantity for a product.