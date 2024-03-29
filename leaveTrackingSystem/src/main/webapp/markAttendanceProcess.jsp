<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.boomi.leavetrackingsystem.model.Attendance" %>
<%@ page import="com.boomi.leavetrackingsystem.service.AttendanceService" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 25/03/23
  Time: 1:07 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mark_attendance_process</title>
    <link rel="stylesheet" href="./style/homeButton.css">
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        int size = Integer.parseInt(request.getParameter("size"));
        String attendanceDate = request.getParameter("attendanceDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localAttendanceDate = LocalDate.parse(attendanceDate, formatter);

        for (int index = 0; index < size; index++) {
            String name = request.getParameter("name" + index);
            int id = Integer.parseInt(request.getParameter("id" + index));
            boolean attendance = Boolean.parseBoolean(request.getParameter("attendance" + index));
            String subName = (String) session.getAttribute("subName");

            AttendanceService attendanceService = new AttendanceService();
            boolean status = attendanceService.markAttendance(localAttendanceDate, id, subName, attendance);
            if (!status) { %>
<div style="text-align: center">
    <h2 style="color:red;">Failed to Mark Attendance</h2>
    <button style="margin-left: 20px"
            class="button-18" role="button"
            onclick="window.location.href='adminHome.jsp'">Home
    </button>
</div>
<%
            }
        }
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/adminHome.jsp");
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
