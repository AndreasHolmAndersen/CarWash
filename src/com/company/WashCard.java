package com.company;

public class WashCard {
    private int balance= 200;

    public int getBalance(){
        return balance;
    }

    public void addToBalance(int amount){
        balance += amount;
    }
    public void deductFromBalance(int amount){
        balance -= amount;
    }

    public WashCard(){

    }
}
