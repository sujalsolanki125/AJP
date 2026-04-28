package com.mycompany.carbonhibernatecrudapp;

public class Carbon {

    private int id;
    private double electricity;
    private double distance;
    private double total;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getElectricity() { return electricity; }
    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }

    public double getDistance() { return distance; }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTotal() { return total; }
    public void setTotal(double total) {
        this.total = total;
    }
}