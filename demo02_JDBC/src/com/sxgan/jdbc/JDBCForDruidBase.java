package com.sxgan.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCForDruidBase {
    private static DataSource ds;
    
    static {
        Properties pro = new Properties();
        InputStream in = JDBCForDruidBase.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(in);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*获取连接*/
    public static Connection getConnection() {
        Connection con = null;
        try {
             con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    /*关闭相关连接*/
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
