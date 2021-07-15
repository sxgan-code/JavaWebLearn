package com.sxgan.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class DataBase {
    private static String DRIVER;
    private static String USER;
    private static String PASSWORD;
    private static String URL;
    
    static {
        ResourceBundle db = ResourceBundle.getBundle("db");
        DRIVER = db.getString("mysql.jdbc.driver");
        URL = db.getString("mysql.jdbc.url");
        USER = db.getString("mysql.jdbc.user");
        PASSWORD = db.getString("mysql.jdbc.pow");
    }
    
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void close(Statement sm,Connection con){
        close(null,sm,con);
    }
    public static void close(ResultSet rs , Statement sm, Connection con){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sm!=null){
            try {
                sm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con!=null){
            try {
                sm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
