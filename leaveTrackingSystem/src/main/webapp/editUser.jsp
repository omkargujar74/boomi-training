<%@ page import="com.boomi.leavetrackingsystem.service.UserInfoService" %>
<%@ page import="com.boomi.leavetrackingsystem.model.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 26/03/23
  Time: 12:50 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editStudent</title>
    <link rel="stylesheet" href="./style/studentTable.css">
    <link rel="stylesheet" href="./style/homeButton.css">
</head>
<body>
<%
    if (session.getAttribute("isLogin") != null) {
        int id = Integer.parseInt(request.getParameter("id"));
        UserInfoService userInfoService = new UserInfoService();
        UserInfo userById = userInfoService.getUserById(id);
        if (userById != null) {
%>
<button style="float: left;margin-left: 20px"
        class="button-18" role="button"
        onclick="window.location.href='adminHome.jsp'">Home
</button>
<br><br><br>
<table class="center" style="width:100%">
    <caption><h2>Edit User</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>DOB</th>
        <th>Age</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <form action="editUserProcess.jsp" method="post">
            <td><input type="text" name="id" value="<%= userById.getId()%>" readonly>
            </td>
            <td><input type="text" name="firstName" value="<%= userById.getFirstName()%>">
            </td>
            <td><input type="text" name="lastName" value="<%= userById.getLastName()%>">
            </td>
            <td>
                <input type="date" id="dateOfBirth" name="dateOfBirth" value="<%= userById.getDateOfBirth()%>">
            </td>
            <td><input type="text" name="age" value="<%= userById.getAge()%>">
            </td>
            <td>
                <input class="editbutton" value="Make Changes" type="submit">
            </td>
        </form>
        <td>
            <form action="deleteUser.jsp" method="post">
                <input type="hidden" name="id" value="<%= userById.getId()%>">
                <input class="deletebutton" type="submit" value="Delete">
            </form>
        </td>
    </tr>
    </tbody>
</table>
<%
} else { %>
<h2>You entered wrong Id
    <h2>
        <button style="float: left;margin-left: 20px"
                class="button-18" role="button"
                onclick="window.location.href='adminHome.jsp'">Home
        </button>
        <br><br><br>
            <% }
} else {
    response.sendRedirect("http://localhost:8080/leaveTrackingSystem_war_exploded/");
}
%>
</body>
</html>
