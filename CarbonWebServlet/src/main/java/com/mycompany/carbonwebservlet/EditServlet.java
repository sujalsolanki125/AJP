package com.mycompany.carbonwebservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM carbon_data WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                // HTML + CSS
                out.println("<html><head><title>Edit Data</title>");

                out.println("<style>");
                out.println("body { font-family: Arial; background-color: #f4f7f9; margin:0; padding:0; }");
                out.println(".container { width: 400px; margin: 50px auto; background: white; padding: 25px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }");
                out.println("h2 { text-align: center; color: #2c3e50; }");
                out.println("label { font-weight: bold; }");
                out.println("input { width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; }");
                out.println("button { width: 100%; padding: 10px; background-color: #2980b9; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; }");
                out.println("button:hover { background-color: #1f6391; }");
                out.println("a { display:block; text-align:center; margin-top:15px; text-decoration:none; color:#27ae60; font-weight:bold; }");
                out.println("</style>");

                out.println("</head><body>");
                out.println("<div class='container'>");
                out.println("<h2>Edit Data</h2>");

                // FORM
                out.println("<form action='update' method='post'>");

                out.println("<input type='hidden' name='id' value='" + id + "'>");

                out.println("<label>Electricity (kWh):</label>");
                out.println("<input type='text' name='electricity' value='" + rs.getDouble("electricity") + "'>");

                out.println("<label>Distance (km):</label>");
                out.println("<input type='text' name='distance' value='" + rs.getDouble("distance") + "'>");

                out.println("<label>LPG (kg):</label>");
                out.println("<input type='text' name='lpg' value='" + rs.getDouble("lpg") + "'>");

                out.println("<label>Water (litres):</label>");
                out.println("<input type='text' name='water' value='" + rs.getDouble("water") + "'>");

                out.println("<label>Waste (kg):</label>");
                out.println("<input type='text' name='waste' value='" + rs.getDouble("waste") + "'>");

                out.println("<button type='submit'>Update</button>");
                out.println("</form>");

                // BACK LINK
                out.println("<a href='view'>← Back to Data</a>");

                out.println("</div>");
                out.println("</body></html>");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}