/*
 * Author Name: Sarthak Agarwal
 * Date: 07/09/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak;

import java.util.Scanner;

public class MobileStoreImpl {
    public static void main(String[] args) {
        MobileStore mobileStore = new MobileStore();
        String repeat;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                mobileStore.displayMenu();
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        mobileStore.sortAlphabetically();
                        mobileStore.displayMobile();
                        break;
                    case 2:
                        mobileStore.addMobileToList();
                        System.out.println("Mobile has been added to the List!!");
                        break;
                    case 3:
                        System.out.println("Enter the Brand Name - ");
                        String mobileToRemove = scanner.nextLine();
                        mobileStore.removePhoneFromList(mobileToRemove);
                        break;
                    case 4:
                        System.out.println("Enter the brand name to search the mobile(s) - ");
                        String brandName = scanner.nextLine();
                        mobileStore.displayMobile(brandName);
                        break;
                    case 5:
                        mobileStore.sortBasedOnCost();
                        mobileStore.displayMobile();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.err.println("Invalid Input!! Please try again");
                }
            } catch (Exception exception) {
                System.err.println("Incorrect Input!! Please enter the correct choice");
            }
            System.out.println("Do you want to perform more operation? (y/n) - ");
            repeat = scanner.nextLine();
        } while (repeat.equalsIgnoreCase("y"));
    }
}
