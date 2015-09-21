package com.busdmv.backend.db;
// Класс для личного теста
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        DBWorker worker = new DBWorker();
        Statement statement = null;
        ResultSet resultSet = null;
        
        String query = "select * from messages";
        try {
            statement = worker.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String clientId = resultSet.getString("client_id");
                String message = resultSet.getString("message");
                
                System.out.println(id + "\t" + clientId + "\t" + message);                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            statement.close();
            resultSet.close();
        }
        
    }
    
}