<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.UserInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 16/04/23
  Time: 12:17 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>see-professors</title>
    <link rel="stylesheet" href="./style/studentTable.css">
    <link rel="stylesheet" href="./style/homeButton.css">
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        UserInfoService userInfoService = new UserInfoService();
        List<UserInfo> allProfessor = userInfoService.getAllProfessor();
%>
<button style="float: left;margin-left: 20px"
        class="button-18" role="button"
        onclick="window.location.href='adminHome.jsp'">Home
</button>
<br><br><br>
<table class="" style="width:100%">
    <caption style="text-align: center"><h2 style="font-weight: bold;color: #09223b">Professor List</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>DOB</th>
        <th>Age</th>
        <th>Subject</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (UserInfo professor : allProfessor) {
    %>
    <tr>
        <td><%= professor.getId()%>
        </td>
        <td><%= professor.getFirstName()%>
        </td>
        <td><%= professor.getLastName()%>
        </td>
        <td><%= professor.getDateOfBirth() %>
        </td>
        <td><%= professor.getAge()%>
        </td>
        <td><%= professor.getSubjects().get(0).getName()%>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<%
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
