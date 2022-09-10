/*
 * Author Name: Sarthak Agarwal
 * Date: 07/09/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak;

import java.io.*;
import java.util.*;

public class MobileStore {
    private final List<Mobile> mobileList;
    private final String fileName = "src/main/resources/mobile.csv";

    public MobileStore() {
        this.mobileList = new ArrayList<>();
        readMobileData();
    }

    public void addMobileToList() {
        Scanner scanner = new Scanner(System.in);
        String addMore;
        do {
            System.out.println("Enter the Brand Name - ");
            String brandName = scanner.nextLine();
            System.out.println("Enter the cost for the mobile - ");
            double cost = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the Screen Size - ");
            double screenSize = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the battery life of the mobile - ");
            int batteryLife = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the Megapixels for the Camera - ");
            int megaPixels = Integer.parseInt(scanner.nextLine());
            Mobile mobile = new Mobile(brandName,cost,screenSize,batteryLife,megaPixels);
            mobileList.add(mobile);
            System.out.println("Do you want to add more mobiles? (y/n) - ");
            addMore = scanner.nextLine();
        } while (addMore.equalsIgnoreCase("y"));
        writeMobileData();
    }

    public void readMobileData() {
        // Read the data from the file and store it in the List mobileList
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Mobile tempMobile = new Mobile();
                tempMobile.setBrandName(data[0].trim());
                tempMobile.setCost(Double.parseDouble(data[1]));
                tempMobile.setScreenSize(Double.parseDouble(data[2]));
                tempMobile.setBatteryLife(Integer.parseInt(data[3]));
                tempMobile.setMegaPixels(Integer.parseInt(data[4]));
                mobileList.add(tempMobile);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public void writeMobileData() {
        // Store data from the mobileList in the file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,false))){
            for (Mobile mobile : mobileList) {
                String data = "\n" + mobile.getBrandName() + "," + mobile.getCost() + "," + mobile.getScreenSize()
                        + "," + mobile.getBatteryLife() + "," + mobile.getMegaPixels();
                bufferedWriter.write(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public void displayMobile() {
        System.out.println("----------------------------");
        System.out.println("All Mobiles Available in the Store");
        for (Mobile mobile : mobileList) {
            mobile.displayDetails();
        }
    }

    public void displayMobile(List<Mobile> mobileList, String brandName) {
        System.out.println("----------------------------");
        System.out.println("All Mobiles Available in the Store with the Brand Name " + brandName + " - ");
        for (Mobile mobile : mobileList) {
            mobile.displayDetails();
        }
    }

    public void sortBasedOnCost() {
        mobileList.sort(new MobileComparatorBasedOnCost());
    }

    public void sortAlphabetically() {
        mobileList.sort(new MobileComparatorAlphabetically());
    }

    public void displayMenu(){
        System.out.println("Welcome to the Mobile Store!!!");
        System.out.println("Please select the options from below - ");
        System.out.println("1. Display all the Available Mobiles in the shop");
        System.out.println("2. Add Mobile to the shop");
        System.out.println("3. Find a specific brand of mobile - ");
        System.out.println("4. Display mobiles with Price low to high - ");
        System.out.println("5. Exit the shop - ");
        System.out.println("Please enter your choice (1-5) - ");
    }
}
