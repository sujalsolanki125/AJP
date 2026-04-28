<%@ page import="java.sql.*,com.mycompany.carbonjspapp.DBConnection" %>

<%
int id = Integer.parseInt(request.getParameter("id"));

double e = Double.parseDouble(request.getParameter("electricity"));
double d = Double.parseDouble(request.getParameter("distance"));
double l = Double.parseDouble(request.getParameter("lpg"));
double w = Double.parseDouble(request.getParameter("water"));
double ws = Double.parseDouble(request.getParameter("waste"));

double total =
(e * 0.82) +
(d * 0.21) +
(l * 2.98) +
(w * 0.0003) +
(ws * 1.9);

Connection con = DBConnection.getConnection();

PreparedStatement ps = con.prepareStatement(
"UPDATE carbon_data SET electricity=?, distance=?, lpg=?, water=?, waste=?, total=? WHERE id=?"
);

ps.setDouble(1,e);
ps.setDouble(2,d);
ps.setDouble(3,l);
ps.setDouble(4,w);
ps.setDouble(5,ws);
ps.setDouble(6,total);
ps.setInt(7,id);

ps.executeUpdate();

response.sendRedirect("view.jsp");
%>