package com.mycompany.carbonwebservlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    // Handle direct URL (/login)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("login.jsp");
    }

    // Handle form submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Null safety check
        if (user == null || pass == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Simple hardcoded login
        if (user.equals("admin") && pass.equals("1234")) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("index.jsp");

        } else {

            request.setAttribute("error", "Invalid Username or Password");
            request.getRequestDispatcher("login.jsp")
                   .forward(request, response);
        }
    }
}