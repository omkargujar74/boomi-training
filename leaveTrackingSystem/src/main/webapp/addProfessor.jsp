<%@ page import="com.boomi.leavetrackingsystem.service.SubjectService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomi.leavetrackingsystem.model.UserInfo" %>
<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %>
<%@ page import="java.util.stream.Collectors" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 25/03/23
  Time: 11:56 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add_professor</title>
    <link rel="stylesheet" href="./style/submitButton.css">
    <link rel="stylesheet" href="./style/homeButton.css">
</head>
<body style="font-weight: bold;font-size: large">
<%
    if (session.getAttribute("isLogin") != null) {
        SubjectService subjectService = new SubjectService();
        List<Subject> allSubjects = subjectService.getAllSubjects();

        UserInfoService userInfoService = new UserInfoService();
        List<UserInfo> allProfessor = userInfoService.getAllProfessor();
        List<Subject> subjects = allSubjects.stream().filter(subject -> {
            boolean status = true;
            for (UserInfo professor : allProfessor) {
                status = !professor.getSubjects().get(0).getName().equals(subject.getName());
            }
            return status;
        }).collect(Collectors.toList());
%>
<button style="float: left;margin-left: 20px"
        class="button-18" role="button"
        onclick="window.location.href='adminHome.jsp'">Home
</button>
<br><br><br>
<form style="text-align: center;display: inline-block;margin-left: 40%;margin-top: 5%" action="addProfessorProcess.jsp"
      method="post">
    <h2>Add Professor</h2>
    <br>
    <input type="text" id="id" name="id" placeholder="Id" required><br><br>
    <input type="text" id="firstName" name="firstName" placeholder="First Name" required><br><br>
    <input type="text" id="lastName" name="lastName" placeholder="Last Name" required><br><br>
    <input type="hidden" name="userType" id="userType" value="professor">
    <label for="subject">Select Subject:</label>
    <select name="subject" id="subject">
        <option selected></option>
        <%
            for (Subject subject : subjects) {
        %>
        <option value="<%=subject.getSubId()%>"><%=subject.getName()%>
        </option>
        <%
            }
        %>
    </select><br><br>
    <label for="dateOfBirth">Birthday:</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth"><br><br>
    <input type="text" id="age" name="age" placeholder="Age" required><br><br><br>
    <input type="submit" class="button-34" value="Add Professor" id="addProfessor"><br><br>
</form>
<%
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
