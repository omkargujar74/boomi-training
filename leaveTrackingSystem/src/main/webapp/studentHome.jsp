<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.UserInfo" %>
<%@ page import="com.boomi.leavetrackingsystem.model.Subject" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 09/04/23
  Time: 5:26 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student-home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./style/studentTable.css">
    <link rel="stylesheet" href="./style/attendanceButton.css">
    <link rel="stylesheet" href="./style/submitButton.css">
    <link rel="stylesheet" href="./style/addProfessorButton.css">
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        UserInfoService userInfoService = new UserInfoService();
        UserInfo student = userInfoService.getUserByUserName((String) session.getAttribute("username"));
        List<Subject> subjects = student.getSubjects();

%>
<div style="margin-right: 20px;float: right;margin-top: 20px">
<a href="http://localhost:8080/leaveTrackingSystem_war_exploded/"
   class="btn btn-info btn-lg" style="float: right">
    <span class="glyphicon glyphicon-log-out"></span> Log out
</a>
</div>
<div style="float: left;margin-left: 50px; margin-top:10px;font-size: large;">
    <form method="post">
        <label for="attendanceDate">Select Date</label>
        <input type="date"
               id="attendanceDate" name="attendanceDate"
               style="width:150px;height: 30px" required>
        <input type="hidden" name="id" id="id" value="<%=student.getId()%>">
        <br><br>
        <input type="submit" formaction="seeStudentAttendance.jsp"
               value="See Attendance" class="markAttendanceButton">
    </form>
</div>
<br><br><br>
<table class="" style="width:100%">
    <caption style="text-align: center"><h2 style="font-weight: bold;color: #09223b">Student Info</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>DOB</th>
        <th>Age</th>
        <th colspan="5">Subjects</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><%= student.getId()%>
        </td>
        <td><%= student.getFirstName()%>
        </td>
        <td><%= student.getLastName()%>
        </td>
        <td><%= student.getDateOfBirth() %>
        </td>
        <td><%= student.getAge()%>
        </td>
            <%
                for (Subject subject: subjects) {%>
        <td><%=subject.getName()%>
        </td>
        <%}
            %>
    </tr>
    </tbody>
</table>
<%
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%></body>
</html>
