<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    Integer userType = (Integer) session.getAttribute("userType");
    String homePage = (userType != null && userType == 2) ? "adminHome.jsp" : "home.jsp";
%>

<div style="text-align: center;"><a href="<%= homePage %>" style="display: inline-block; padding: 8px 12px; background-color: #007bff; color: white; text-decoration: none; border-radius: 5px;">
    返回主页面
</a>
</div>
