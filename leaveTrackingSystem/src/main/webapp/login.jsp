<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.UserInfo" %><%--
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
    <link rel="stylesheet" href="./style/homeButton.css">
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    UserInfoService userInfoService = new UserInfoService();
    if (userInfoService.checkUserByUserName(username)) {
        UserInfo userByUserName = userInfoService.getUserWithDecodePassword(username);
        if (password.equals(userByUserName.getPassword())) {
            if (userByUserName.isPasswordChanged()) {
                String userType = userByUserName.getUserType();
                session.setAttribute("username", username);
                session.setAttribute("isLogin", true);
                if (userType.equals("professor")) {
                    response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/adminHome.jsp");
                } else if (userType.equals("student")) {
                    response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/studentHome.jsp");
                }
            } else {
                session.setAttribute("isLogin", true);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("changePassword.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {%>
<div style="text-align: center">
    <h2 style="color:red;">Incorrect Password</h2>
    <button style="margin-left: 20px"
            class="button-18" role="button"
            onclick="window.location.href='index.jsp'">Try Again
    </button>
</div>
<%
    }
} else {
%>
<div style="text-align: center">
    <h2 style="color:red;">Incorrect Username</h2>
    <button style="margin-left: 20px"
            class="button-18" role="button"
            onclick="window.location.href='index.jsp'">Try Again
    </button>
</div>
<%
    }
%>
</body>
</html>

