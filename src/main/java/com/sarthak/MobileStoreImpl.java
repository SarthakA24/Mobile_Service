/*
 * Author Name: Sarthak Agarwal
 * Date: 07/09/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak;

import java.util.List;

public class MobileStoreImpl {
    public static void main(String[] args) {
        MobileStore mobileStore = new MobileStore();
        // Read the mobile data from the file
        mobileStore.readMobileData();
        // Display all the mobiles available in the store to the customer in Alphabetically order
        mobileStore.sortAlphabetically();
        mobileStore.displayMobile();
    }
}
