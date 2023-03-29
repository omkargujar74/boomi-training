<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 26/03/23
  Time: 1:36 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete_user</title>
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        int id = Integer.parseInt(request.getParameter("id"));
        UserInfoService userInfoService = new UserInfoService();
        boolean status = userInfoService.deleteUser(id);
        if (status) {
            response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/adminHome.jsp");
        } else {
            PrintWriter writer = response.getWriter();
            writer.print("<h2 style=\"color:red;\">Failed to delete User</h2>");
        }
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
