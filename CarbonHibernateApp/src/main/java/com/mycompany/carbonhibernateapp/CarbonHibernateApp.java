package com.mycompany.carbonhibernateapp;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class CarbonHibernateApp {

    public static void main(String[] args) {

        SessionFactory factory =
            new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Carbon c = new Carbon();

        c.setElectricity(100);
        c.setDistance(50);
        c.setLpg(10);
        c.setWater(500);
        c.setWaste(2);

        double total =
            (100*0.82)+(50*0.21)+(10*2.98)+(500*0.0003)+(2*1.9);

        c.setTotal(total);

        session.save(c);

        tx.commit();

        System.out.println("Record Saved");

        // HQL Query
        Query q = session.createQuery("from Carbon");

        List<Carbon> list = q.list();

        for(Carbon x : list) {
            System.out.println("ID: " + x.getId() +
                               " Total: " + x.getTotal());
        }

        session.close();
        factory.close();
    }
}