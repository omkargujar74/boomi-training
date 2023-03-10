
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>CheckStudentInfo</title>
</head>
<style>
    .center {
        margin-left: 10px;
        margin-right: auto;
    }
</style>
<body class="center">
<form action="addStudent.jsp" method="post">
    <h3>Enter student details to add</h3>
    Enter Student's Id <input type="text" name="id"><br><br>
    Enter Student's Name <input type="text" name="name"><br><br>
    Enter Student's Age <input type="text" name="age"><br><br>
    <input type="submit"><br><br>
<%--    <a href="getAllStudents.jsp">Get All Students</a>--%>
</form>
</body>
</html>