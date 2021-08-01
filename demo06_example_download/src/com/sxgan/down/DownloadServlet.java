package com.sxgan.down;

import com.sxgan.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0.设置请求参数编码
        req.setCharacterEncoding("UTF-8");
        //1.获取请求参数，文件名称
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fin = new FileInputStream(realPath);
        //3.设置response的响应头
        //3.1设置响应头类型：Content-Type
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("Content-Type",mimeType);
        //3.2设置响应头打开方式:content-disposition
        //解决中文文件名问题
        //获取user-agent请求头
        String agent = req.getHeader("user-agent");
        //使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream out = resp.getOutputStream();
        byte [] buff = new byte[1024*8];
        int len = 0;
        while((len = fin.read(buff))!=-1){
            out.write(buff,0,len);
        }
        
        fin.close();
    }
}
