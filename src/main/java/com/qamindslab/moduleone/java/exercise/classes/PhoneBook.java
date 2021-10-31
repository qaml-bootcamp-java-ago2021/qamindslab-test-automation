package com.qamindslab.moduleone.java.exercise.classes;

import org.openqa.selenium.NotFoundException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PhoneBook {
    private static PhoneBookOperations operations;

    public static void main(String[] args) {
        operations = new PhoneBookOperations();
        operations.insert("76856478", "Jesus");
        operations.insert("76285764", "Juan");
        operations.insert("23456789", "Julia");
        operations.printPhoneBook();

        operations.delete("76285764");
        operations.printPhoneBook();

        operations.updateName("76856478", "Jesus Serrano");
        operations.printPhoneBook();

        System.out.println(operations.lookup("76856478"));

    }

    public static class PhoneBookOperations {
        Map<String, String> phoneBookMap = new HashMap<>();

        public void insert(String number, String name){
            System.out.println("Inserting ");
            this.phoneBookMap.put(number, name);
        }

        public void delete(String number){
            System.out.println("Deleting " + number);
            if(this.phoneBookMap.containsKey(number)){
                this.phoneBookMap.remove(number);
            }
        }

        public void updateName(String number, String name){
            System.out.println("Updating " + number);
            if(this.phoneBookMap.containsKey(number)){
                this.phoneBookMap.replace(number, this.phoneBookMap.get(number) , name);
            }
        }

        public String lookup(String number){
            System.out.println("Looking " + number);
            String name = "";
            if(this.phoneBookMap.containsKey(number)){
                name =  this.phoneBookMap.get(number);
            }else{
                throw new NotFoundException("The number was not found on the phonebook");
            }
            return name;
        }


        public void printPhoneBook(){
            for (Map.Entry entry : this.phoneBookMap.entrySet())
            {
                System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
            }
        }
    }
}
