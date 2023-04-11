<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.boomi.leavetrackingsystem.service.AttendanceService" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 10/04/23
  Time: 5:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit-attendance-process</title>
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        String attendanceDate = request.getParameter("attendanceDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localAttendanceDate = LocalDate.parse(attendanceDate, formatter);

        int id = Integer.parseInt(request.getParameter("id"));
        boolean attendance = Boolean.parseBoolean(request.getParameter("attendance"));
        String subName = (String) session.getAttribute("subName");

        AttendanceService attendanceService = new AttendanceService();
        boolean status = attendanceService.markAttendance(localAttendanceDate, id, subName, attendance);
        if (!status) { %>
<div style="text-align: center">
    <h2 style="color:red;">Failed to Mark Attendance</h2>
    <button style="float: left;margin-left: 20px"
            class="button-18" role="button"
            onclick="window.location.href='adminHome.jsp'">Home
    </button>
</div>
<%
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("seeAttendance.jsp");
        requestDispatcher.forward(request,response);
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
