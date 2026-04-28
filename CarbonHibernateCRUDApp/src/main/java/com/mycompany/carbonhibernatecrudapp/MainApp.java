package com.mycompany.carbonhibernatecrudapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CARBON CRUD MENU =====");
            System.out.println("1. Insert Record");
            System.out.println("2. View Records");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    Transaction tx1 = session.beginTransaction();

                    Carbon c = new Carbon();

                    System.out.print("Enter Electricity: ");
                    c.setElectricity(sc.nextDouble());

                    System.out.print("Enter Distance: ");
                    c.setDistance(sc.nextDouble());

                    double total =
                            (c.getElectricity() * 0.82)
                          + (c.getDistance() * 0.21);

                    c.setTotal(total);

                    session.save(c);

                    tx1.commit();

                    System.out.println("Record Inserted Successfully.");
                    break;

                case 2:

                    Query q = session.createQuery("from Carbon");

                    List<Carbon> list = q.list();

                    System.out.println("\nID\tElectricity\tDistance\tTotal");

                    for (Carbon x : list) {

                        System.out.println(
                                x.getId() + "\t" +
                                x.getElectricity() + "\t\t" +
                                x.getDistance() + "\t\t" +
                                x.getTotal()
                        );
                    }

                    break;

                case 3:

                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter New Total: ");
                    double newTotal = sc.nextDouble();

                    Transaction tx2 = session.beginTransaction();

                    Query q2 = session.createQuery(
                            "update Carbon set total=:t where id=:i");

                    q2.setParameter("t", newTotal);
                    q2.setParameter("i", uid);

                    q2.executeUpdate();

                    tx2.commit();

                    System.out.println("Record Updated Successfully.");
                    break;

                case 4:

                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();

                    Transaction tx3 = session.beginTransaction();

                    Query q3 = session.createQuery(
                            "delete from Carbon where id=:i");

                    q3.setParameter("i", did);

                    q3.executeUpdate();

                    tx3.commit();

                    System.out.println("Record Deleted Successfully.");
                    break;

                case 5:

                    session.close();
                    factory.close();
                    sc.close();

                    System.out.println("Application Closed.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}