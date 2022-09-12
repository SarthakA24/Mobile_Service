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
        initialiseMobileStore();
    }

    public void initialiseMobileStore() {
        System.out.println("Initialising the Mobile Store...");
        try {
            Thread.sleep(2000);
            System.out.println("Store Initialised!!");
            Thread.sleep(1000);
            System.out.println("Reading data from the Mobiles List");
            readMobileData();
            Thread.sleep(2000);
            System.out.println("Data Read Successfully!!");
            Thread.sleep(1000);
            System.out.println("Initialising the Menu....");
            System.out.println("----------------------------");
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public void addMobileToList() {
        Scanner scanner = new Scanner(System.in);
        String addMore;
        do {
            System.out.println("Enter the Brand Name - ");
            String brandName = scanner.nextLine();
            System.out.println("Enter the Model Number for the Phone");
            String modelNumber = scanner.nextLine();
            System.out.println("Enter the cost for the mobile - ");
            double cost = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the Screen Size - ");
            double screenSize = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the battery life of the mobile - ");
            int batteryLife = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the Megapixels for the Camera - ");
            int megaPixels = Integer.parseInt(scanner.nextLine());
            Mobile mobile = new Mobile(brandName,modelNumber,cost,screenSize,batteryLife,megaPixels);
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
                tempMobile.setModelNumber(data[1].trim());
                tempMobile.setCost(Double.parseDouble(data[2]));
                tempMobile.setScreenSize(Double.parseDouble(data[3]));
                tempMobile.setBatteryLife(Integer.parseInt(data[4]));
                tempMobile.setMegaPixels(Integer.parseInt(data[5]));
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
                String data = "\n" + mobile.getBrandName() + "," + mobile.getModelNumber() + "," + mobile.getCost() + "," + mobile.getScreenSize()
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
            if (currentMobile.getBrandName().equalsIgnoreCase(brandName)) {
                phoneByBrand.add(currentMobile);
            }
        }
        return phoneByBrand;
    }

    public void removePhoneFromList(String brandName) {
        Scanner scanner = new Scanner(System.in);
        displayMobile(brandName);
        System.out.println("Enter the Model Number for the Mobile that you want to delete - ");
        String modelNumberToRemove = scanner.nextLine();
        mobileList.stream()
                .filter(mobile -> mobile.getBrandName().equalsIgnoreCase(brandName) && mobile.getModelNumber().equalsIgnoreCase(modelNumberToRemove))
                .findFirst().ifPresent(mobileList::remove);
        System.out.println(brandName + " " + modelNumberToRemove + " has been removed from the Store!!");
        writeMobileData();
    }

    public void displayMobile() {
        System.out.println("----------------------------");
        System.out.println("All Mobiles Available in the Store");
        mobileList.forEach(mobile -> {
            mobile.displayDetails();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void displayMobile(String brandName) {
        List<Mobile> phoneByBrand = findPhoneByBrand(brandName);
        System.out.println("----------------------------");
        System.out.println("All Mobiles Available in the Store with the Brand Name " + brandName + " - ");
        phoneByBrand.forEach(Mobile::displayDetails);
    }

    public void sortBasedOnCost() {
        mobileList.sort(Comparator.comparingDouble(Mobile::getCost));
    }

    public void sortAlphabetically() {
        mobileList.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getBrandName(),o2.getBrandName()));
    }

    public void displayMenu(){
        System.out.println("Welcome to the Mobile Store!!!");
        System.out.println("Please select the options from below - ");
        System.out.println("1. Display all the Available Mobiles in the shop");
        System.out.println("2. Add Mobile to the shop");
        System.out.println("3. Remove Mobile from the shop");
        System.out.println("4. Find a specific brand of mobile - ");
        System.out.println("5. Display mobiles with Price low to high - ");
        System.out.println("6. Exit the shop - ");
        System.out.println("Please enter your choice (1-5) - ");
    }
}
