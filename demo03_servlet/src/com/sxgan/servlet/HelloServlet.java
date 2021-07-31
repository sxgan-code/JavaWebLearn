package com.sxgan.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet implements Servlet {
  /*初始化方法，当servlet被创建时执行，且只执行一次*/
  @Override
  public void init(ServletConfig servletConfig) throws ServletException {}
  /**
  获取ServletConfig，servlet的配置对象
  */
  @Override
  public ServletConfig getServletConfig() {
    return null;
  }
  /**
  提供服务的方法，每一次servlet被访问时执行，执行多次
  */
  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    System.out.println("Hello World");
    PrintWriter writer = servletResponse.getWriter();
    writer.println("hello world@@!ssssssssreyrss!!");
  }
  /*获取servlet的一些信息，例如：版本、作者等等。*/
  @Override
  public String getServletInfo() {
    return null;
  }
  /*当服务器正常关闭时执行*/
  @Override
  public void destroy() {}
}
