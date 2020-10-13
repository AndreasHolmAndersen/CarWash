package com.company;

public class UI {
    /**
     * Prints out the menu
     */
    WashCard washCard = new WashCard();
    public void showMenu(){
        System.out.println("Press 1 to start carwash: ");
        System.out.println("Press 2 to recharge your washcard: ");
        System.out.println("Press 3 to see your balance: ");
        System.out.println("Press 4 for admin log-on: ");
        System.out.println("Press 5 to quit: ");
    }

    /**
     * Prints out the different carwash options
     */
    public void pressOne(){
        System.out.println("Weekdays before 14 you're eligible for a 20% discount");
        System.out.println("Press 1 for wash type Economy: ");
        System.out.println("Press 2 for wash type Standard");
        System.out.println("Press 3 for wash type DeLuxe");
    }

    /**
     * Prints out the balance on your card
     */
    public void pressThree(){
        System.out.println("Your balance is: " + washCard.getBalance()+"\n");
    }

    /**
     * @param price
     * @param name
     * Prints out the receipt for the wash
     */
    public void receipt(double price, String name){
        System.out.println("Wash type: "+ name + "\nPrice: " + price);
    }


}
