# Employee Management System (Spring Boot)

A simple Employee Management System built with **Spring Boot**, **JPA/Hibernate**, and **MySQL**.  
It allows you to perform CRUD operations and search employees based on multiple filters like designation, title, email, and salary range.

---

## 🚀 Features
- Add a new employee
- View all employees
- Update employee details
- Delete employee by ID
- Search by:
  - Employee ID
  - Designation
  - Title
  - Email
  - Salary range

---

## 🛠️ Tech Stack
- **Java 17** (or your Java version)
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Postman** for API testing

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/employees` | Add a new employee |
| GET    | `/employees` | Get all employees |
| GET    | `/employees/{id}` | Get employee by ID |
| PUT    | `/employees/{id}` | Update employee details |
| DELETE | `/employees/{id}` | Delete employee by ID |
| GET    | `/employees/designation/{designation}` | Search by designation |
| GET    | `/employees/title/{title}` | Search by title |
| GET    | `/employees/email/{email}` | Search by email |
| GET    | `/employees/salary/{min}/{max}` | Search employees by salary range |

---

## 📷 Postman Testing
All APIs have been tested using **Postman**.  
You can find the Postman collection in the repository.

---

## ⚙️ How to Run the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
