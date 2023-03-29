<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.UserInfo" %>
Created by IntelliJ IDEA.
User: omkargujar
Date: 23/03/23
Time: 3:16 pm
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authenticate_Login</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    UserInfoService userInfoService = new UserInfoService();
    UserInfo userByUserName = userInfoService.getUserWithDecodePassword(username);
    if (userByUserName != null && password.equals(userByUserName.getPassword()) && userByUserName.isPasswordChanged()) {
        String userType = userByUserName.getUserType();
        session.setAttribute("username", username);
        session.setAttribute("isLogin", true);
        if (userType.equals("professor")) {
            response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/adminHome.jsp");
        } else if (userType.equals("student")) {
            response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/studentHome.jsp");
        }
    } else if (!userByUserName.isPasswordChanged()) {
        session.setAttribute("isLogin", true);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("changePassword.jsp");
        requestDispatcher.forward(request, response);
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>

