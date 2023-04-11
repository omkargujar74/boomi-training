<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.boomi.leavetrackingsystem.service.SubjectService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 24/03/23
  Time: 4:29 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add_student</title>
    <link rel="stylesheet" href="./style/homeButton.css">
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
        String userType = request.getParameter("userType");
        SubjectService subjectService = new SubjectService();
        List<Subject> allSubjects = subjectService.getAllSubjects();

        UserInfoService userInfoService = new UserInfoService();
        boolean status = userInfoService.addUser(id, firstName, lastName, localDateOfBirth, age, userType, allSubjects);
        if (status) {
            response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/adminHome.jsp");
        } else { %>
<div style="text-align: center">
<h2 style="color:red">Failed to add Student</h2>
<h3>Please provide valid information</h3>
<button style="margin-left: 20px"
        class="button-18" role="button"
        onclick="window.location.href='adminHome.jsp'">Home
</button>
</div>
<%
        }
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
