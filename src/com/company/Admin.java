package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String password = "1234";

    private int economy = 50;
    private int standard = 80;
    private int deluxe = 120;

    public void setEconomy(int economy) {
        this.economy = economy;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public void setDeluxe(int deluxe) {
        this.deluxe = deluxe;
    }

    public int getEconomy() {
        return economy;
    }

    public int getStandard() {
        return standard;
    }

    public int getDeluxe() {
        return deluxe;
    }

    /**
     * @throws FileNotFoundException
     * method counts every instance of washtypes in the statistics file prints them out.
     */
    public void carStat() throws FileNotFoundException {
        File washCarStatistics = new File("/Users/AndreasGargulak/Documents/KEA/CarWash/CarWashStatistic");
        Scanner inputWashStat = new Scanner(washCarStatistics);
        ArrayList<Object> statisticList = new ArrayList<Object>();
        Discount discount = new Discount();
        int economyCount = 0;
        int standardCount = 0;
        int deluxeCount = 0;
        int discountEconomy = 0;
        int discountStandard = 0;

        while (inputWashStat.hasNextLine()) {
            statisticList.add(inputWashStat.nextLine());
        }
        for (int i = 0; i <= statisticList.size() - 1; i++) {
            if (statisticList.get(i).equals("economy")) {
                economyCount += 1;
            }
            if (statisticList.get(i).equals("standard")) {
                standardCount += 1;
            }
            if (statisticList.get(i).equals("deluxe")) {
                deluxeCount += 1;
            }
            if (statisticList.get(i).equals("EBeconomy")) {
                discountEconomy += 1;
            }
            if (statisticList.get(i).equals("EBstandard")) {
                discountStandard += 1;
            }

        }
        System.out.println("number of Economy washes: " + economyCount);
        System.out.println("number of Standard washes: " + standardCount);
        System.out.println("number of DeLuxe washes: " + deluxeCount);
        System.out.println("number of EarlyBird Economy washes: " + discountEconomy);
        System.out.println("number of EarlyBird Standard washes: " + discountStandard);

    }

    /**
     * @param Password Checks if entered password is equal to set password,
     * if correct prints out correct
     *
     */
    public void adminMenu(String Password) {
        if (password.equals(Password)) {
            System.out.println("Password correct");
        } else {
            System.out.println("Password incorrect");
        }
    }

    /**
     * @throws FileNotFoundException
     * Loops through our validnumbers file and if the number contains '999' gives you a 20% discount
     * on all washes
     */
    public void checkFDM() throws FileNotFoundException {
        File washCardId = new File("/Users/AndreasGargulak/Documents/KEA/CarWash/validNumbers.txt");
        Scanner inputWashCardId = new Scanner(washCardId);
        ArrayList<Object> list = new ArrayList<>();
        while (inputWashCardId.hasNextLine()) {
            list.add(inputWashCardId.nextLine());
        }
        while (true){
            list.equals(123456);
            setEconomy(getEconomy() * 8 / 10);
            setStandard(getStandard() * 8 / 10);
            setDeluxe(getDeluxe() * 8 / 10);
            break;
        }
    }
}



