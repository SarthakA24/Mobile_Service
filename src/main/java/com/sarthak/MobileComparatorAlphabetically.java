/*
 * Author Name: Sarthak Agarwal
 * Date: 09/09/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak;

import java.util.Comparator;

public class MobileComparatorAlphabetically implements Comparator<Mobile> {
    @Override
    public int compare(Mobile o1, Mobile o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getBrandName(),o2.getBrandName());
    }
}
