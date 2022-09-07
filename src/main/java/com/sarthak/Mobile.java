/*
 * Author Name: Sarthak Agarwal
 * Date: 07/09/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak;

public class Mobile {
    private String brandName;
    private double cost;
    private double screenSize;
    private int batteryLife;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public Mobile(String brandName, double cost, double screenSize, int batteryLife) {
        this.brandName = brandName;
        this.cost = cost;
        this.screenSize = screenSize;
        this.batteryLife = batteryLife;
    }

    public Mobile() {
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "brandName='" + brandName + '\'' +
                ", cost=" + cost +
                ", screenSize=" + screenSize +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
