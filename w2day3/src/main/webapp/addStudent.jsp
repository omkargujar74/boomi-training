<%@ page import="com.boomi.service.StudentService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.SQLException" %><%--
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

    StudentService studentService = null;
    try {
        studentService = new StudentService();
        boolean status = studentService.addStudent(id, name, age);
        if (status) {
            System.out.println("Student added successfully");
            writer.print("<h4 style=\"color:green;\">Student added successfully</h4>");
        } else {
            System.out.println("Failed to add Student added");
            writer.print("<h4 style=\"color:red;\">Failed to add Student added</h4>");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

%>
</body>
</html>
