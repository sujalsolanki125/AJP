package com.mycompany.carbonserverapp;

import java.net.*;
import java.io.*;
import java.sql.*;

public class CarbonServerapp {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3307/carbon_db";
        String user = "root";
        String pass = "@Sujal5412";

        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server Started... Waiting for client");

            Socket socket = server.accept();
            System.out.println("Client Connected");

            BufferedReader in =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);

            String search = in.readLine();

            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM carbon_data WHERE id=?");

            ps.setInt(1, Integer.parseInt(search));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("ID: " + rs.getInt("id")
                        + " Total: " + rs.getDouble("total"));
            } else {
                out.println("No Record Found");
            }

            con.close();
            socket.close();
            server.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}