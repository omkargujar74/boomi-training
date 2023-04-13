<%@ page import="com.boomi.leavetrackingsystem.model.UserInfo" %>
<%@ page import="com.boomi.leavetrackingsystem.model.Attendance" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomi.leavetrackingsystem.service.AttendanceService" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 12/04/23
  Time: 12:35 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student-attendance-sheet</title>
    <link rel="stylesheet" href="./style/studentTable.css">
    <link rel="stylesheet" href="./style/homeButton.css">
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        int id = Integer.parseInt(request.getParameter("id"));
        AttendanceService attendanceService = new AttendanceService();
        List<Attendance> allAttendance = attendanceService.getAttendanceById(id);
        if (!allAttendance.isEmpty()) {
%>
<button style="float: left;margin-left: 20px"
        class="button-18" role="button"
        onclick="window.location.href='studentHome.jsp'">Home
</button>
<br><br><br>
<table class="center" style="width:100%">
    <caption style="text-align: center"><h2 style="font-weight: bold;color: #09223b">Attendance</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Date</th>
        <th>Power System II</th>
        <th>Control System I</th>
        <th>Utilization of Electric Energy</th>
        <th>Design of Electric Machines</th>
        <th>Energy Audit and Management</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Attendance attendance : allAttendance) {
    %>
    <tr>
        <td><%= attendance.getId()%>
        </td>
        <td><%= attendance.getName()%>
        <td><%= attendance.getDate()%>
        </td>
        <%
            if (attendance.isPowerSystemII()) {
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
            if (attendance.isControlSystemI()) {
        %>
        <td style="background-color: green"><p style="color: white">Present</p></td>

        <%
        } else {
        %>
        <td style="background-color: red"><p style="color: white">Absent</p></td>
        <%
            }
        %><%
        if (attendance.isUtilizationOfElectricEnergy()) {
    %>
        <td style="background-color: green"><p style="color: white">Present</p></td>

        <%
        } else {
        %>
        <td style="background-color: red"><p style="color: white">Absent</p></td>
        <%
            }
        %><%
        if (attendance.isDesignOfElectricMachines()) {
    %>
        <td style="background-color: green"><p style="color: white">Present</p></td>

        <%
        } else {
        %>
        <td style="background-color: red"><p style="color: white">Absent</p></td>
        <%
            }
        %><%
        if (attendance.isEnergyAuditAndManagement()) {
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
    <%
        }
    %>
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
<%
        }
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
