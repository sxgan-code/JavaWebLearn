package com.sxgan.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/req6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        处理获取到客户端的数据乱码问题
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        System.out.println(name);
//        处理输出页面的响应数据乱码问题
        resp.setContentType("text/html;charset=utf-8");
//        resp.setCharacterEncoding("utf-8");//还是会有乱码
        PrintWriter out = resp.getWriter();
        out.println("你好，天外来物！！！");
    }
}
