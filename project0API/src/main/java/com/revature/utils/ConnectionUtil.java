package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("problem occurred locating driver");
        }

        String url = "jdbc:postgresql://postgres.ckoukbxwfine.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=project0Schema";
        String username = "postgres";
        String password = "password";

        return DriverManager.getConnection(url, username, password);
    }
}
