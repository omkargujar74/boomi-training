<%--
  Created by IntelliJ IDEA.
  User: rakshithrk
  Date: 24/03/23
  Time: 11:14 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>change_password</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="./style/loginPage.css">
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
%>
<div id="login-form-wrap">
    <h2>Change Password</h2>
    <form id="login-form" action="changePasswordProcess.jsp" method="post">
        <p>
            <input type="text" id="username" name="username" placeholder="Username"
                   value="<%=request.getParameter("username")%>" required><i
                class="validation"><span></span><span></span></i>
        </p>
        <p>
        <p style="font-size: 15px">Password should be 8–16 characters. It should have at least 1 upper case,
            1 number, and 1 special character.</p>
        <input type="password" id="password" name="password" placeholder="New Password" required><i
            class="validation"><span></span><span></span></i>
        </p>
        <p>
            <input type="submit" id="login" value="Login">
        </p>
        <br><br>
    </form>
</div>
<%
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>