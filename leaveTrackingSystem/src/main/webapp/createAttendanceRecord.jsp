<%@ page import="com.boomi.leavetrackingsystem.model.UserInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.boomi.leavetrackingsystem.model.Attendance" %>
<%@ page import="com.boomi.leavetrackingsystem.service.AttendanceService" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 25/03/23
  Time: 4:06 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>createAttendanceRecord</title>
    <link rel="stylesheet" href="./style/homeButton.css">
    <link rel="stylesheet" href="./style/attendanceButton.css">
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {

        List<UserInfo> allStudents = (List<UserInfo>) session.getAttribute("allStudents");
        String attendanceDate = request.getParameter("attendanceDate");
        session.setAttribute("attendanceDate", attendanceDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localAttendanceDate = LocalDate.parse(attendanceDate, formatter);
        AttendanceService attendanceService = new AttendanceService();
        List<Attendance> attendanceByDate = attendanceService.getAttendanceByDate(localAttendanceDate);
        if (attendanceByDate.isEmpty()) {
            for (UserInfo student : allStudents) {
                Attendance studAttendance = new Attendance();
                studAttendance.setId(student.getId());
                studAttendance.setDate(localAttendanceDate);
                studAttendance.setName(student.getFirstName() + " " + student.getLastName());
                boolean status = attendanceService.createAttendance(studAttendance);
                if (!status) { %>
<div style="text-align: center">
    <h2 style="color:red;">Failed to Create Attendance Sheet</h2>
    <button style="float: left;margin-left: 20px"
            class="button-18" role="button"
            onclick="window.location.href='adminHome.jsp'">Home
    </button>
</div>
<%
        }
    }
    response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/markAttendance.jsp");
} else {%>
<div style="text-align: center">
    <h2 style="color:red;">Attendance has already been marked for this date ( <%=attendanceDate%> ).</h2>
    <form method="post">
        <input type="hidden"
               id="attendanceDate" name="attendanceDate"
               style="width:150px;height: 30px" value="<%=attendanceDate%>">
        <button style="margin-left: 20px"
                class="button-18" role="button"
                onclick="window.location.href='adminHome.jsp'">Home
        </button>
        <input type="submit" formaction="seeAttendance.jsp"
               value="See Attendance" class="markAttendanceButton">
    </form>
</div>
<%
        }
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
