package com.busdmv.backend.beans;

import com.busdmv.backend.db.DBWorker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MessagesList {
        
    private ArrayList<Messages> messagesList = new ArrayList<Messages>();

    public ArrayList<Messages> getMessages() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
       
        Statement stmt = null;
        ResultSet rs = null;       

        String query = "select * from messages";
        try {
            stmt = DBWorker.getConnection().createStatement();            
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Messages messages = new Messages();
                messages.setId(rs.getInt("id"));
                messages.setClientId(rs.getString("client_id"));
                messages.setMessage(rs.getString("message"));
                messagesList.add(messages);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return messagesList;
    }

    public ArrayList<Messages> getMessagesList() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (!messagesList.isEmpty()) {
            return messagesList;
        } else {
            return getMessages();
        }
    }
}
