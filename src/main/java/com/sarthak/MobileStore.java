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
        // Create an instance of BufferedReader and FileReader in a try-with-resource block
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mobileList;
    }
}
