<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 24/03/23
  Time: 11:52 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>changing_password</title>
    <link rel="stylesheet" href="./style/homeButton.css">
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    UserInfoService userInfoService = new UserInfoService();
    boolean status = userInfoService.changePassword(username, password);
    if (status) {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    } else {
        PrintWriter writer = response.getWriter();
%>
<h2>Failed to change password
    <h2>
        <div style="float: left;margin-left: 50px; margin-top:10px;font-size: large;">
            <form method="post">
                <input type="hidden" id="username" name="username" placeholder="Username"
                       value="<%=username%>" required>
                <input type="submit" formaction="changePassword.jsp"
                       value="Try Again" class="button-18">
            </form>
        </div>
            <%
    }
%>
</body>
</html>
