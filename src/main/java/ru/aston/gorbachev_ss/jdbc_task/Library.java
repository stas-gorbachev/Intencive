package ru.aston.gorbachev_ss.jdbc_task;

import java.sql.*;

public class Library {

    public static void main(String[] args) {

        String url = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7777273";
        String user = "sql7777273";
        String password = "xRR4akh9BW";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                Statement statement = connection.createStatement();
//                addNewBook(statement);
//                addNewReader(statement);
                outputBooks(statement);
//                outputReaders(statement);
//                outputAuthors(statement);
//                updateBook(connection);
                deleteBook(connection);
                outputBooks(statement);
                statement.close();
            }
        } catch (SQLException exception) {
            System.out.println("Ошибка подключения: " + exception.getMessage());
        }
    }

    public static void addNewBook(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO books (title, author_id, published_year) VALUES ('Портрет Дориана Грея', 2, 1891)");
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
}