package com.sxgan.dao;

import com.sxgan.domain.UserAccount;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public UserAccount checkLogin(UserAccount userAccount) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        UserAccount newUserAcct = null;
        System.out.println(userAccount.toString());
        try {
            String sql = "select * from user_account where acctNum=? and acctPwd=?";
            newUserAcct = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserAccount>(UserAccount.class), userAccount.getAcctNum(), userAccount.getAcctPwd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUserAcct;
    }
}
