package com.busdmv.backend.beans;
/**
 * Тестовый класс, для проверки подключения к БД и вывода данных в консоль IDE
 */
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MessagesList messagesList = new MessagesList();
        for (Messages messages : messagesList.getMessagesList()) {
            System.out.println(messages.getId()
                    + "\t" + messages.getClientId());
        }
    }
}
