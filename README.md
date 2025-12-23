# 🛒 E-commerce Microservices Project

## 📌 Overview
This project is a **scalable e-commerce application** built using **Spring Boot microservices architecture**.  
It demonstrates how independent services communicate through a centralized **API Gateway** and are dynamically registered and discovered using a **Eureka Discovery Server**.

### 🧩 Microservices Included
- **🛍️ Product Service** – Manages the product catalog and supports CRUD operations  
- **📦 Order Service** – Handles customer orders and order processing  
- **🚪 API Gateway** – Acts as a single entry point and routes client requests  
- **🧭 Eureka Discovery Server** – Provides service registration and discovery  

---

## ✨ Features
- **📦 Product Management** – Create, update, and retrieve products  
- **🧾 Order Management** – Place and manage customer orders  
- **🚦 API Routing** – Centralized request routing via API Gateway  
- **🔍 Service Discovery** – Dynamic service registration with Eureka  
- **🕒 Spring Auditing** – Automatically tracks creation and modification details  

---

## ▶️ Getting Started
Follow these steps to run the project locally:

1. Start the **🧭 Eureka Discovery Server**  
2. Start the **🛍️ Product Service**  
3. Start the **📦 Order Service**  
4. Start the **🚪 API Gateway**  

---

## 🛠️ Technology Stack
- **Backend:** Spring Boot  
- **Service Discovery:** Netflix Eureka  
- **API Gateway:** Spring Cloud Gateway  
- **Database:** PostgreSQL  
- **Auditing:** Spring Data JPA Auditing  

---

## 📝 Notes
- Each service runs **independently** and communicates through the **API Gateway**  
- Always ensure the **Eureka Server** is running before starting other services  
- Designed for **scalability, maintainability, and real-world microservice patterns**

---

⭐ If you like this project, feel free to star the repository!