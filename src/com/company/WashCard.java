package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WashCard {
    private int balance= 200;
    private String cardNumber;

    public int getBalance(){
        return balance;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public void addToBalance(int amount){
        balance += amount;
    }
    public void deductFromBalance(int amount){
        balance -= amount;
    }

    public WashCard(){

    }
    /*public void checkFDM() throws FileNotFoundException {
        Admin admin = new Admin();
        File washCardId = new File("/Users/AndreasGargulak/Documents/KEA/CarWash/validNumbers.txt");
        Scanner inputWashCardId = new Scanner(washCardId);
        ArrayList<Object> list = new ArrayList<>();
        while (inputWashCardId.hasNextLine()) {
            list.add(inputWashCardId.nextLine());
        }
        for (int i = 0; i< list.size(); i++){
            if(list.contains(999)){
                admin.setEconomy(admin.getEconomy()*8/10);
                admin.setStandard(admin.getStandard()*8/10);
                admin.setDeluxe(admin.getDeluxe()*8/10);
            }
        }
    }*/
}
