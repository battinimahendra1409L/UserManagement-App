User Registration App

Overview

This project is a simple full-stack application I built using Vue.js, Spring Boot, and MongoDB.
The main goal of this project is to understand how frontend and backend communicate with each other using REST APIs.

In this application, users can register their details and perform basic operations like create, view, update, and delete records.

---

Technologies Used

Backend

- Java 17
- Spring Boot
- MongoDB
- Maven

Frontend

- Vue.js (Vite)
- Axios
- HTML, CSS, JavaScript

---

Project Structure

Backend (Spring Boot)

I followed a layered architecture:

- Controller → Handles API requests
- Service → Contains business logic
- Repository → Interacts with MongoDB
- Exception → Handles errors globally

---

Frontend (Vue.js)

The frontend is built using Vue components:

- Created a user form component
- Used Axios for API calls
- Added basic validations for user inputs

---

How to Run the Project

Step 1: Clone the Repository

git clone https://github.com/battinimahendra1409L/UserManagement-App.git
cd UserRegistration-App

---

Step 2: Start MongoDB

Make sure MongoDB is running locally on:

mongodb://localhost:27017

---

Step 3: Run Backend

Open the backend project in your IDE (Eclipse / IntelliJ / STS)

Check "application.properties":

spring.data.mongodb.uri=mongodb://localhost:27017/userdb
server.port=8080

Run the Spring Boot application.

Backend will run on:

http://localhost:8080

---

Step 4: Run Frontend

Go to frontend folder:

cd frontend
npm install
npm run dev

Frontend will run on:

http://localhost:5173

---

API Endpoints

Create User

POST "/api/users"

Get Users

GET "/api/users"

Update User

PUT "/api/users/{id}"

Delete User

DELETE "/api/users/{id}"

---

Features

- User registration form
- Basic validation (required fields, email format)
- Unique email check in backend
- Full CRUD operations
- Frontend and backend integration using Axios
- Simple and clean UI

---

What I Learned

- How to connect Vue.js frontend with Spring Boot backend
- How REST APIs work
- Handling exceptions in Spring Boot
- Using MongoDB with Spring Data
- Debugging real-time issues

---

Future Improvements

- Add search functionality
- Add pagination
- Improve UI design
- Add login and authentication

---

Author

Mahendra Battini
