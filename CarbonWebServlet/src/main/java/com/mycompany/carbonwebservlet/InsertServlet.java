package com.mycompany.carbonwebservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double e = Double.parseDouble(request.getParameter("electricity"));
        double d = Double.parseDouble(request.getParameter("distance"));
        double l = Double.parseDouble(request.getParameter("lpg"));
        double w = Double.parseDouble(request.getParameter("water"));
        double ws = Double.parseDouble(request.getParameter("waste"));

        double total =
                (e * 0.82)
              + (d * 0.21)
              + (l * 2.98)
              + (w * 0.0003)
              + (ws * 1.9);

        try (Connection con = DBConnection.getConnection()) {

            String sql =
            "INSERT INTO carbon_data(electricity,distance,lpg,water,waste,total) VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, e);
            ps.setDouble(2, d);
            ps.setDouble(3, l);
            ps.setDouble(4, w);
            ps.setDouble(5, ws);
            ps.setDouble(6, total);

            ps.executeUpdate();

            response.sendRedirect("view");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}