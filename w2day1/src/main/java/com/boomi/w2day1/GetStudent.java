package com.boomi.w2day1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

public class GetStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = StudentList.getStudentById(Integer.parseInt(request.getParameter("id")));
        PrintWriter writer = response.getWriter();
        writer.println("Id = " + student.getId() + "  Name = " + student.getName() + "  Age = " + student.getAge());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
