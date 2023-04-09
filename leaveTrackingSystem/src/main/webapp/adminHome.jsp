<%@ page import="com.boomi.leavetrackingsystem.model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 23/03/23
  Time: 3:24 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
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
        UserInfo userByUserName = userInfoService.getUserByUserName((String) session.getAttribute("username"));
        List<Subject> subjects = userByUserName.getSubjects();
        Subject subject = subjects.get(0);
        int subId = subject.getSubId();
        session.setAttribute("subId", subId);
        session.setAttribute("subName", subject.getName());
        List<UserInfo> allStudents = userInfoService.getAllStudents(subId);
        session.setAttribute("allStudents", allStudents);
%>
<br>
<div style="margin-right: 20px;float: right">
    <h5>Name : <%=userByUserName.getFirstName() + " " + userByUserName.getLastName()%>
        <br> Subject : <%=subject.getName()%>
    </h5>
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
               style="width:150px;height: 30px" required><br><br>
        <input type="submit" formaction="createAttendanceRecord.jsp" value="Mark Attendance"
               class="markAttendanceButton">
        <input type="submit" formaction="seeAttendance.jsp"
               value="See Attendance" class="markAttendanceButton">
    </form>
</div>
<div style="text-align: center;margin-top:10px">
    <button class="button-43"
            onclick="window.location.href='addProfessor.jsp'">Add Professor
    </button>
</div>
<form style="text-align: center;display: inline-block;margin-left: 25%;margin-top: 5%"
      action="addStudent.jsp"
      method="post">
    <h3>Add Student</h3>
    <br>
    <input type="text" id="id" name="id" placeholder="Id" required><br><br>
    <input type="text" id="firstName" name="firstName" placeholder="First Name" required><br><br>
    <input type="text" id="lastName" name="lastName" placeholder="Last Name" required><br><br>
    <label for="userType">Choose User Type:</label>
    <select name="userType" id="userType">
        <option value="student" selected>Student</option>
    </select><br><br>
    <label for="dateOfBirth">Birthday:</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth"><br><br>
    <input type="text" id="age" name="age" placeholder="Age" required><br><br>
    <input type="submit" class="button-34" value="Add Student" id="addStudent"><br><br>
</form>
<br><br>
<form style="text-align: center;display: inline-block;margin-left: 25%;margin-top: 5%"
      action="editUser.jsp"
      method="post">
    <label for="searchId">Search to edit/delete &nbsp;</label>
    <input type="text" id="searchId" name="id" placeholder="Id" required>
    <input type="submit" class="button-34" value="Search Student/Professor" id="SearchStudent"><br><br>
</form>
<br><br><br>
<table class="" style="width:100%">
    <caption style="text-align: center"><h2>Student List</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>DOB</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (UserInfo student : allStudents) {
    %>
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
