/*
 * Author Name: Sarthak Agarwal
 * Date: 09/09/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak;

import java.util.Comparator;

public class MobileComparator implements Comparator<Mobile> {
    @Override
    public int compare(Mobile o1, Mobile o2) {
        return Double.compare(o1.getCost(),o2.getCost());
    }
}
