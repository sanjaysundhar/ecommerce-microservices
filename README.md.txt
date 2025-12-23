# E-commerce Microservices Project

## Overview
This is a **scalable e-commerce application** built using **Spring Boot microservices architecture**. The project demonstrates the use of independent services communicating through a centralized **API Gateway** and registered with a **Eureka Discovery Server** for dynamic service discovery.  
The microservices included in this project are:

- **Product Service** – Manages product catalog and CRUD operations.  
- **Order Service** – Handles customer orders and order processing.  
- **API Gateway** – Routes client requests to the appropriate services.  
- **Eureka Discovery Server** – Enables service registration and discovery.  

## Features
- **Product Management:** Create, update, and retrieve products.  
- **Order Management:** Place and manage customer orders.  
- **API Routing:** Centralized request routing through the API Gateway.  
- **Service Discovery:** Dynamic service registration with Eureka.  
- **Spring Auditing:** Tracks creation and modification details for entities.  

## Getting Started
Follow these steps to run the project locally:

1. Start the **Eureka Discovery Server**.  
2. Start the **Product Service**.  
3. Start the **Order Service**.  
4. Start the **API Gateway**.  

## Technology Stack
- **Backend:** Spring Boot  
- **Service Discovery:** Eureka  
- **Gateway:** Spring Cloud Gateway  
- **Database:** PostgreSQL  
- **Auditing:** Spring Data JPA Auditing  

## Notes
- Each service runs independently and communicates through the API Gateway.  
- Ensure that the **Eureka Server** is running before starting other services.  

