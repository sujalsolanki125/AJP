package com.mycompany.carbonjsfapp;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CarbonBean implements Serializable {

    private int id;

    private Double electricity;
    private Double distance;
    private Double lpg;
    private Double water;
    private Double waste;
    private Double total;

    private String statusMessage;

    // DATABASE CONNECTION
    public Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3307/carbon_db",
                "root",
                "@Sujal5412"
        );
    }

    // SAVE NEW RECORD
    public String save() {

        try {

            total = calculateTotal();

            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into carbon_data(electricity,distance,lpg,water,waste,total) values(?,?,?,?,?,?)"
            );

            ps.setDouble(1, electricity);
            ps.setDouble(2, distance);
            ps.setDouble(3, lpg);
            ps.setDouble(4, water);
            ps.setDouble(5, waste);
            ps.setDouble(6, total);

            ps.executeUpdate();

            con.close();

            statusMessage = "Saved Successfully";

            clear();

        } catch (Exception e) {

            statusMessage = "Error : " + e.getMessage();
            e.printStackTrace();
        }

        return "/index.xhtml?faces-redirect=true";
    }

    // VIEW ALL RECORDS
    public List<CarbonBean> getAllRecords() {

        List<CarbonBean> list = new ArrayList<>();

        try {

            Connection con = getConnection();

            PreparedStatement ps =
                    con.prepareStatement("select * from carbon_data order by id");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                CarbonBean c = new CarbonBean();

                c.setId(rs.getInt("id"));
                c.setElectricity(rs.getDouble("electricity"));
                c.setDistance(rs.getDouble("distance"));
                c.setLpg(rs.getDouble("lpg"));
                c.setWater(rs.getDouble("water"));
                c.setWaste(rs.getDouble("waste"));
                c.setTotal(rs.getDouble("total"));

                list.add(c);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // DELETE
    public String delete(int id) {

        try {

            Connection con = getConnection();

            PreparedStatement ps =
                    con.prepareStatement("delete from carbon_data where id=?");

            ps.setInt(1, id);

            ps.executeUpdate();

            con.close();

            statusMessage = "Deleted Successfully";

        } catch (Exception e) {

            statusMessage = "Error : " + e.getMessage();
            e.printStackTrace();
        }

        return "/index.xhtml?faces-redirect=true";
    }

    // OPEN EDIT PAGE
    public String edit(int id) {

        try {

            this.id = id;

            Connection con = getConnection();

            PreparedStatement ps =
                    con.prepareStatement("select * from carbon_data where id=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                electricity = rs.getDouble("electricity");
                distance = rs.getDouble("distance");
                lpg = rs.getDouble("lpg");
                water = rs.getDouble("water");
                waste = rs.getDouble("waste");
                total = rs.getDouble("total");
            }

            con.close();

        } catch (Exception e) {

            statusMessage = "Error : " + e.getMessage();
            e.printStackTrace();
        }

        return "/edit.xhtml?faces-redirect=true";
    }

    // UPDATE RECORD
    // UPDATE RECORD
    public String update() {
        try {
            // SAFETY CHECK: If the ID was lost, stop the update and show an error
            if (this.id == 0) {
                statusMessage = "Error: Record ID was lost. Please try editing again.";
                return "/index.xhtml?faces-redirect=true";
            }

            total = calculateTotal();
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update carbon_data set electricity=?, distance=?, lpg=?, water=?, waste=?, total=? where id=?"
            );

            ps.setDouble(1, electricity);
            ps.setDouble(2, distance);
            ps.setDouble(3, lpg);
            ps.setDouble(4, water);
            ps.setDouble(5, waste);
            ps.setDouble(6, total);
            
            // Uses the ID securely stored in the Session Scope
            ps.setInt(7, this.id);

            int rows = ps.executeUpdate();
            System.out.println("Updated Rows = " + rows); // You can check this in your Tomcat Output log
            
            con.close();

            // If rows == 0, the ID didn't match anything in the database
            if (rows > 0) {
                statusMessage = "Updated Successfully";
            } else {
                statusMessage = "Error: Could not find record with ID " + this.id + " in the database.";
            }

            clear();

        } catch (Exception e) {
            statusMessage = "Error : " + e.getMessage();
            e.printStackTrace();
        }

        return "/index.xhtml?faces-redirect=true";
    }

    // TOTAL FORMULA
    public Double calculateTotal() {

        return (electricity * 0.82)
                + (distance * 0.21)
                + (lpg * 2.98)
                + (water * 0.0003)
                + (waste * 1.9);
    }

    // CLEAR FORM
    public void clear() {

        id = 0;

        electricity = null;
        distance = null;
        lpg = null;
        water = null;
        waste = null;
        total = null;
    }

    // GETTERS SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getElectricity() {
        return electricity;
    }

    public void setElectricity(Double electricity) {
        this.electricity = electricity;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getLpg() {
        return lpg;
    }

    public void setLpg(Double lpg) {
        this.lpg = lpg;
    }

    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    public Double getWaste() {
        return waste;
    }

    public void setWaste(Double waste) {
        this.waste = waste;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}