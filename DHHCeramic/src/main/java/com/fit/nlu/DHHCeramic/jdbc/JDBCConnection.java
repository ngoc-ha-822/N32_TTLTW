package com.fit.nlu.DHHCeramic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection() {
        String db = "dhhceramicdb";
        String host = "localhost";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String pass = "";
            String url = "jdbc:mysql://" + host + "/" + db;
            connection = DriverManager.getConnection(url, user, pass);
//            System.out.println("thanh cong");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}