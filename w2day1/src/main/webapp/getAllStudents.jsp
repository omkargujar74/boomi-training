<%@ page import="com.boomi.w2day1.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boomi.w2day1.StudentList" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 09/03/23
  Time: 12:07 am
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
        text-align: left;
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
    }</style>

<body>
<%
    List<Student> students = StudentList.getStudentList();
    if (students.isEmpty()) {
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Student List is Empty</h1>");
    } else {
%>
<table class="center" style="width:100%">
    <caption><h2>Student Info</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    </thead>

    <tbody>
    <%
        for (Student student:students) {
    %>
    <tr>
        <td><%= student.getId()%>
        </td
        <td></td>
        <td><%= student.getName()%>
        </td>
        <td><%= student.getAge()%>
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

