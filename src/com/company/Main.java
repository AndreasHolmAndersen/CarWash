package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException  {
        File washCardId = new File("/Users/AndreasGargulak/Documents/KEA/CarWash/validNumbers.txt");
        Scanner inputUser = new Scanner(System.in);
        Scanner inputWashCardId = new Scanner(washCardId);
        WashCard washCard = new WashCard();
        FileWriter myWriter = new FileWriter("/Users/AndreasGargulak/Documents/KEA/CarWash/CarWashStatistic",true);
        Pause pause = new Pause();
        ArrayList<Object> list = new ArrayList<>();
        while (inputWashCardId.hasNextLine()) {
            list.add(inputWashCardId.nextLine());
        }
        System.out.println("Insert washcard");

        while (true) {
            String id = inputUser.next();
            if (list.contains(id)) {
                System.out.println("Card accepted!");
                break;
            } else if (id.equalsIgnoreCase("cancel")) {
                System.out.println("You've cancelled the action");
                break;
            } else {
                System.out.println("Cannot accept washcard, please try again");
            }
        }
        Admin admin = new Admin();
        program:
        while (true) {
            UI ui = new UI();
            ui.showMenu();
            int choice = inputUser.nextInt();
            Discount discount = new Discount();

            switch (choice) {
                case 1:

                    ui.pressOne();
                    choice = inputUser.nextInt();
                    if (choice == 1) {
                        discount.calculateDiscount(admin.getEconomy());
                        if(washCard.getBalance()< admin.getEconomy()){
                            System.out.println("you dont have enough money");
                            break;
                        }
                        if (discount.calculateDiscount(admin.getEconomy())==admin.getEconomy()*0.8){
                            admin.checkFDM();
                            System.out.println("You've gotten a discount!");
                            System.out.println("You've chosen the Economy wash: " + admin.getEconomy()*0.8+",- "  +"will "
                                    + "be deducted from you card\n");
                            washCard.deductFromBalance(admin.getEconomy()*8/10);
                            myWriter.write("\nEBeconomy");
                            System.out.println("Press 2 to pause the wash");
                            System.out.println("Press 1 to continue the wash");
                            choice = inputUser.nextInt();
                            if (choice == 2){
                                pause.wait(5);
                            }
                            else if (choice == 1){
                                break program;
                            }
                        }
                        else {
                            admin.checkFDM();
                            System.out.println("You've chosen the Economy wash: " + admin.getEconomy() + ",- "
                                    + "will be deducted from you card\n");

                            washCard.deductFromBalance(admin.getEconomy());
                            myWriter.write("\neconomy ");
                            System.out.println("Press 2 to pause the wash");
                            System.out.println("Press 1 to continue the wash");
                            choice = inputUser.nextInt();
                            if (choice == 2){
                                pause.wait(5);
                            }
                            else if (choice == 1){
                                break program;
                            }
                        }
                        myWriter.close();
                        break program;
                    }
                    if (choice == 2) {
                        if(washCard.getBalance()< admin.getStandard()) {
                            System.out.println("you dont have enough money");
                            break;
                        }
                        if(discount.calculateDiscount(admin.getStandard())==admin.getStandard()*0.8){
                            admin.checkFDM();
                            System.out.println("You've gotten a discount!");
                            System.out.println("You've chosen the Standard wash, "+ admin.getStandard()*0.8+",- "
                                    + "will be deducted from you card\n");
                            washCard.deductFromBalance(admin.getStandard()*8/10);
                            myWriter.write("\nEBstandard ");
                            System.out.println("Press 2 to pause the wash");
                            System.out.println("Press 1 to continue the wash");
                            choice = inputUser.nextInt();
                            if (choice == 2){
                                pause.wait(5);
                            }
                            else if (choice == 1){
                                myWriter.close();
                                break program;
                            }
                        }
                        else {
                            admin.checkFDM();
                            System.out.println("You've chosen the Standard wash, " + admin.getStandard() + ",- " + "will " +
                                    "be deducted from you card\n");

                            washCard.deductFromBalance(admin.getStandard());
                            myWriter.write("\nstandard");
                            System.out.println("Press 2 to pause the wash");
                            System.out.println("Press 1 to continue the wash");
                            choice = inputUser.nextInt();
                            if (choice == 2){
                                pause.wait(5);
                            }
                            else if (choice == 1){
                                myWriter.close();
                                break program;
                            }
                        }
                        myWriter.close();
                        break program;
                    }
                    if (choice == 3) {
                        if(washCard.getBalance()< admin.getDeluxe()) {
                            System.out.println("you dont have enough money");
                            break;
                        }
                        admin.checkFDM();
                        System.out.println("You've chosen the DeLuxe wash, " + admin.getDeluxe() +",- will " +
                                "be deducted from you card\n");
                        washCard.deductFromBalance(admin.getDeluxe());
                        myWriter.write("\ndeluxe ");
                        System.out.println("Press 2 to pause the wash");
                        System.out.println("Press 1 to continue the wash");
                        choice = inputUser.nextInt();
                        if (choice == 2){
                            pause.wait(5);
                        }
                        else if (choice == 1){
                            myWriter.close();
                            break program;
                        }
                        myWriter.close();
                        break program;
                    }
                    break;
                case 2:
                    System.out.println("Insert creditcard");
                    System.out.println("Insert the amount you wish to recharge");
                    choice = inputUser.nextInt();
                    washCard.addToBalance(choice);

                    System.out.println("Press 1 for receipt, or press 2 if you dont want one");
                    choice = inputUser.nextInt();
                    if (choice == 1) {
                        System.out.println("Your total on your washcard is now: " + washCard.getBalance() + "\n");
                        break;
                    }
                    if (choice == 2) {
                        break;
                    }
                case 3:
                    ui.pressThree();
                    break;
                case 4:
                    System.out.println("Enter admin password");
                    String s = inputUser.nextLine();

                    String Password = inputUser.nextLine();
                    admin.adminMenu(Password);
                    while (true) {
                    System.out.println("Press 1 to see statistics: ");
                    System.out.println("Press 2 to change price: ");
                    System.out.println("Press 3 to return to customer menu: ");

                    choice = inputUser.nextInt();
                    if(choice == 1) {
                        admin.carStat();
                    }
                    if (choice == 2){
                        System.out.println("Press 1 to change the price on Economy: ");
                        System.out.println("Press 2 to change the price on Standard: ");
                        System.out.println("Press 3 to change the price on DeLuxe: ");


                            choice = inputUser.nextInt();
                            if (choice == 1){
                                System.out.println("Enter the new price for Economy: ");
                                choice = inputUser.nextInt();
                                admin.setEconomy(choice);
                                System.out.println("The new price for Economy is now: "+admin.getEconomy());
                                continue;
                            }
                            if (choice == 2){
                                System.out.println("Enter the new price for Standard: ");
                                choice = inputUser.nextInt();
                                admin.setStandard(choice);
                                System.out.println("The new price for Standard is now: "+admin.getStandard());
                                continue;
                            }
                            if (choice == 3){
                                System.out.println("Enter the new price for DeLuxe: ");
                                choice = inputUser.nextInt();
                                admin.setDeluxe(choice);
                                System.out.println("The new price for DeLuxe is now: "+admin.getDeluxe());
                                continue;
                            }


                        }
                    if(choice == 3){
                        continue program;

                    }
                   }

                case 5:
                    break program;
            }
        }

    }
}