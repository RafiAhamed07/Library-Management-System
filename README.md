# Library Management System

## Overview

This project is a Library Management System implemented in Java. It features server-client communication for admin authentication and user management, as well as database operations for managing library books.

## Features

- **Admin Authentication**: Admin login using hardcoded credentials.
- **User Management**: Add, verify, and manage library users.
- **Library Operations**: Borrow, delete, insert, and update book records in a MySQL database.
- **Console Interface**: Interactive console interface for admin operations.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Database
- Apache NetBeans (optional, for easy project management)

## Setup

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/RafiAhamed07/Library-Management-System.git
    cd Library-Management-System
    ```

2. **Configure Database**:
   - Create a MySQL database.
   - Update the `LibraryDatabaseOperations` class with your database name, username, and password.

3. **Compile and Run**:
   - Use an IDE like NetBeans to open the project.
   - Compile and run the `Server` class to start the server.
   - Compile and run the `Admin` class to start the client.

## Usage

1. **Start the Server**:
   - Run the `Server` class to start listening for client connections.

2. **Admin Login**:
   - Run the `Admin` class and enter the username and password ("admin" and "202467").

3. **User Options**:
   - Log in or register as a library member.
   - Perform library operations such as adding, removing, borrowing books, and updating book records.

## Classes

### `Admin`
Handles admin authentication and user interactions.

### `Server`
Handles client connections and verifies admin credentials.

### `LibraryDatabaseOperations`
Provides methods for database operations such as borrowing, deleting, inserting, and updating book records.

### `Library`
Implements the main library functions and user interaction menu.

### `User`
Handles user verification and registration.

## Note

Ensure the server is running before attempting to log in as an admin. The database must be correctly configured and populated with initial data.

## License

This project is open-source and available under the [MIT License](LICENSE).

---

Feel free to contribute to this project by submitting issues or pull requests. For major changes, please open an issue first to discuss what you would like to change.

For any queries, contact the repository owner.

---

### Example Commands

- **Add a new book**:
  ```
  Enter book name: The Great Gatsby
  Enter the author's name: F. Scott Fitzgerald
  ```

- **Remove a book**:
  ```
  Enter book name: The Great Gatsby
  ```

- **Borrow a book**:
  ```
  Enter book name: The Great Gatsby
  ```

Happy coding!
