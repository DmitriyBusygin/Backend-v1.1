package com.busdmv.backend.beans;

import com.busdmv.backend.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessagesList {

    private final ArrayList<Messages> messagesList = new ArrayList<>();
    private final String query = "select * from messages";

    public ArrayList<Messages> getMessages() throws ClassNotFoundException, SQLException {

        try (Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                Messages messages = new Messages();
                messages.setId(rs.getInt("id"));
                messages.setClientId(rs.getString("client_id"));
                messages.setMessage(rs.getString("message"));
                messagesList.add(messages);
            }
        }
        return messagesList;
    }

    public ArrayList<Messages> getMessagesList() throws ClassNotFoundException, SQLException {
        if (!messagesList.isEmpty()) {
            return messagesList;
        } else {
            return getMessages();
        }
    }
}
