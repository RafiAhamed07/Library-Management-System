package lms;

import java.sql.*;

public class LibraryDatabaseOperations {
    private static final String databaseName = ""; // Enter the name of your Database
    private static final String url = "jdbc:mysql://localhost:3306/" + databaseName;
    private static final String username = "root";
    private static final String password = "";//Enter your pass

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found: " + ex.getMessage());
        }
    }

    // Method for borrowing a book
    public static void borrow(String bname) {
        String query = "SELECT 1 FROM books WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, bname);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Book borrowed successfully");
                } else {
                    System.out.println("Book does not exist");
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQL error: " + ex.getMessage());
        }
    }

    // Method for deleting a book
    public static void delete(String name) {
        String deleteQuery = "DELETE FROM books WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            statement.setString(1, name);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully");
            } else {
                System.out.println("Failed to delete book");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to get all book data
    public static void getALLData() {
        String query = "SELECT * FROM books";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int uid = resultSet.getInt("uid");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                System.out.println("uid: " + uid + " || name: " + name + " || author: " + author);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method to get data of a specific book by name
    public static void getData(String name) {
        String query = "SELECT * FROM books WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("uid");
                    String bname = resultSet.getString("name");
                    String author = resultSet.getString("author");
                    System.out.println("id: " + id + " || name: " + bname + " || author: " + author);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method to insert new book data
    public static void insertData(String name, String author) {
        String insertQuery = "INSERT INTO books(name, author) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            statement.setString(1, name);
            statement.setString(2, author);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book Added Successfully");
            } else {
                System.out.println("Book Insertion Failed");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method to update book name
    public static void updateBName(int uid, String newName) {
        String updateQuery = "UPDATE books SET name = ? WHERE uid = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            statement.setString(1, newName);
            statement.setInt(2, uid);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book name updated successfully");
            } else {
                System.out.println("Failed to update book name");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method to update book author
    public static void updateAuthor(int uid, String newAuthor) {
        String updateQuery = "UPDATE books SET author = ? WHERE uid = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            statement.setString(1, newAuthor);
            statement.setInt(2, uid);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book author updated successfully");
            } else {
                System.out.println("Failed to update book author");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
