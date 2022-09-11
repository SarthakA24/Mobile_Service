/*
 * Author Name: Sarthak Agarwal
 * Date: 07/09/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak;

import java.util.Objects;

public class Mobile {
    private String brandName;
    private String modelNumber;
    private double cost;
    private double screenSize;
    private int batteryLife;
    private int megaPixels;

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

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Mobile(String brandName, double cost, double screenSize, int batteryLife, int megaPixels) {
        this.brandName = brandName;
        this.cost = cost;
        this.screenSize = screenSize;
        this.batteryLife = batteryLife;
        this.megaPixels = megaPixels;
    }

    public Mobile() {
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "brandName='" + brandName + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", cost=" + cost +
                ", screenSize=" + screenSize +
                ", batteryLife=" + batteryLife +
                ", megaPixels=" + megaPixels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mobile)) return false;
        Mobile mobile = (Mobile) o;
        return Double.compare(mobile.getCost(), getCost()) == 0 && Double.compare(mobile.getScreenSize(), getScreenSize()) == 0 && getBatteryLife() == mobile.getBatteryLife() && getMegaPixels() == mobile.getMegaPixels() && Objects.equals(getBrandName(), mobile.getBrandName()) && Objects.equals(getModelNumber(), mobile.getModelNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrandName(), getModelNumber(), getCost(), getScreenSize(), getBatteryLife(), getMegaPixels());
    }

    public int getMegaPixels() {
        return megaPixels;
    }

    public void setMegaPixels(int megaPixels) {
        this.megaPixels = megaPixels;
    }

    public void displayDetails() {
        System.out.println("----------------------------");
        System.out.println("Mobile Brand Name - " + this.brandName);
        System.out.println("Model Number = " + this.modelNumber);
        System.out.println("Mobile's Cost - Rs. " + this.cost);
        System.out.println("Mobile's Screen Size - " + this.screenSize + " inches");
        System.out.println("Mobile's Battery Life - " + this.batteryLife + " mAh");
        System.out.println("Camera Megapixels - " + this.megaPixels);
        System.out.println("----------------------------");
    }
}
