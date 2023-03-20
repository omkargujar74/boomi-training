<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.boomi.w3day4.service.StudentService" %><%--
  Created by IntelliJ IDEA.
  User: omkargujar
  Date: 09/03/23
  Time: 6:45 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addStudent</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    PrintWriter writer = response.getWriter();

    StudentService studentService = new StudentService();
    boolean status = studentService.addStudent(id, name, age);
    if (status) {
        System.out.println("Student added successfully");
        response.sendRedirect("http://localhost:8080/w3day4_war_exploded/getAllStudents.jsp");
    } else {
        System.out.println("Failed to add Student added");
        writer.print("<h2 style=\"color:red;\">Failed to add Student</h2>");
    }
%>
<h2><a href="index.jsp" style="color: olivedrab"><h3>Home</h3></a></h2>
</body>
</html>
