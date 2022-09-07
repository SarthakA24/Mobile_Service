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

public class MobileStore extends Mobile {
    public List<Mobile> readMobileData(String fileName) {
        List<Mobile> mobileList = new ArrayList<>();
        // Create a variable to count the number of line in the file
        int numberOfLines = 0;
        // Create an instance of BufferedReader and FileReader in a try-with-resource block to count the number of
        // line in the file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            bufferedReader.readLine();
            while (bufferedReader.readLine() != null) {
                numberOfLines++;
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        // Read the data from the file and store it in the List mobileList
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String brandName = data[0].trim();
                double cost = Double.parseDouble(data[1]);
                double screenSize = Double.parseDouble(data[2]);
                int batteryLife = Integer.parseInt(data[3]);
                Mobile tempMobile = new Mobile(brandName, cost, screenSize, batteryLife);
                mobileList.add(tempMobile);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        return mobileList;
    }
}
