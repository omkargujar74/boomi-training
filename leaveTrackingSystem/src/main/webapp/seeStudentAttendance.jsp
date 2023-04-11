<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.boomi.leavetrackingsystem.service.AttendanceService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.Attendance" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 11/04/23
  Time: 4:07 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>see-student-attendance</title>
    <link rel="stylesheet" href="./style/studentTable.css">
    <link rel="stylesheet" href="./style/homeButton.css">
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        String attendanceDate = request.getParameter("attendanceDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localAttendanceDate = LocalDate.parse(attendanceDate, formatter);
        int id = Integer.parseInt(request.getParameter("id"));

        AttendanceService attendanceService = new AttendanceService();
        Attendance attendanceByDateId = attendanceService.getAttendanceByDateId(localAttendanceDate, id);
        if (attendanceByDateId != null) {
%>
<button style="float: left;margin-left: 20px"
        class="button-18" role="button"
        onclick="window.location.href='studentHome.jsp'">Home
</button>
<br><br><br>
<table style="border-bottom-width: thick">
    <tr>
        <td>
            <p style="margin: 30px">
            <h3>Date : <%=attendanceDate%>
            </h3>
            </p>
        </td>
    </tr>
</table>
<table class="center" style="width:100%">
    <caption style="text-align: center"><h2 style="font-weight: bold;color: #09223b">Attendance</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Power System II</th>
        <th>Control System I</th>
        <th>Utilization of Electric Energy</th>
        <th>Design of Electric Machines</th>
        <th>Energy Audit and Management</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><%= attendanceByDateId.getId()%>
        </td>
        <td><%= attendanceByDateId.getName()%>
        </td>
        <%
            if (attendanceByDateId.isPowerSystemII()) {
        %>
        <td style="background-color: green"><p style="color: white">Present</p></td>

        <%
        } else {
        %>
        <td style="background-color: red"><p style="color: white">Absent</p></td>
        <%
            }
        %>
        <%
            if (attendanceByDateId.isControlSystemI()) {
        %>
        <td style="background-color: green"><p style="color: white">Present</p></td>

        <%
        } else {
        %>
        <td style="background-color: red"><p style="color: white">Absent</p></td>
        <%
            }
        %><%
        if (attendanceByDateId.isUtilizationOfElectricEnergy()) {
    %>
        <td style="background-color: green"><p style="color: white">Present</p></td>

        <%
        } else {
        %>
        <td style="background-color: red"><p style="color: white">Absent</p></td>
        <%
            }
        %><%
        if (attendanceByDateId.isDesignOfElectricMachines()) {
    %>
        <td style="background-color: green"><p style="color: white">Present</p></td>

        <%
        } else {
        %>
        <td style="background-color: red"><p style="color: white">Absent</p></td>
        <%
            }
        %><%
        if (attendanceByDateId.isEnergyAuditAndManagement()) {
    %>
        <td style="background-color: green"><p style="color: white">Present</p></td>

        <%
        } else {
        %>
        <td style="background-color: red"><p style="color: white">Absent</p></td>
        <%
            }
        %>
    </tr>
    </tbody>
</table>
<%} else {%>
<div style="text-align: center">
    <h2 style="color:red;">Attendance has not been marked yet.</h2>
    <button style="margin-left: 20px"
            class="button-18" role="button"
            onclick="window.location.href='studentHome.jsp'">Home
    </button>
</div>
<%}
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
