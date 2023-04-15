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
<br><br><br>
<table style="border-bottom-width: thick">
    <tr>
        <td>
            <p style="margin: 30px">
            <h2>Subject : <%=subName%>
            </h2>
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
        <th>Attendance</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
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
    <form method="post" id="deleteAttendance">
        <input type="hidden" name="id" value="<%= student.getId()%>">
        <input type="hidden" name="attendanceDate" value="<%=attendanceDate%>">
        <input type="hidden" name="name" value="<%=student.getName()%>">
        <tr>
            <td><%= student.getId()%>
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
            <td>
                <input class="editbutton" type="submit" value="Edit" formaction="editAttendance.jsp">
            </td>
            <td>
                <input class="deletebutton" type="submit" value="Delete" formaction="deleteAttendance.jsp">
            </td>
        </tr>
    </form>
    <% } %>
    <tr>
        <td colspan="5" style="text-align: center">
            <form method="post">
                <input type="hidden" name="attendanceDate" value="<%=attendanceDate%>">
                <input class="deletebutton" type="submit" value="Delete Record" formaction="deleteAttendanceByDate.jsp">
            </form>
        </td>
    </tr>
    </tbody>
</table>
<%
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</body>
</html>
