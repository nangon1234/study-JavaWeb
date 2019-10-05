package com.bo.servlet;

import com.bo.entity.User;
import com.bo.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author nangon1234
 * @ClassName LoginServlet
 * @Description 拦截/login.do请求，获得表单传递的参数，进行登录功能验证
 * @Date 2019/9/27
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/login.do")
/**
 * 成功
 */
public class LoginServlet extends HttpServlet
{
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //取得表单参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("check_code");
        String saveCode = (String) req.getSession().getAttribute("check_code");
        UserService userService = new UserService();
        //获得用户列表数据
        ServletContext sc = this.getServletContext();
        List<User> userList = (List<User>) sc.getAttribute("userList");
        //将数据传到userService
        userService.setUserList(userList);
        //调用登录功能
        User user = userService.signIn(account, password);
        if (user != null&&checkCode.equalsIgnoreCase(saveCode))
        {
            //登录成功，将用户对象记入session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //重定向到/index，进入IndexServlet
            resp.sendRedirect("/index");
        }
        else
            {
            //登录失败，设置好响应对象字符集和响应类型
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            //获得response对象的字符输出流
            PrintWriter out = resp.getWriter();
            //输出js脚本，弹出登录失败的信息
            out.print("<script>alert('账号或密码错误');location.href='/';</script>");
            }
    }

}
