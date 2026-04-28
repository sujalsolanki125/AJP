<%@ page import="java.sql.*,com.mycompany.carbonjspapp.DBConnection" %>

<!DOCTYPE html>
<html>
<head>
<title>Carbon Data</title>
</head>

<body style="margin:0; padding:0; font-family:Arial, sans-serif; background:linear-gradient(to right, #eef7ee, #dff6e3);">

<div style="width:80%; margin:50px auto; background:#ffffff; padding:30px; border-radius:15px; box-shadow:0 8px 20px rgba(0,0,0,0.12);">

    <h2 style="text-align:center; color:#2e7d32; margin-bottom:25px;">
        Carbon Data
    </h2>

    <table style="width:100%; border-collapse:collapse; text-align:center;">

        <tr style="background:#43a047; color:white;">
            <th style="padding:12px; border:1px solid #ddd;">ID</th>
            <th style="padding:12px; border:1px solid #ddd;">Total</th>
            <th style="padding:12px; border:1px solid #ddd;">Action</th>
        </tr>

<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM carbon_data");

while(rs.next()){
%>

        <tr style="background:#f9f9f9;">
            <td style="padding:10px; border:1px solid #ddd;">
                <%= rs.getInt("id") %>
            </td>

            <td style="padding:10px; border:1px solid #ddd;">
                <%= rs.getDouble("total") %>
            </td>

            <td style="padding:10px; border:1px solid #ddd;">

                <a href="edit.jsp?id=<%= rs.getInt("id") %>"
                style="text-decoration:none; background:#1976d2; color:white; padding:6px 12px; border-radius:6px; margin-right:8px;">
                    Edit
                </a>

                <a href="delete.jsp?id=<%= rs.getInt("id") %>"
                style="text-decoration:none; background:#d32f2f; color:white; padding:6px 12px; border-radius:6px;">
                    Delete
                </a>

            </td>
        </tr>

<%
}
%>

    </table>

    <div style="text-align:center; margin-top:25px;">
        <a href="index.jsp"
        style="text-decoration:none; background:#2e7d32; color:white; padding:10px 18px; border-radius:8px;">
            Back
        </a>
    </div>

</div>

</body>
</html>