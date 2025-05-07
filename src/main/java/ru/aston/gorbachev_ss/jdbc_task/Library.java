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
                readersOutput(statement);
                authorsOutput(statement);
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

    public static void booksOutput(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
        while (resultSet.next()) {
            System.out.println("ID книги: " + resultSet.getInt("id") +
                    " | Название: " + resultSet.getString("title") +
                    " | ID автора: " + resultSet.getInt("author_id") +
                    " | Год публикации: " + resultSet.getInt("published_year"));
        }
    }

    public static void readersOutput(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM readers");
        while (resultSet.next()) {
            System.out.println("ID читателя: " + resultSet.getInt("id") +
                    " | Имя: " + resultSet.getString("first_name") +
                    " | Фамилия: " + resultSet.getString("last_name") +
                    " | Электронная почта: " + resultSet.getString("email"));
        }
    }

    public static void authorsOutput(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM authors");
        while (resultSet.next()) {
            System.out.println("ID автора: " + resultSet.getInt("id") +
                    " | Имя: " + resultSet.getString("first_name") +
                    " | Фамилия: " + resultSet.getString("last_name"));
        }
    }
}