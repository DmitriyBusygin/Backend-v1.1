package com.busdmv.backend.db;

import java.sql.*;
import java.util.logging.*;

public class DBWorker {

    //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
    private static final String URL = "jdbc:postgresql://localhost:5432/dmitry.busugin";
    private static final String USERNAME = "dmitry.busugin";
    private static final String PASSWORD = "password";

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    public static void main(String[] args) {
        try {
            //Загружаем драйвер
            Class.forName("org.postgresql.Driver").newInstance();
            System.out.println("Драйвер подключен");

            //Создаём соединение
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //Для использования SQL запросов существуют 3 типа объектов:
            //1.Statement: используется для простых случаев без параметров
            st = con.createStatement();

            //Выполним запрос
            rs = st.executeQuery("select * from messages");
            //result это указатель на первую строку с выборки
            //чтобы вывести данные мы будем использовать 
            //метод next() , с помощью которого переходим к следующему элементу
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "   \t" + rs.getString(2)
                        + "   \t" + rs.getString(3));
            }
        } catch (Exception ex) {
            System.out.println("Не удалось соединиться с БД");
            Logger.getLogger(DBWorker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println("Не удалось закрыть соединения");
                Logger.getLogger(DBWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //return con;
    }

}
