package com.mycompany.carbonwebservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Carbon Data</title>");

        // CSS Styling
        out.println("<style>");
        out.println("body { font-family: Arial; background-color: #f4f7f9; margin:0; padding:0; }");
        out.println(".container { width: 60%; margin: 50px auto; background: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }");
        out.println("h2 { text-align: center; color: #2c3e50; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { padding: 10px; text-align: center; border-bottom: 1px solid #ddd; }");
        out.println("th { background-color: #27ae60; color: white; }");
        out.println("tr:hover { background-color: #f1f1f1; }");
        out.println("a { text-decoration:none; color:#2980b9; font-weight:bold; }");
        out.println(".back { display:block; text-align:center; margin-top:15px; }");
        out.println("</style>");

        out.println("</head><body>");
        out.println("<div class='container'>");
        out.println("<h2>Carbon Data</h2>");

        try (Connection con = DBConnection.getConnection()) {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM carbon_data");

            // Table Start
            out.println("<table>");
            out.println("<tr><th>ID</th><th>Total CO2</th><th>Actions</th></tr>");

            while (rs.next()) {

                int id = rs.getInt("id");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + rs.getDouble("total") + "</td>");

                // Action Buttons
                out.println("<td>");
                out.println("<a href='edit?id=" + id + "'>✏️ Edit</a> | ");
                out.println("<a href='delete?id=" + id + "' onclick=\"return confirm('Delete?');\">❌ Delete</a>");
                out.println("</td>");

                out.println("</tr>");
            }

            out.println("</table>");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Back Link
        out.println("<a class='back' href='index.jsp'>← Back to Home</a>");

        out.println("</div>");
        out.println("</body></html>");
    }
}