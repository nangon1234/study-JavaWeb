package com.bo.servlet;

import com.bo.entity.Book;
import com.bo.service.BookSearchService;

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
 * @ClassName BookSearchServlet
 * @Description TODO
 * @Author nangon1234
 * @Date 2019/10/5
 * @Version 1.0
 **/
@WebServlet(urlPatterns="/booksearch")
public class BookSearchServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //预定义
        List<Book>bookList =null,
                search_bookList =null;
        BookSearchService booksearchService =null;
        //取得表单数据
        String book_search_name = req.getParameter("book_search_name");
        booksearchService = new BookSearchService();
        //获得图书列表数据
        ServletContext sc = this.getServletContext();
        bookList = (List<Book>) sc.getAttribute("bookList");
        //将数据传到bookSearchService
        booksearchService.setBookList(bookList);
        //调用查询功能
        search_bookList= booksearchService.search(book_search_name);
        if(search_bookList!=null)
          {
              HttpSession session = req.getSession();
              if(search_bookList.size()==0)
               {
                   session.setAttribute("bookList",bookList);
                   //查询失败，设置好响应对象字符集和响应类型
                   resp.setContentType("text/html;charset=UTF-8");
                   resp.setCharacterEncoding("UTF-8");
                   //获得response对象的字符输出流
                   PrintWriter out = resp.getWriter();
                   //输出js脚本，弹出查询失败的信息
                   out.print("<script>alert('书籍不存在');location.href='/index.jsp';</script>");
               }
              //查询成功，将查询图书列表对象记入session

              session.setAttribute("search_bookList", search_bookList);
              if(search_bookList.size()>1)
                {
                    //重定向到/index，进入IndexServlet
                    resp.sendRedirect("/index");
                }
              if(search_bookList.size()==1)
                {
                    //重定向到/index，进入IndexServlet
                    resp.sendRedirect("/book_detail.jsp");
                }

          }
        else
            {
                resp.sendRedirect("/");
            }

    }
}

    