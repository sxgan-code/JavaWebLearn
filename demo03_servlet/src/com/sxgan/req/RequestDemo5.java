package com.sxgan.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/req5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> parameterNames = req.getParameterNames();//获取所有参数名称
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            String val = req.getParameter(s);//根据名称获取值
            System.out.println(s+"="+ val);
    
        }
        System.out.println("=======获取多选框值");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println("hobby:"+hobby);
        }
        System.out.println("=======使用map集合获取参数");
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key : parameterMap.keySet()) {
            String[] strings = parameterMap.get(key);
            System.out.print(key);
            System.out.print("=");
            for (String string : strings) {
                System.out.print("["+string+"]");
            }
            System.out.println();
        }
        /*
        * 结果：
        *   name=daniel
        *   age=124
        *   hobby=hobby01
        *   =======获取多选框值
        *   hobby:hobby01
        *   hobby:hobby02
        *   =======使用map集合获取参数
        *   name=[daniel]
        *   age=[124]
        *   hobby=[hobby01][hobby02]
        * */
    }
}
