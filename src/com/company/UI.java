package com.company;

public class UI {
    WashCard washCard = new WashCard();
    public void showMenu(){
        System.out.println("Press 1 to start carwash: ");
        System.out.println("Press 2 to recharge your washcard: ");
        System.out.println("Press 3 to see your balance: ");
        System.out.println("Press 4 for admin log-on: ");
        System.out.println("Press 5 to quit: ");
    }

    public void pressOne(){
        System.out.println("Weekdays before 14 you're eligible for a 20% discount");
        System.out.println("Press 1 for wash type Economy: ");
        System.out.println("Press 2 for wash type Standard");
        System.out.println("Press 3 for wash type DeLuxe");
    }
    public void pressThree(){
        System.out.println("Your balance is: " + washCard.getBalance()+"\n");
    }


}
