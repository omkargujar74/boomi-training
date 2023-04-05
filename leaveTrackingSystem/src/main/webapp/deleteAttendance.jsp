<%@ page import="com.boomi.leavetrackingsystem.model.Attendance" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.boomi.leavetrackingsystem.service.AttendanceService" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 04/04/23
  Time: 4:57 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete-attendance</title>
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        int id = Integer.parseInt(request.getParameter("id"));
        String attendanceDate = request.getParameter("attendanceDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localAttendanceDate = LocalDate.parse(attendanceDate, formatter);
        Attendance attendance = new Attendance();
        attendance.setId(id);
        attendance.setDate(localAttendanceDate);
        AttendanceService attendanceService = new AttendanceService();
        boolean status = attendanceService.deleteAttendance(attendance);
        if (status) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("seeAttendance.jsp");
            requestDispatcher.forward(request,response);
        } else {
            PrintWriter writer = response.getWriter();
            writer.print("<h2 style=\"color:red;\">Failed to delete Record</h2>");
        }
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
