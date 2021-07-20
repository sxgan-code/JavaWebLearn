package com.sxgan.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////      1. 获取请求方式 ：GET
        String method = req.getMethod();
        System.out.println("1.请求方式："+method);
     
//        2. ( *)获取虚拟目录：/day14
        String contextPath = req.getContextPath();
        System.out.println("2.虚拟目录："+contextPath);
//        3. 获取Servlet路径: /demo1
        String servletPath = req.getServletPath();
        System.out.println("3.获取Servlet路径："+servletPath);
//        4. 获取get方式请求参数：name = zhangsan
        String queryString = req.getQueryString();
        System.out.println("4.获取get方式请求参数："+queryString);
//        5. ( *)获取请求URI：/day14 / demo1
        String requestURI = req.getRequestURI();
        System.out.println("5.获取请求URI："+requestURI);
//        6.获取URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("6.获取URL："+requestURL);
//   *URL:
//        统一资源定位符 ：http:
////localhost/day14/demo1	中华人民共和国
//   *URI：统一资源标识符: /day14 / demo1 共和国
//        7. 获取协议及版本：HTTP / 1.1
        String protocol = req.getProtocol();
        System.out.println("7.获取协议及版本："+protocol);
//        8. 获取客户机的IP地址：
        String remoteAddr = req.getRemoteAddr();
        System.out.println("8.获取客户机的IP地址："+remoteAddr);
    }
    /*
    1.请求方式：GET
    2.虚拟目录：/deom03
    3.获取Servlet路径：/req1
    4.获取get方式请求参数：name=daniel&age=22
    5.获取请求URI：/deom03/req1
    6.获取URL：http://localhost/deom03/req1
    7.获取协议及版本：HTTP/1.1
    8.获取客户机的IP地址：0:0:0:0:0:0:0:1
*/
}
