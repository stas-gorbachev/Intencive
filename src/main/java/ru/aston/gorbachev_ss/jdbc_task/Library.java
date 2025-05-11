package ru.aston.gorbachev_ss.jdbc_task;

import java.sql.*;
import java.util.Scanner;

public class Library {

    public static void main(String[] args) {

        String url = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7777273";
        String user = "sql7777273";
        String password = "xRR4akh9BW";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                Statement statement = connection.createStatement();
                addNewBook(statement);
                addNewReader(statement);
                outputBooks(statement);
                outputReaders(statement);
                outputAuthors(statement);
                updateBook(connection);
                deleteBook(connection);
                addBookAndAuthor(connection, statement);
                searchBook(connection);
                statement.close();
            }
        } catch (SQLException exception) {
            System.out.println("Ошибка подключения: " + exception.getMessage());
        }
    }

    public static void addNewBook(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO books (title, author_id, published_year) VALUES ('Вий', 10, 1835)");
    }

    public static void addNewReader(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO readers (first_name, last_name, email) VALUES ('Виктор', 'Павлов', 'viktor.pavlov@mail.ru')");
    }

    public static void outputBooks(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
        while (resultSet.next()) {
            System.out.println("ID книги: " + resultSet.getInt("id") +
                    " | Название: " + resultSet.getString("title") +
                    " | ID автора: " + resultSet.getInt("author_id") +
                    " | Год публикации: " + resultSet.getInt("published_year"));
        }
    }

    public static void outputReaders(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM readers");
        while (resultSet.next()) {
            System.out.println("ID читателя: " + resultSet.getInt("id") +
                    " | Имя: " + resultSet.getString("first_name") +
                    " | Фамилия: " + resultSet.getString("last_name") +
                    " | Электронная почта: " + resultSet.getString("email"));
        }
    }

    public static void outputAuthors(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM authors");
        while (resultSet.next()) {
            System.out.println("ID автора: " + resultSet.getInt("id") +
                    " | Имя: " + resultSet.getString("first_name") +
                    " | Фамилия: " + resultSet.getString("last_name"));
        }
    }

    public static void updateBook(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE books SET published_year = 2025 WHERE id = ?");
        preparedStatement.setInt(1, 2);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void deleteBook(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books WHERE id = ?");
        preparedStatement.setInt(1, 2);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void addBookAndAuthor(Connection connection, Statement statement) throws SQLException {
        connection.setAutoCommit(false);
        try {
            statement.executeUpdate("INSERT INTO authors (first_name, last_name) VALUES ('Николай', 'Гоголь')",
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int authorId = 0;
            if (generatedKeys.next()) {
                authorId = generatedKeys.getInt(1);
                System.out.println("ID добавленного автора: " + authorId);
            }
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO books (title, author_id, published_year) VALUES ('Мёртвые души', ?, 1842)");
            preparedStatement.setInt(1, authorId);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException exception) {
            connection.rollback();
            System.out.println("Ошибка при добавлении автора и книги: " + exception.getMessage());
        }
        connection.setAutoCommit(true);
    }

    public static void searchBook(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите фамилию автора: ");
        String lastName = scanner.nextLine();
        scanner.close();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT title, published_year FROM authors, books WHERE author_id = authors.id AND last_name = ?");
        preparedStatement.setString(1, lastName);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        while (resultSet.next()) {
            System.out.println("Название книги: " + resultSet.getString("title") +
                    " | Год публикации: " + resultSet.getInt("published_year"));
        }
    }
}