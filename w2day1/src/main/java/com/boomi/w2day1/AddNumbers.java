/*
package com.boomi.w2day1;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AddNumbers extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int sum = num1 + num2;
        PrintWriter writer = response.getWriter();
        writer.println("Sum = "+sum);
        System.out.println("Sum = "+(num1+num2));

        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("servletUrl");
        //response.sendRedirect("servletUrl");
        // HttpSession session = request.getSession();
        // session.setAttribute("key",value);
    }
}
*/
