<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 26/03/23
  Time: 1:07 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit_user_process</title>
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        String dateOfBirth = request.getParameter("dateOfBirth");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateOfBirth = LocalDate.parse(dateOfBirth, formatter);
        int id = Integer.parseInt(request.getParameter("id"));
        int age = Integer.parseInt(request.getParameter("age"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        UserInfoService userInfoService = new UserInfoService();
        UserInfo userById = userInfoService.getUserById(id);
        userById.setFirstName(firstName);
        userById.setLastName(lastName);
        userById.setDateOfBirth(localDateOfBirth);
        userById.setAge(age);
        boolean status = userInfoService.updateUser(userById);
        if (status) {
            response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/adminHome.jsp");
        } else {
            PrintWriter writer = response.getWriter();
            writer.print("<h2 style=\"color:red;\">Failed to edit User</h2>");
        }
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
