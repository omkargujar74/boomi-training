<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.boomi.leavetrackingsystem.service.AttendanceService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.Attendance" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 25/03/23
  Time: 8:03 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>see_attendance</title>
    <link rel="stylesheet" href="./style/studentTable.css">
    <link rel="stylesheet" href="./style/homeButton.css">
    <link rel="stylesheet" href="./style/attendanceButton.css">
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        String subName = (String) session.getAttribute("subName");
        String attendanceDate = request.getParameter("attendanceDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localAttendanceDate = LocalDate.parse(attendanceDate, formatter);

        AttendanceService attendanceService = new AttendanceService();
        List<Attendance> attendanceByDate = attendanceService.getAttendanceByDate(localAttendanceDate);
%>
<button style="float: left;margin-left: 20px"
        class="button-18" role="button"
        onclick="window.location.href='adminHome.jsp'">Home
</button>
<div style="float: left;margin-left: 50px; margin-top:10px;font-size: large;">
    <form method="post">
        <input type="hidden"
               id="attendanceDate" name="attendanceDate"
               style="width:150px;height: 30px" value="<%=attendanceDate%>"><br><br>
        <input type="submit" formaction="createAttendanceRecord.jsp" value="Mark Attendance"
               class="markAttendanceButton">
    </form>
</div>
<br><br><br>
<table>
    <td>
        <p style="margin: 30px">
        <h2>Subject : <%=subName%>
        </h2>
        <h3>Date : <%=attendanceDate%>
        </h3>

        </p>
    </td>
</table>
<table class="center" style="width:100%">
    <caption style="text-align: center"><h2>Attendance</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Attendance</th>
    </tr>
    <tbody>
    <%
        for (Attendance student : attendanceByDate) {
            boolean attendance;
            switch (subName) {
                case "Power System II":
                    attendance = student.isPowerSystemII();
                    System.out.println(attendance);
                    break;

                case "Control System I":
                    attendance = student.isControlSystemI();
                    break;

                case "Utilization of Electric Energy":
                    attendance = student.isUtilizationOfElectricEnergy();
                    break;

                case "Design of Electric Machines":
                    attendance = student.isDesignOfElectricMachines();
                    break;

                case "Energy Audit and Management":
                    attendance = student.isEnergyAuditAndManagement();
                    break;
                default:
                    attendance = false;
            }
    %>
    <form method="post" action="markAttendanceProcess.jsp" id="markAttendance">
        <tr>
            <td><%= student.getId()%>
                <input type="hidden" name="id" value="<%= student.getId()%>">
                <input type="hidden" name="attendanceDate" value="<%=attendanceDate%>">
                <input type="hidden" name="name" value="<%=student.getName()%>">
            </td>
            <td><%= student.getName()%>
            </td>
            <%
                if (attendance) {
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
    </form>
    <% } %>
    </tbody>
    </thead>
</table>
</body>
<%
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</html>
