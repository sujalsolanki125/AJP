<%@ page import="java.sql.*,com.mycompany.carbonjspapp.DBConnection" %>

<%
int id = Integer.parseInt(request.getParameter("id"));

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement("DELETE FROM carbon_data WHERE id=?");

ps.setInt(1,id);
ps.executeUpdate();

response.sendRedirect("view.jsp");
%>