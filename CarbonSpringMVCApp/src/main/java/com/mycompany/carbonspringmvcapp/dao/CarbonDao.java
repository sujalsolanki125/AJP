package com.mycompany.carbonspringmvcapp.dao;

import java.sql.*;
import java.util.*;
import com.mycompany.carbonspringmvcapp.model.Carbon;

public class CarbonDao {

    String url = "jdbc:mysql://127.0.0.1:3307/carbon_db";
    String user = "root";
    String pass = "@Sujal5412";

    // Database Connection
    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    // Insert Record
    public int save(Carbon c) {

        int status = 0;

        try (Connection con = getConnection()) {

            double total =
                    (c.getElectricity() * 0.82)
                    + (c.getDistance() * 0.21)
                    + (c.getLpg() * 2.98)
                    + (c.getWater() * 0.0003)
                    + (c.getWaste() * 1.9);

            String sql = "insert into carbon_data "
                    + "(electricity,distance,lpg,water,waste,total) "
                    + "values(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, c.getElectricity());
            ps.setDouble(2, c.getDistance());
            ps.setDouble(3, c.getLpg());
            ps.setDouble(4, c.getWater());
            ps.setDouble(5, c.getWaste());
            ps.setDouble(6, total);

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // View All Records
    public List<Carbon> getAllRecords() {

        List<Carbon> list = new ArrayList<>();

        try (Connection con = getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("select * from carbon_data");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Carbon c = new Carbon();

                c.setId(rs.getInt("id"));
                c.setElectricity(rs.getDouble("electricity"));
                c.setDistance(rs.getDouble("distance"));
                c.setLpg(rs.getDouble("lpg"));
                c.setWater(rs.getDouble("water"));
                c.setWaste(rs.getDouble("waste"));
                c.setTotal(rs.getDouble("total"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Get Record By ID
    public Carbon getById(int id) {

        Carbon c = new Carbon();

        try (Connection con = getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("select * from carbon_data where id=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                c.setId(rs.getInt("id"));
                c.setElectricity(rs.getDouble("electricity"));
                c.setDistance(rs.getDouble("distance"));
                c.setLpg(rs.getDouble("lpg"));
                c.setWater(rs.getDouble("water"));
                c.setWaste(rs.getDouble("waste"));
                c.setTotal(rs.getDouble("total"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    // Update Record
    public int update(Carbon c) {

        int status = 0;

        try (Connection con = getConnection()) {

            double total =
                    (c.getElectricity() * 0.82)
                    + (c.getDistance() * 0.21)
                    + (c.getLpg() * 2.98)
                    + (c.getWater() * 0.0003)
                    + (c.getWaste() * 1.9);

            String sql = "update carbon_data set "
                    + "electricity=?,distance=?,lpg=?,water=?,waste=?,total=? "
                    + "where id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, c.getElectricity());
            ps.setDouble(2, c.getDistance());
            ps.setDouble(3, c.getLpg());
            ps.setDouble(4, c.getWater());
            ps.setDouble(5, c.getWaste());
            ps.setDouble(6, total);
            ps.setInt(7, c.getId());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Delete Record
    public int delete(int id) {

        int status = 0;

        try (Connection con = getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("delete from carbon_data where id=?");

            ps.setInt(1, id);

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}