
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>CheckStudentInfo</title>
</head>
<style>
    .center {
        margin-left: 10px;
        margin-right: 25px;
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

    .addbutton {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }

    .link{
        color: rosybrown;
        text-align: center;
    }

</style>
<body class="center">
<table class="center" style="width:100%">
    <caption><h2>Enter Student details to add</h2></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <form action="addStudent.jsp" method="post">
            <td><input type="text" name="id">
            </td>
            <td><input type="text" name="name">
            </td>
            <td><input type="text" name="age">
            </td>
            <td>
                <input class="addbutton" value="Add" type="submit">
            </td>
        </form>
    </tr>
    </tbody>
</table>
<br>
<a class="link" href="getAllStudents.jsp" ><h3>Get All Students</h3></a>
</form>
<form action="getStudentByID.jsp" >
    Enter Student Id<input type="text" name="id"><br><br>
    <input type="submit"><br><br>
</form>
</body>
</html>