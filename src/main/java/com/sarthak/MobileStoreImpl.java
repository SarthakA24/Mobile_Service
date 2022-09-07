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
        String fileName = "src/main/resources/mobile.csv";
        List<Mobile> mobileList = mobileStore.readMobileData(fileName);
        System.out.println("mobileList = " + mobileList);
        List<Mobile> oneplus = mobileStore.findPhoneByBrand("oneplus");
        System.out.println("oneplus = " + oneplus);
        List<Mobile> phoneCostMoreThan$500 = mobileStore.findPhoneCostMoreThan$500();
        System.out.println("phoneCostMoreThan$500 = " + phoneCostMoreThan$500);
        List<Mobile> phonePixelMoreThan12MP = mobileStore.findPhonePixelMoreThan12MP();
        System.out.println("phonePixelMoreThan12MP = " + phonePixelMoreThan12MP);
    }
}
