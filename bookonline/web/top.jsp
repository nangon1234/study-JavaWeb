<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/9/28
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.bo.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");
    pageContext.setAttribute("user", user);
%>
<ul>

    <li>
        <a href="${pageContext.request.contextPath}/index">首页</a>
    </li>

    <li>
        <a href="#">读书</a>
    </li>

    <li>
        <a href="#">音乐</a>
    </li>

    <li>
        <a href="#">小组</a>
    </li>

    <li>
        <a href="#">同城</a>
    </li>

    <li>
        <a href="#">FM</a>
    </li>

    <li>
        <a href="#">时间</a>
    </li>

    <li>
        <a href="#">更多</a>
    </li>

</ul>

<ul>
    <%--根据user是否为空，显示不同的内容--%>
    <%
        if (user != null)
        {
    %>

    <li>
        <a href="${pageContext.request.contextPath}/user">
            <img src="${pageContext.request.contextPath}/images/${user.avatar}" alt="" class="avatar">
        </a>
    </li>

    <li>
        <a href="${pageContext.request.contextPath}/logout">退出</a>
    </li>

    <%
    }
        else
        {
    %>

        <a href="${pageContext.request.contextPath}/login">去登录</a>
    <%
        }
    %>

</ul>
