/*
 * Author Name: Sarthak Agarwal
 * Date: 07/09/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MobileStore extends Mobile {
    private List<Mobile> mobileList;
    public List<Mobile> readMobileData(String fileName) {
        // Read the data from the file and store it in the List mobileList
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String brandName = data[0].trim();
                double cost = Double.parseDouble(data[1]);
                double screenSize = Double.parseDouble(data[2]);
                int batteryLife = Integer.parseInt(data[3]);
                int megaPixels = Integer.parseInt(data[4]);
                Mobile tempMobile = new Mobile(brandName, cost, screenSize, batteryLife, megaPixels);
                mobileList.add(tempMobile);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        return mobileList;
    }

    public List<Mobile> findPhoneByBrand(String brandName) {
        ListIterator<Mobile> listIterator = mobileList.listIterator();
        List<Mobile> phoneByBrand = new ArrayList<>();
        while (listIterator.hasNext()) {
            Mobile currentMobile = listIterator.next();
            if (currentMobile.getBrandName().equals(brandName)) {
                phoneByBrand.add(currentMobile);
            }
        }
        return phoneByBrand;
    }

    public List<Mobile> findPhoneCostMoreThan$500() {
        ListIterator<Mobile> listIterator = mobileList.listIterator();
        List<Mobile> phoneCostMoreThan$500 = new ArrayList<>();
        while (listIterator.hasNext()) {
            Mobile currentMobile = listIterator.next();
            if (currentMobile.getCost() > 500.0) {
                phoneCostMoreThan$500.add(currentMobile);
            }
        }
        return phoneCostMoreThan$500;
    }
}
