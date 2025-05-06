package ru.aston.gorbachev_ss.jdbc_task;

import java.sql.*;

public class Library {

    public static void main(String[] args) {

        String url = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7777273";
        String user = "sql7777273";
        String password = "xRR4akh9BW";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();

                PreparedStatement ps = conn.prepareStatement("select * from emp where id = ?");

                ps.setInt(1, 1);

                ps.executeQuery();

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name TEXT)");

                stmt.executeUpdate("INSERT INTO users (name) VALUES ('Bob')");

                ResultSet rs = stmt.executeQuery("SELECT * FROM users");

                while (rs.next()) {
                    var i = rs.getInt(1);
                    rs.getInt(2);
                    rs.getInt(5);
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println("User ID: " + id + ", Name: " + name);


                    rs.getString(3);
                    rs.getString(4);
                }

                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}