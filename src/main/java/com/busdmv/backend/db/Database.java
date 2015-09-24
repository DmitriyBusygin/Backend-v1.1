package com.busdmv.backend.db;

import java.sql.*;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/dmitry.busugin";
    private static final String USERNAME = "dmitry.busugin";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
