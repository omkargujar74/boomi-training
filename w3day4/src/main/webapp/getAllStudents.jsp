<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.boomi.w3day4.service.StudentService" %>
<%@ page import="com.boomi.w3day4.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 11/03/23
  Time: 11:25 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getAllStudents</title>
</head>
<style>
    .center {
        margin-left: auto;
        margin-right: auto;
    }

    table, td, th {
        border: 1px solid #ddd;
        text-align: center;
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        padding: 15px;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2
    }

    th {
        background-color: #04AA6D;
        color: white;
    }

    .editbutton {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }

    .deletebutton {
        background-color: #f44336;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }
</style>

<body>
<%
    StudentService studentService = new StudentService();
    List<Student> students = studentService.getAllStudents();
    if (students.isEmpty()) {
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Student List is Empty</h1>");
    } else {
%>
<h2><a href="index.jsp" style="color: olivedrab"><h3>Home</h3></a></h2>
<table class="center" style="width:100%">
    <caption><h2>Student Info</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th></th>
        <th></th>
    </tr>
    </thead>

    <tbody>
    <%
        for (Student student : students) {
    %>
    <tr>
        <form action="editStudent.jsp" method="post">
            <td><input type="text" name="id" value="<%= student.getId()%>" readonly>
            </td>
            <td><input type="text" name="name" value="<%= student.getName()%>">
            </td>
            <td><input type="text" name="age" value="<%= student.getAge()%>">
            </td>
            <td>
                <input class="editbutton" value="Make Changes" type="submit">
            </td>
        </form>
        <td>
            <form action="deleteStudent.jsp" method="post">
                <input type="hidden" name="id" value="<%= student.getId()%>">
                <input class="deletebutton" type="submit" value="Delete">
            </form>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<%
    }
%>
</body>
</html>
