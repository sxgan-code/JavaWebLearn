package com.sxgan.test;

import com.sxgan.dao.JDBCUtils;
import com.sxgan.domain.UserAccount;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTest {
    /**
     * 测试Druid、JdbcTemplate
     */
    @Test
    public void test(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from user_account";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
    
    /**
     * 测试返回list数据
     */
    @Test
    public void test2(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from user_account";
        List<UserAccount> userAccounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserAccount>(UserAccount.class));
    
    }
}
