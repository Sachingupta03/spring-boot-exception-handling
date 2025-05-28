# Spring Boot Exception Handling Project

This project demonstrates a basic **Spring Boot CRUD REST API** with **custom exception handling** using Spring Boot 3.5, Java 21, Lombok, JPA, and MySQL.

---

## 📁 Project Structure

## Features

- REST APIs for User CRUD
- Exception handling with custom exceptions
- `@RestControllerAdvice` based global error handling
- Spring Data JPA integration with MySQL
- Lombok annotations (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`)
- Clean layer separation: Controller → Service → Repository

---
## 🚀 Tech Stack

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- MySQL
- Lombok
- Maven

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Sachingupta03/spring-boot-exception-handling.git
cd spring-boot-exception-handling

🔄 Flow of Methods in the Project
▶️ POST /users – Create User
Flow:

UserController.addUser(User user)

⬇️ calls

UserServiceImpl.addUser(User user)

⬇️ calls

UserRepository.save(user)

📥 GET /users/{id} – Get User by ID
Flow:

UserController.getUserById(Long id)

⬇️ calls

UserServiceImpl.getUserById(Long id)

⬇️ calls

UserRepository.findById(id)

🔁 If not found → throws UserNotFoundException

🚫 Caught by GlobalExceptionHandler.handleUserNotFound()

📥 GET /users – Get All Users
Flow:

UserController.getAllUsers()

⬇️ calls

UserServiceImpl.getAllUsers()

⬇️ calls

UserRepository.findAll()

🔍 GET /users/name/{name} – Get User by Name
Flow:

UserController.getUserByName(String name)

⬇️ calls

UserServiceImpl.getUserByName(String name)

⬇️ calls

UserRepository.findByName(name)

🔁 If not found → throws UserNameNotFoundException

🚫 Caught by GlobalExceptionHandler.handleUserNameNotFound()

🔍 GET /users/email/{email} – Get User by Email
Flow:

UserController.getUserByEmail(String email)

⬇️ calls

UserServiceImpl.getUserByEmail(String email)

⬇️ calls

UserRepository.findByEmail(email)

🔁 If not found → throws UserEmailNotFoundException

🚫 Caught by GlobalExceptionHandler.handleUserEmailNotFound()

✏️ PUT /users/{id} – Update Entire User
Flow:

UserController.updateUser(Long id, User user)

⬇️ calls

UserServiceImpl.updateUser(Long id, User user)

⬇️ calls

UserRepository.findById(id)

🔁 If not found → throws UserNotFoundException

✅ Else → UserRepository.save(updatedUser)


