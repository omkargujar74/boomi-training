<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.boomi.leavetrackingsystem.service.AttendanceService" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 15/04/23
  Time: 11:40 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete-attendance-by-date</title>
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        String attendanceDate = request.getParameter("attendanceDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localAttendanceDate = LocalDate.parse(attendanceDate, formatter);
        AttendanceService attendanceService = new AttendanceService();
        boolean status = attendanceService.deleteAttendanceByDate(localAttendanceDate);
        if (!status) { %>
<div style="text-align: center">
    <h2 style="color:red;">Failed to Delete Attendance Record</h2>
    <button style="float: left;margin-left: 20px"
            class="button-18" role="button"
            onclick="window.location.href='adminHome.jsp'">Home
    </button>
</div>
<%
        } else {
            response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/adminHome.jsp");
        }
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
