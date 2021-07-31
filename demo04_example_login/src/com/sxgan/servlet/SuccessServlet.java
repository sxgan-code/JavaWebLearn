package com.sxgan.servlet;

import com.sxgan.domain.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        
        UserAccount newUserAccout = (UserAccount) req.getAttribute("newUserAccout");
        System.out.println(newUserAccout.toString());
        writer.println("页面成功展示，登录成功！！欢迎："+newUserAccout.getAcctNum());
    }
}
