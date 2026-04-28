package com.mycompany.carbonhibernateapp;

public class Carbon {

    private int id;
    private double electricity;
    private double distance;
    private double lpg;
    private double water;
    private double waste;
    private double total;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getElectricity() { return electricity; }
    public void setElectricity(double electricity) { this.electricity = electricity; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public double getLpg() { return lpg; }
    public void setLpg(double lpg) { this.lpg = lpg; }

    public double getWater() { return water; }
    public void setWater(double water) { this.water = water; }

    public double getWaste() { return waste; }
    public void setWaste(double waste) { this.waste = waste; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}