<%@ page import="java.sql.*,com.mycompany.carbonjspapp.DBConnection" %>

<%
int id = Integer.parseInt(request.getParameter("id"));

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement("SELECT * FROM carbon_data WHERE id=?");

ps.setInt(1,id);

ResultSet rs = ps.executeQuery();

if(rs.next()){
%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Data</title>
</head>

<body style="margin:0; padding:0; font-family:Arial, sans-serif; background:linear-gradient(to right, #eef7ee, #dff6e3);">

<div style="width:420px; margin:60px auto; background:#ffffff; padding:30px; border-radius:15px; box-shadow:0 8px 20px rgba(0,0,0,0.12);">

    <h2 style="text-align:center; color:#2e7d32; margin-bottom:25px;">
        Edit Carbon Data
    </h2>

    <form action="update.jsp" method="post">

        <input type="hidden" name="id" value="<%= rs.getInt("id") %>">

        <label style="font-weight:bold; color:#333;">Electricity</label><br>
        <input name="electricity"
        value="<%= rs.getDouble("electricity") %>"
        style="width:100%; padding:10px; margin-top:5px; margin-bottom:15px; border:1px solid #ccc; border-radius:8px;"><br>

        <label style="font-weight:bold; color:#333;">Distance</label><br>
        <input name="distance"
        value="<%= rs.getDouble("distance") %>"
        style="width:100%; padding:10px; margin-top:5px; margin-bottom:15px; border:1px solid #ccc; border-radius:8px;"><br>

        <label style="font-weight:bold; color:#333;">LPG</label><br>
        <input name="lpg"
        value="<%= rs.getDouble("lpg") %>"
        style="width:100%; padding:10px; margin-top:5px; margin-bottom:15px; border:1px solid #ccc; border-radius:8px;"><br>

        <label style="font-weight:bold; color:#333;">Water</label><br>
        <input name="water"
        value="<%= rs.getDouble("water") %>"
        style="width:100%; padding:10px; margin-top:5px; margin-bottom:15px; border:1px solid #ccc; border-radius:8px;"><br>

        <label style="font-weight:bold; color:#333;">Waste</label><br>
        <input name="waste"
        value="<%= rs.getDouble("waste") %>"
        style="width:100%; padding:10px; margin-top:5px; margin-bottom:20px; border:1px solid #ccc; border-radius:8px;"><br>

        <button type="submit"
        style="width:100%; padding:12px; background:#43a047; color:white; border:none; border-radius:8px; font-size:16px; cursor:pointer;">
            Update
        </button>

    </form>

    <div style="text-align:center; margin-top:20px;">
        <a href="view.jsp"
        style="text-decoration:none; color:#1b5e20; font-weight:bold;">
            Back
        </a>
    </div>

</div>

</body>
</html>

<%
}
%>