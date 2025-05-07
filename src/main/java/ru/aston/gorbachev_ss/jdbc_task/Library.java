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
                booksOutput(statement);
                statement.close();
            }
        } catch (SQLException exception) {
            System.out.println("Ошибка подключения: " + exception.getMessage());
        }
    }

    public static void addNewBook(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO books (title, author_id, published_year) VALUES ('Война и мир', 1, 1869)");
    }

    public static void addNewReader(Statement statement) throws SQLException {
        statement.executeUpdate("INSERT INTO readers (first_name, last_name, email) VALUES ('Влад', 'Иванов', 'vlad.ivanov@gmail.com')");
    }

    public static void booksOutput(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
        while (resultSet.next()) {
            System.out.println("ID книги: " + resultSet.getInt("id") +
                    ", Название: " + resultSet.getString("title") +
                    ", ID автора: " + resultSet.getInt("author_id") +
                    ", Год публикации: " + resultSet.getInt("published_year"));
        }
    }
}