package com.bo.servlet;

import com.bo.entity.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author nangon1234
 * @ClassName IndexServlet
 * @Description 拦截/index请求，获取所有图书数据，并通过服务器端转发跳转到主页
 * @Date 2019/9/27
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //获得各个Servlet共享的对象
        ServletContext sc = this.getServletContext();
        //取得全局应用对象中的变量
        List<Book> bookList = (List<Book>) sc.getAttribute("bookList");
        //存入request
        req.setAttribute("bookList", bookList);
        //
        /*resp.setContentType("Text/plain;charset=utf-8");
        resp.getWriter().print(bookList.toString());*/
        //通过服务器端转发，将数据带过去，并保持地址栏不变
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
