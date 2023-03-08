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
<form action="getStudent.jsp" >
    Enter Student Id (1-10)<input type="text" name="id"><br><br>
    <input type="submit"><br><br>
    <a href="getAllStudents.jsp">Get All Students</a>
</form>
</body>
</html>