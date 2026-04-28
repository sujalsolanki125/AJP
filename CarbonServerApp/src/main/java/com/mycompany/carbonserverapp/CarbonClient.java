/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carbonserverapp;


import java.net.*;
import java.io.*;
import java.util.Scanner;

public class CarbonClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader in =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter ID to Search: ");
            String search = sc.nextLine();

            out.println(search);

            String result = in.readLine();

            System.out.println("Server Response: " + result);

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
