<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>log-in-page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="./style/loginPage.css">
</head>
<body>
<%
    session.invalidate();
%>
<div id="login-form-wrap">
    <h2>Login</h2>
    <form id="login-form" action="login.jsp" method="post">
        <p>
            <input type="text" id="username" name="username" placeholder="Username" required><i
                class="validation"><span></span><span></span></i>
        </p>
        <p>
            <input type="password" id="password" name="password" placeholder="Password" required><i
                class="validation"><span></span><span></span></i>
        </p>
        <p>
            <input type="submit" id="login" value="Login">
        </p>
        <br><br>
    </form>
</div>
</body>
</html>