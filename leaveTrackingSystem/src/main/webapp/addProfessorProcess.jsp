<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.boomi.leavetrackingsystem.service.SubjectService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 26/03/23
  Time: 12:15 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add_professor_process</title>
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
        int subId = Integer.parseInt(request.getParameter("subject"));
        SubjectService subjectService = new SubjectService();
        List<Subject> allSubjects = new ArrayList<>();
        Subject subjectById = subjectService.getSubjectById(subId);

        allSubjects.add(subjectById);

        UserInfoService userInfoService = new UserInfoService();
        boolean status = userInfoService.addUser(id, firstName, lastName, localDateOfBirth, age, userType, allSubjects);
        if (status) {
            response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/adminHome.jsp");
        } else {
            PrintWriter writer = response.getWriter();
            writer.print("<h2 style=\"color:red;\">Failed to add Professor</h2>");
        }
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
