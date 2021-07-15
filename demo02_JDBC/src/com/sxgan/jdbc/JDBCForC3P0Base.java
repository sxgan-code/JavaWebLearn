package com.sxgan.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCForC3P0Base {
    
    public static Connection getConnection() {
        //方式一：获取连接
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/javawebdata?serverTimezone=UTC");
            cpds.setUser("root");
            cpds.setPassword("201710262118");
            Connection connection = cpds.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        方式二：获取连接（通过配置文件进行）
        DataSource cp  = new ComboPooledDataSource();
        Connection con = null;
        try {
            con = cp.getConnection();
            System.out.println(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void close(Statement sm, Connection con){
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
