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
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        String attendanceDate = request.getParameter("attendanceDate");
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean attendance = Boolean.parseBoolean(request.getParameter("attendance"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localAttendanceDate = LocalDate.parse(attendanceDate, formatter);
        Attendance studAttendance = new Attendance();
        studAttendance.setId(id);
        studAttendance.setDate(localAttendanceDate);
        studAttendance.setName(name);
        String subName = (String) session.getAttribute("subName");

        switch (subName) {
            case "Power System II":
                studAttendance.setPowerSystemII(attendance);
                break;

            case "Control System I":
                studAttendance.setControlSystemI(attendance);
                break;

            case "Utilization of Electric Energy":
                studAttendance.setUtilizationOfElectricEnergy(attendance);
                break;

            case "Design of Electric Machines":
                studAttendance.setDesignOfElectricMachines(attendance);
                break;

            case "Energy Audit and Management":
                studAttendance.setEnergyAuditAndManagement(attendance);
                break;
        }

        AttendanceService attendanceService = new AttendanceService();
        attendanceService.markAttendance(studAttendance);
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/markAttendance.jsp");
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
