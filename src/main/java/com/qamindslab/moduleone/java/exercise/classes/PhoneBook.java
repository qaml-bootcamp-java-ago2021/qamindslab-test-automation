package com.qamindslab.moduleone.java.exercise.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Create a PhoneBook class that stores names and phone numbers and allows the operations of look-up, insertion and deletion.
How to store the information? (Possible solutions)
a) Use 2 LinkedList to store name and number.
b) Use a HashMap to store the number as a key and the name has a value
**/
public class PhoneBook {
    public static void main(String[] args ){
        Map<Integer,String> agenda = new HashMap<Integer,String>();
        agenda.put(999999999,"Denise Mays");
        agenda.put(888888888,"Sofia Tavara");
        agenda.put(777777777, "Virginia Vela");
        System.out.println("Your current PhoneBook is: ");
        for (int i:agenda.keySet()) {
            System.out.println("Phone number: "+i+" With name: "+agenda.get(i));
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("\nNeed to add write 1; Need find wirte 2; need remove write 3");
        Integer val =scan.nextInt();
        int number;
        String name;
        switch (val){
            case 1:
                System.out.println("Write the number");
                number = scan.nextInt();
                System.out.println("Write name");
                name = scan.next();
                agenda.put(number,name);
                System.out.println("The phone added is: "+number+ " With name: nombre: "+name);
                for (int i:agenda.keySet()) {
                    System.out.println("New phonebook. Phone number: "+i+" With name: "+agenda.get(i));
                }
                break;
            case 2:
                System.out.println("Write the number want to search");
                number = scan.nextInt();
                if (agenda.containsKey(number)) {
                    System.out.println("Your phone was found: "+agenda.get(number));
                } else System.out.println(("Your phone "+number+" was not found" ));
                break;
            case 3:
                System.out.println("Write the number to remove");
                number = scan.nextInt();
                if(agenda.containsKey(number)){
                    agenda.remove(number);
                    System.out.println("Your phone removed is: "+number);
                }else System.out.println("Your phone to remove was not found to remove");
                break;
            default:
                System.out.println("Option entered is not valid");
                break;
        }

    }
    }


