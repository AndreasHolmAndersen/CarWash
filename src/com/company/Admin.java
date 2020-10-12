package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String password ="1234";

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

    public void carStat () throws FileNotFoundException {
        File washCarStatistics = new File("/Users/AndreasGargulak/Documents/KEA/CarWash/CarWashStatistic");
        Scanner inputWashStat = new Scanner(washCarStatistics);
        ArrayList<Object> statisticList = new ArrayList<Object>();
        Discount discount = new Discount();
        int economyCount=0;
        int standardCount=0;
        int deluxeCount=0;
        int discountEconomy=0;
        int discountStandard=0;

        while (inputWashStat.hasNextLine()){
            statisticList.add(inputWashStat.nextLine());
        }
        for (int i =0; i<=statisticList.size()-1; i++){
            if(statisticList.get(i).equals("economy")){
                economyCount += 1;
            }
            if(statisticList.get(i).equals("standard")){
                standardCount+=1;
            }
            if (statisticList.get(i).equals("deluxe")){
                deluxeCount+=1;
            }
            if(statisticList.get(i).equals("EBeconomy")){
                discountEconomy+=1;
            }
            if(statisticList.get(i).equals("EBstandard")){
                discountStandard+=1;
            }

        }
        System.out.println("number of Economy washes: "+ economyCount);
        System.out.println("number of Standard washes: "+ standardCount);
        System.out.println("number of DeLuxe washes: "+ deluxeCount);
        System.out.println("number of EarlyBird Economy washes: "+ discountEconomy);
        System.out.println("number of EarlyBird Standard washes: "+discountStandard);

        /*int totalEarning = economyCount*getEconomy()
                +standardCount * getStandard()
                +deluxeCount * getDeluxe()
                +discountEconomy * discount.calculateDiscount(getEconomy())
                +discountStandard * discount.calculateDiscount(getStandard());
        System.out.println(totalEarning+" kr");*/
        
    }
    public void adminMenu(String Password){
        if (password.equals(Password)){
            System.out.println("Password correct");
        }
        else {
            System.out.println("Password incorrect");
        }
    }

}
