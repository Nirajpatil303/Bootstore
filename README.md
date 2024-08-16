# BookStore Application

## Overview

BookStore is a Java Spring Boot application designed to manage a bookstore, allowing you to store and sell books. It supports various book categories and provides endpoints for managing books and categories. The application uses MySQL for data storage and JPA/Hibernate for database interaction.

## Database Schema

The application uses a MySQL database named `bookstore`, which contains a single table named `book`. The table has the following columns:

- `id`: Unique identifier for the book
- `author`: Author of the book
- `title`: Title of the book
- `category`: Category of the book
- `price`: Price of the book
- `total_count`: Total number of books available in the store
- `sold`: Number of books sold

## Features

- **Addition of Book**:
  - **POST** `/Book/add`: Add a new book to the database if it doesn't exist.
  - **POST** `/Book/update`: Update the quantity of an existing book.

- **Category Management**:
  - **POST** `/Category/add`: Add a new category if it doesn't exist.

- **Retrieve Book Details**:
  - **GET** `/book/{id}`: Get details of a book by its ID.

- **Retrieve Category Details**:
  - **GET** `/Category/{id}`: Get details of a category by its ID.

- **Get All Books**:
  - **GET** `/book`: Retrieve all books.

- **Get All Categories**:
  - **GET** `/Category`: Retrieve all categories.

- **Check Book Availability**:
  - **GET** `/Category/book/{id}`: Get the number of books available by book ID.

- **Sell a Book**:
  - **POST** `/Book/sell`: Sell a number of books for a given book ID.

- **Search Books by Category and Keyword**:
  - **GET** `/Category/{id}`: Get books by category and keyword.

- **Number of Books Sold per Category and Keyword**:
  - **GET** `/Category/book/{id}`: Get the number of books sold per category.

## Tools and Frameworks

- **IntelliJ IDEA**: IDE for Java development.
- **MySQL**: Relational database management system.
- **JPA**: Java Persistence API for ORM.
- **Lombok**: Library for reducing boilerplate code in Java.
- **Postman**: Tool for testing RESTful APIs.

## Setup Instructions

1. **Install Required Tools**:
   - Install [IntelliJ IDEA](https://www.jetbrains.com/idea/) if you haven't already.
   - Install [MySQL](https://www.mysql.com/downloads/).

2. **Setup MySQL Database**:
   - Create a database named `bookstore` in MySQL Workbench.

3. **Configure Application Properties**:
   - Open `application.properties` in your IDE.
   - Update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties according to your MySQL setup.

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
     spring.datasource.username=root
     spring.datasource.password=1234
     ```

4. **Run the Application**:
   - Run the Spring Boot application. The `book` table will be automatically created in the `bookstore` database.
   - By default, the application runs on port `9999`. You can change this in the `application.properties` file if needed.

5. **Testing with Postman**:
   - Open Postman and test the provided REST endpoints.

6. **Run Unit Tests**:
   - Once the application is set up, you can run unit tests to ensure everything is working as expected.

## Sample Postman Requests

- **Add a Book**:
  - **POST** `http://localhost:9999/Book/add`
  - Request body: `{ "author": "Author Name", "title": "Book Title", "category": "LITERATURE", "price": 10.99, "total_count": 100 }`

- **Sell a Book**:
  - **POST** `http://localhost:9999/Book/sell`
  - Request body: `{ "id": 1, "quantity": 5 }`

- **Get Book by ID**:
  - **GET** `http://localhost:9999/book/{id}`

