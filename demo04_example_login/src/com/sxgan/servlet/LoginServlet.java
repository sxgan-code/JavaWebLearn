package com.sxgan.servlet;

import com.sxgan.dao.UserDao;
import com.sxgan.domain.UserAccount;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        UserAccount userAccount = new UserAccount();
        try {
            BeanUtils.populate(userAccount, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserDao userDao = new UserDao();
        UserAccount newUserAccount = userDao.checkLogin(userAccount);
        if (newUserAccount != null) {
            req.setAttribute("newUserAccout", newUserAccount);
            req.getRequestDispatcher("success").forward(req, resp);
        } else {
            req.getRequestDispatcher("defeat").forward(req, resp);
        }
        
    }
}
