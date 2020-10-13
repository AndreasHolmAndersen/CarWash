package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class Discount {

    /**
     * @param Price
     * @return
     * Calculates the discount if its the weekdays (>1 & <7, 1 is sunday and 7 is monday)
     * and if its before 2pm
     */
    public int calculateDiscount(int Price) {
        int price = Price;

        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        Date date = new Date();
        int currentTime = Integer.parseInt(formatter.format(date));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);

        if (day > 1 && day < 7 && currentTime < 14) {
            price = (int) (Price * 0.8);
            return price;

        }
        return price;
        }
    }

