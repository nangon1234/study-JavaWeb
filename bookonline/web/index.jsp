<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/9/28
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.bo.entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>首页</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">

  <style type="text/css">
    h2, h3
    {
      color: rgb(73, 73, 73);
    }

    #search
    {
      height: 80px;
      background-color: rgb(246, 246, 241);
      display: flex;
      align-items: center;
      padding-left: 8%;
      margin-bottom: 10px;
    }

    .search-input
    {
      flex: 0 0 40%;
      height: 35px;
      background-color: #fff;
      border: none;
      border-radius: 3px;
      margin-left: 50px;
    }

    .search-btn
    {
      width: 20px;
      height: 35px;
      background-color: rgb(155, 154, 143);
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .search-btn img
    {
      width: 100%;
      height: 100%;
    }

    .card
    {
      height: 180px;
      margin: 20px 5px 20px 5px;
    }

    .card img
    {
      width: 100%;
      height: 90%;
    }

    .card p
    {
      font-size: 13px;
      color: #9b9b9b;
    }

    .col-4 img
    {
      margin: 10px 5px 20px 5px;
      width: 80%;
    }

    hr
    {
      width: 90%;
      color: #eee;
      margin-top: 10px;
    }

  </style>

</head>

<body>

<%
  List<Book> bookList = (List<Book>) request.getAttribute("bookList");
%>

<%--使用jsp的include动作，将top.jsp页面包含进来，这个顶部导航可以给各个页面共享--%>
<div id="top">
  <jsp:include page="top.jsp"/>
</div>

<%--搜索区--%>
<div id="search">

  <h2>读书时刻</h2>
  <%--<form action="/booksearch" method="get">--%>
  <input type="text" placeholder="书名、作者、ISBN" class="search-input" name="book_search_name">
      <div class="search-btn">
        <img src="images/search_book.png" alt="">
     </div>
  <%--</form>--%>

</div>

<%--主体内容区--%>
<div class="container">

  <div class="row">
    <%--左侧2/3主体部分--%>
    <div class="col-8">
      <h3>新书速递</h3>
      <hr>
      <div class="row">
        <%--遍历图书数据集合，将每个图书对象放入页面对象--%>
        <%
          for (Book book : bookList)
          {
            pageContext.setAttribute("book", book);
        %>

        <%--引用col-2表示每行显示5本，再追加card细节样式--%>
        <div class="col-2 card">
          <%--点击每本图书封面图，地址栏跳转为/detail/id,进入图书详情Servlet--%>
          <a href="${pageContext.request.contextPath}/detail/${book.id}">
            <img src="images/${book.cover}" alt="">
          <p style="color: rgb(51, 119, 178)">${book.name}</p>
          </a>
          <p>${book.author}</p>

        </div>

        <%
          }
        %>
      </div>
    </div>

    <div class="col-4">
      <h3>读书功能</h3>
      <hr>
      <img src="images/right2.jpg" alt="">
    </div>

  </div>


  <footer>
    <ul>
      <li>@2015-2019</li>
      <li>niit.edu.cn,</li>
      <li>all rights reserved</li>
      <li>南工院计算机学院</li>
    </ul>

    <ul>
      <li>联系我们</li>
      <li>帮助中心</li>
      <li>法律声明</li>
      <li>移动合作</li>
    </ul>
  </footer>

</div>
</body>
</html>
