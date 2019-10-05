package com.bo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nangon1234
 * @ClassName LoginPagesServlet
 * @Description 登录页面url转发
 * @Date 2019/9/27
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/login")
public class LoginPagesServlet  extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/login.html").forward(req, resp);
    }
}
