package com.sxgan.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import com.sxgan.domain.UserInfo;
import com.sxgan.jdbc.DataBase;
import com.sxgan.jdbc.JDBCForC3P0Base;
import com.sxgan.jdbc.JDBCForDruidBase;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sun.java2d.opengl.WGLSurfaceData;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class JdbcTest {
    @Test
    /*测试普通连接方式*/
    public void test1(){
        Connection con = DataBase.getConnection();
        try {
            String sql = "INSERT INTO user_info VALUES(DEFAULT,'test4',22,'男','居民身份证','123456199903052225','13866656655')";
            Statement sm = con.createStatement();
            int execute = sm.executeUpdate(sql);
            System.out.println(execute );
            DataBase.close(sm,con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*测试c3p0连接数据库*/
    @Test
    public void test2(){
        Connection con = JDBCForC3P0Base.getConnection();
        try {
            String sql = "INSERT INTO user_info VALUES(DEFAULT,'test4',22,'男','居民身份证','123456199903052225','13866656655')";
            Statement sm = con.createStatement();
            int execute = sm.executeUpdate(sql);
            System.out.println(execute );
            JDBCForC3P0Base.close(sm,con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*测试druid连接数据库*/
    @Test
    public void test3(){
        Connection con = JDBCForDruidBase.getConnection();
        try {
            String sql = "INSERT INTO user_info VALUES(DEFAULT,'test4',22,'男','居民身份证','123456199903052225','13866656655')";
            Statement sm = con.createStatement();
            int execute = sm.executeUpdate(sql);
            System.out.println(execute );
            JDBCForDruidBase.close(sm,con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*使用spring JDBC*/
    @Test
    public void test4(){
        DataSource ds = new ComboPooledDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
//        1. 修改1号数据的 username 为 daniel
        String sql = "update user_info set username ='daniel' where userid =1";
        int update = template.update(sql);
        System.out.println("更新了"+update+"条数据！！！");
        
//        2. 添加一条记录
        String sql1 = "insert into user_info values(default,'添加的',?,?,'居民身份证','235154444444445487',?)";
        int update1 = template.update(sql1, 999, "男", "16325487894");//对应varchar为string类型，不可填char类型
        System.out.println("插入了"+update1+"条数据！！！");
//        3. 删除刚才添加的记录
        String sql2 = "delete from user_info where userage=? ";
        int update2 = template.update(sql2, 999);
        System.out.println("删除了"+update2+"条数据！！！");
//        4. 查询id为1的记录，将其封装为Map集合
        String sql3 = "select * from user_info where username=?";
        Map<String, Object> select = template.queryForMap(sql3,"daniel");
        System.out.println("一条记录"+select);
//        5. 查询所有记录，将其封装为List
        String sql4 = "select * from user_info";
        List<Map<String, Object>> maps = template.queryForList(sql4);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
//        6. 查询所有记录，将其封装为Emp对象的List集合
        List<UserInfo> query = template.query(sql4, new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserid(resultSet.getInt("userid"));
                userInfo.setUsername(resultSet.getString("username"));
                userInfo.setUserage(resultSet.getInt("userage"));
                userInfo.setUsersex(resultSet.getString("usersex"));
                userInfo.setCerttype(resultSet.getString("certtype"));
                userInfo.setCertid(resultSet.getString("certid"));
                userInfo.setPhone(resultSet.getString("phone"));
                return userInfo;
            }
        });
        System.out.println("===========方式一：对象List打印========");
        for (UserInfo userInfo : query) {
            System.out.println(userInfo.toString());
        }
//        6.2简化以上操作
        List<UserInfo> query1 = template.query(sql4, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
        System.out.println("============方式二：对象List打印========");
        for (UserInfo userInfo : query1) {
            System.out.println(userInfo.toString());
        }
//        7. 查询总记录数
        String sql5 = "select count(*) from user_info";
        Long total = template.queryForObject(sql5,Long.class);
        System.out.println("总记录数为："+total);
    }
}
