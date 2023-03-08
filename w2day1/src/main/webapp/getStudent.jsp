<%@ page import="com.boomi.w2day1.Student" %>
<%@ page import="com.boomi.w2day1.StudentList" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 08/03/23
  Time: 4:45 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentInfo</title>
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
    Student student = StudentList.getStudentById(Integer.parseInt(request.getParameter("id")));
    if (student == null) {
        PrintWriter writer = response.getWriter();
        writer.println("<h1>No Student with this ID</h1>");
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
    <tr>
        <td><%= student.getId()%>
        </td
        <td></td>
        <td><%= student.getName()%>
        </td>
        <td><%= student.getAge()%>
        </td>
    </tr>
    </tbody>
</table>
<%
    }
%>
</body>
</html>
