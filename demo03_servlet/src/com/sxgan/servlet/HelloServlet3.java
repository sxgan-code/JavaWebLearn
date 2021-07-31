package com.sxgan.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

// 使用注解配置servlet
@WebServlet("/hello3")
public class HelloServlet3 implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {
    }
    
    public ServletConfig getServletConfig() {
        return null;
    }
    
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("Hello servlet 3.0");
    }
    
    public String getServletInfo() {
        return null;
    }
    
    public void destroy() {
    }
}
