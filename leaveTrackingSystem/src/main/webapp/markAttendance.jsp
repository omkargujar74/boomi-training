<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.boomi.leavetrackingsystem.service.AttendanceService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.Attendance" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 24/03/23
  Time: 3:31 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mark_attendance</title>
    <link rel="stylesheet" href="./style/studentTable.css">
    <link rel="stylesheet" href="./style/homeButton.css">
    <link rel="stylesheet" href="./style/attendanceButton.css">

</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        String subName = (String) session.getAttribute("subName");
        String attendanceDate = (String) session.getAttribute("attendanceDate");
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
        <input type="submit" formaction="seeAttendance.jsp"
               value="See Attendance" class="markAttendanceButton">
    </form>
</div>
<br><br><br>
<table style="border-bottom-width: thick">
    <tr>
    <td>
        <p style="margin: 30px">
        <h3>Subject : <%=subName%>
        </h3>
        <h4>Date : <%=attendanceDate%>
        </h4>
        Note* by default attendance marked as absent
        </p>
    </td>
    </tr>
</table>
<table class="center" style="width:100%">
    <caption style="text-align: center"><h2 style="font-weight: bold;color: #09223b">Mark Attendance</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Attendance</th>
    </tr>
    <form method="post" action="markAttendanceProcess.jsp" id="markAttendance">
        <input type="hidden" name="size" id="size" value="<%=attendanceByDate.size()%>">
        <input type="hidden" name="attendanceDate" value="<%=attendanceDate%>">
        <tbody>
        <%
            int index = 0;
            for (Attendance student : attendanceByDate) {
        %>
        <tr>
            <td><%= student.getId()%>
                <input type="hidden" name="id<%=index%>" value="<%= student.getId()%>">
                <input type="hidden" name="name<%=index%>" value="<%=student.getName()%>">
            </td>
            <td><%= student.getName()%>
            </td>
            <td>
                <input type="radio" id="present<%=index%>" name="attendance<%=index%>"
                       value="true"
                <%--                       onchange="submit()"--%>
                       style="width:150px;height: 20px"
                >
                <label for="present<%=index%>">Present</label>
                <input type="radio" id="absent<%=index%>" name="attendance<%=index%>"
                       value="false"
                <%--                       onchange="submit()"--%>
                       style="width:150px;height: 20px"
                >
                <label for="absent<%=index%>">Absent</label><br>
            </td>
        </tr>
        <%
                index++;
            } %>
        <tr>
            <td colspan="3">
                <input type="submit" name="submit" id="submit" class="button-18">
            </td>
        </tr>
        </tbody>
    </form>
    </thead>
</table>
</body>
<%
    } else {
        response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
    }
%>
</html>
<%--<script>--%>
<%--    function submit()--%>
<%--    {--%>
<%--        document.getElementById("markAttendance").submit();--%>
<%--    }--%>
<%--</script>--%>
