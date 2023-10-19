package com.quancm.blog.daos;


import com.quancm.blog.models.User;

import java.sql.*;

public class UserDao {
    // Database connection parameters
    private String jdbcURL = "jdbc:mysql://localhost:3306/blog";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    // Database connection
    private Connection connection;


    public UserDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean validate(User user) throws ClassNotFoundException {
        boolean result = false;


        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ? and password = ?");

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());


            ResultSet rs = preparedStatement.executeQuery();
            result = rs.next();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }


    public boolean addUser(User user) {
        String INSERT_USER_SQL = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}