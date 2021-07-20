package com.sxgan.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
/*
该类的主要作用是将抽象的service方法重写，方便我们使用
* 同样我们也可以复写其他方法例如 init()方法
* */
@WebServlet("/extend")
public class ExtendServlet extends GenericServlet {
  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    System.out.println("继承GenericServlet类复写的service方法");
  }
}
