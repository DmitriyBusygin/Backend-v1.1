package com.busdmv.backend.db;

import java.sql.*;

public class DBWorker {

    private static final String URL = "jdbc:postgresql://localhost:5432/dmitry.busugin";
    private static final String USERNAME = "dmitry.busugin";
    private static final String PASSWORD = "password";

    private static Connection conn; 

    public DBWorker() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Не удалось подключиться к базе данных!");
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }
}
