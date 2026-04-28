package tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CrudTag extends TagSupport {
    
    private String action;
    private String uid;
    private String elec;
    private String dist;
    private String lpg;
    private String water;
    private String waste;

    // Setters for the JSP to pass data
    public void setAction(String action) { this.action = action; }
    public void setUid(String uid) { this.uid = uid; }
    public void setElec(String elec) { this.elec = elec; }
    public void setDist(String dist) { this.dist = dist; }
    public void setLpg(String lpg) { this.lpg = lpg; }
    public void setWater(String water) { this.water = water; }
    public void setWaste(String waste) { this.waste = waste; }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        
        // Custom Database connection details
        String url = "jdbc:mysql://127.0.0.1:3307/carbon_db";
        String dbUser = "root";
        String dbPass = "@Sujal5412";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPass)) {

                double e = 0, d = 0, l = 0, w = 0, ws = 0, total = 0;
                
                // FIX: Check if the string is NOT empty before trying to convert it to a double
                if (elec != null && !elec.isEmpty() && dist != null && !dist.isEmpty()) {
                    e = Double.parseDouble(elec);
                    d = Double.parseDouble(dist);
                    l = Double.parseDouble(lpg);
                    w = Double.parseDouble(water);
                    ws = Double.parseDouble(waste);
                    // Perform the Experiment 5 calculation
                    total = (e * 0.82) + (d * 0.21) + (l * 2.98) + (w * 0.0003) + (ws * 1.9);
                }

                // 1. ADD RECORD
                if ("add".equalsIgnoreCase(action) && elec != null && !elec.isEmpty()) {
                    PreparedStatement ps = con.prepareStatement("INSERT INTO carbon_data (ELECTRICITY, DISTANCE, LPG, WATER, WASTE, TOTAL) VALUES (?, ?, ?, ?, ?, ?)");
                    ps.setDouble(1, e); ps.setDouble(2, d); ps.setDouble(3, l);
                    ps.setDouble(4, w); ps.setDouble(5, ws); ps.setDouble(6, total);
                    if(ps.executeUpdate() > 0) out.print("<p style='color:green; font-weight:bold;'>Carbon Record Added! Total: " + total + "</p>");
                }
                
                // 2. UPDATE RECORD
                else if ("update".equalsIgnoreCase(action) && uid != null && !uid.isEmpty() && elec != null && !elec.isEmpty()) {
                    PreparedStatement ps = con.prepareStatement("UPDATE carbon_data SET ELECTRICITY=?, DISTANCE=?, LPG=?, WATER=?, WASTE=?, TOTAL=? WHERE id=?");
                    ps.setDouble(1, e); ps.setDouble(2, d); ps.setDouble(3, l);
                    ps.setDouble(4, w); ps.setDouble(5, ws); ps.setDouble(6, total);
                    ps.setInt(7, Integer.parseInt(uid));
                    if(ps.executeUpdate() > 0) out.print("<p style='color:blue; font-weight:bold;'>Carbon Record Updated Successfully!</p>");
                }
                
                // 3. DELETE RECORD
                // FIX: Added !uid.isEmpty() check here as well to be safe
                else if ("delete".equalsIgnoreCase(action) && uid != null && !uid.isEmpty()) {
                    PreparedStatement ps = con.prepareStatement("DELETE FROM carbon_data WHERE id=?");
                    ps.setInt(1, Integer.parseInt(uid));
                    if(ps.executeUpdate() > 0) out.print("<p style='color:red; font-weight:bold;'>Record Deleted Successfully!</p>");
                }
                
                // 4. VIEW RECORDS
                else if ("view".equalsIgnoreCase(action)) {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM carbon_data");
                    ResultSet rs = ps.executeQuery();
                    
                    out.print("<table border='1' cellpadding='8' style='border-collapse: collapse; width: 100%; text-align: center;'>");
                    out.print("<tr style='background-color: #e8f5e9;'><th>ID</th><th>Electricity</th><th>Distance</th><th>LPG</th><th>Water</th><th>Waste</th><th>Total Footprint</th></tr>");
                    
                    while (rs.next()) {
                        out.print("<tr>");
                        out.print("<td><b>" + rs.getInt("id") + "</b></td>");
                        out.print("<td>" + rs.getDouble("ELECTRICITY") + "</td>");
                        out.print("<td>" + rs.getDouble("DISTANCE") + "</td>");
                        out.print("<td>" + rs.getDouble("LPG") + "</td>");
                        out.print("<td>" + rs.getDouble("WATER") + "</td>");
                        out.print("<td>" + rs.getDouble("WASTE") + "</td>");
                        out.print("<td style='color:#2e7d32; font-weight:bold;'>" + rs.getDouble("TOTAL") + "</td>");
                        out.print("</tr>");
                    }
                    out.print("</table>");
                }
            }
        } catch (Exception ex) {
            try { out.print("<p style='color:red; font-weight:bold;'>Error: " + ex.getMessage() + "</p>"); } catch (IOException ignored) {}
        }
        
        return SKIP_BODY;
    }
}