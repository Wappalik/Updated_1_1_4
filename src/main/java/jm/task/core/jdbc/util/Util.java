package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String URL = "jdbc:mysql://localhost:3306/wappalik";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "dumbalik97";
    static Connection connection;

    public static Connection getConnection () {

        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
//            if (!connection.isClosed()) {
//                System.out.println("Работаем братья");
//            }
//            connection.close();
//            if (connection.isClosed()) {
//                System.out.println("Закрыто соединение");
//            } else {
//                System.out.println("Не закрылось");
//            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
            return connection;
        }

    }



