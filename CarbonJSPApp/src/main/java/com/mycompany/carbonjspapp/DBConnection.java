package com.mycompany.carbonjspapp;

import java.sql.*;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://127.0.0.1:3307/carbon_db";
        String user = "root";
        String pass = "@Sujal5412";

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, user, pass);
    }
}