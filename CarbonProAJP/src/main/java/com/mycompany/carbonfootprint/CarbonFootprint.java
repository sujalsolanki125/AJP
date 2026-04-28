package com.mycompany.carbonfootprint;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarbonFootprint {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3307/carbon_db"; // Database details
        String username = "root"; // MySQL credentials
        String password = "@Sujal5412";

        try {
            // 1. Load Driver2
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connection
            try (Connection con = DriverManager.getConnection(url, username, password)) {

                System.out.println("Connection Established Successfully");
                Statement st = con.createStatement();

                /* ---------- METADATA : CHECK TABLE ---------- */
                DatabaseMetaData dbMeta = con.getMetaData();
                ResultSet tables = dbMeta.getTables(null, null, "carbon_data", null);

                if (!tables.next()) {
                    String createTableSQL
                            = "CREATE TABLE carbon_data ("
                            + "id INT AUTO_INCREMENT PRIMARY KEY,"
                            + "electricity DOUBLE,"
                            + "distance DOUBLE,"
                            + "lpg DOUBLE,"
                            + "water DOUBLE,"
                            + "waste DOUBLE,"
                            + "total DOUBLE"
                            + ")";
                    st.executeUpdate(createTableSQL);
                    System.out.println("Table carbon_data created successfully");
                }

                Scanner sc = new Scanner(System.in);
                int choice;

                do {
                    System.out.println("\n---- MENU ----");
                    System.out.println("1. Insert Data");
                    System.out.println("2. View Data");
                    System.out.println("3. Update Data");
                    System.out.println("4. Delete Data");
                    System.out.println("5. Exit");
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();

                    switch (choice) {

                        case 1 -> {
                            // INSERT
                            System.out.print("Electricity: ");
                            double electricity = sc.nextDouble();
                            System.out.print("Distance: ");
                            double distance = sc.nextDouble();
                            System.out.print("LPG: ");
                            double lpg = sc.nextDouble();
                            System.out.print("Water: ");
                            double water = sc.nextDouble();
                            System.out.print("Waste: ");
                            double waste = sc.nextDouble();

                            double total
                                    = (electricity * 0.82)
                                    + (distance * 0.21)
                                    + (lpg * 2.98)
                                    + (water * 0.0003)
                                    + (waste * 1.9);

                            String insertSQL
                                    = "INSERT INTO carbon_data (electricity,distance,lpg,water,waste,total) VALUES (?,?,?,?,?,?)";
                            PreparedStatement psInsert = con.prepareStatement(insertSQL);
                            psInsert.setDouble(1, electricity);
                            psInsert.setDouble(2, distance);
                            psInsert.setDouble(3, lpg);
                            psInsert.setDouble(4, water);
                            psInsert.setDouble(5, waste);
                            psInsert.setDouble(6, total);
                            psInsert.executeUpdate();

                            System.out.println("Data Inserted Successfully");
                        }

                        case 2 -> {
                            // SELECT
                            ResultSet rs = st.executeQuery("SELECT * FROM carbon_data");
                            while (rs.next()) {
                                System.out.println(
                                        "ID: " + rs.getInt("id")
                                        + ", Total CO₂: " + rs.getDouble("total")
                                );
                            }
                        }

                        case 3 -> {
                            // UPDATE
                            System.out.print("Enter ID to update: ");
                            int uid = sc.nextInt();

                            System.out.print("New Electricity value: ");
                            double electricity = sc.nextDouble();

                            System.out.print("New Distance value: ");
                            double distance = sc.nextDouble();

                            System.out.print("New LPG value: ");
                            double lpg = sc.nextDouble();

                            System.out.print("New Water value: ");
                            double water = sc.nextDouble();

                            System.out.print("New Waste value: ");
                            double waste = sc.nextDouble();

                            // Recalculate total carbon footprint
                            double total
                                    = (electricity * 0.82)
                                    + (distance * 0.21)
                                    + (lpg * 2.98)
                                    + (water * 0.0003)
                                    + (waste * 1.9);

                            // UPDATE query for all columns
                            String updateSQL
                                    = "UPDATE carbon_data SET electricity=?, distance=?, lpg=?, water=?, waste=?, total=? WHERE id=?";

                            PreparedStatement psUpdate = con.prepareStatement(updateSQL);
                            psUpdate.setDouble(1, electricity);
                            psUpdate.setDouble(2, distance);
                            psUpdate.setDouble(3, lpg);
                            psUpdate.setDouble(4, water);
                            psUpdate.setDouble(5, waste);
                            psUpdate.setDouble(6, total);
                            psUpdate.setInt(7, uid);
                                    

                            int rows = psUpdate.executeUpdate();

                            if (rows > 0) {
                                System.out.println("Record Updated Successfully");
                            } else {
                                System.out.println("No Record Found with given ID");
                            }

                        }

                        case 4 -> {
                            // DELETE
                            System.out.print("Enter ID to delete: ");
                            int did = sc.nextInt();

                            String deleteSQL
                                    = "DELETE FROM carbon_data WHERE id=?";
                            PreparedStatement psDelete = con.prepareStatement(deleteSQL);
                            psDelete.setInt(1, did);
                            psDelete.executeUpdate();

                            System.out.println("Record Deleted");
                        }

                        case 5 ->
                            System.out.println("Exiting Program");

                        default ->
                            System.out.println("Invalid Choice");
                    }

                } while (choice != 5);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarbonFootprint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}