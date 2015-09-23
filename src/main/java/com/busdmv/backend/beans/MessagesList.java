package com.busdmv.backend.beans;

import com.busdmv.backend.db.DBWorker;
import com.busdmv.backend.db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessagesList {

    private ArrayList<Messages> messagesList = new ArrayList<Messages>();

    public ArrayList<Messages> getMessages() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        String query = "select * from messages";
        try {
            
            conn = DBWorker.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Messages messages = new Messages();
                messages.setId(rs.getInt("id"));
                messages.setClientId(rs.getString("client_id"));
                messages.setMessage(rs.getString("message"));
                messagesList.add(messages);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MessagesList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MessagesList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return messagesList;
    }

    public ArrayList<Messages> getMessagesList() {
        if (!messagesList.isEmpty()) {
            return messagesList;
        } else {
            return getMessages();
        }
    }
}
