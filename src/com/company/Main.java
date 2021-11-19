package com.company;

import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int x = 1;
        Scanner scanner = new Scanner(System.in);

        int users = 0;
        int right =0;
        boolean login = false;
        HashMap<String , Integer > people = new HashMap<String, Integer>();
        people.put("BOB",250);
        people.put("ALICE",300);
        do {
            System.out.println("Click Enter To Start");
            scanner.nextLine();
            System.out.println("login : ");
            String inptName = scanner.nextLine();
            if(inptName == " "){
                System.out.println("Please insert your name");
            }
            String name = inptName.toUpperCase();
            System.out.println("Click enter for continue");
            scanner.nextLine();
            if (name != null){
                for (String i : people.keySet()){
                    if (name.contains(i)){
                        login = true;
                        users = users + 1;
                    }
                }
                if (users == 0 ){

                    System.out.println("User not found");
                    System.out.println("Do you want to add this user?");
                    System.out.println("1. Yes, Please \n2. No, Thank you ");
                    int chooseRegister = scanner.nextInt();
                    scanner.nextLine();
                    switch(chooseRegister){
                        case 1:
                            System.out.println("Insert saldo: ");
                            Integer saldo = scanner.nextInt();
                            people.put(name,saldo);
                            users = users + 1;
                            System.out.println("Success Register");
                            System.out.println(people);
                            login=true;
                            break;

                        case 2:
                            System.out.println("Thank you for coming.");
                            break;
                    }
                }else{
                    System.out.println("Welcome, " + name);
                }
            }else{
                System.out.println("insert your account");
            }

            if (login == true) {
                System.out.println("Welcome Mr/Mrs." + name);
                System.out.println("1. Deposit");
                System.out.println("2. Transfer");
                System.out.println("3. Withdraw");
                System.out.println("4. logout");
                int menu = scanner.nextInt();
                scanner.nextLine();
                switch (menu){
                    case 1:
                        System.out.println("Deposit: ");
                        int deposit = scanner.nextInt();
                        people.replace(name,people.get(name)+deposit);
                        System.out.println("Your update saldo : Rp."+people.get(name));
                        break;
                    case 2:
                        System.out.println("Transfer to ");

                        String peopleTransfer = scanner.nextLine();
                        for (String i: people.keySet()){
                            if(peopleTransfer.toUpperCase().contains(i)){
                                right =  right +1;
                            }
                        }
                        System.out.println("Click enter for continue");
                        scanner.nextLine();
                        if(right > 0){
                            System.out.println("Insert total transfer");
                            int transfer = scanner.nextInt();
                            if (transfer <= people.get(name)){
                                System.out.println("You transfer to " + peopleTransfer.toUpperCase() + " for " + transfer);
                                people.replace(name,people.get(name)-transfer);
                                people.replace(peopleTransfer,people.get(peopleTransfer.toUpperCase())+transfer);
                            }else{
                                System.out.println("Your saldo is not enaugh");
                            }
                        }else{
                            System.out.println("User not found");
                        }
                        break;

                        case 3:
                            System.out.println("Withdaraw: ");
                            System.out.println("Your saldo : " + people.get(name));
                            System.out.println("Withdraw amount: ");
                            int withdraw = scanner.nextInt();
                            if (people.get(name) >= withdraw){
                                people.replace(name,people.get(name)-withdraw);
                                System.out.println("Your saldo now: "+ people.get(name));
                            }
                            break;

                            case 4:
                                System.out.println("Bye");
                                login = false;
                                break;

                }
            }
            scanner.nextLine();
        }while(x == 1);
    }
}
