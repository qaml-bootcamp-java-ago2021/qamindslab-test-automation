package com.qamindslab.moduleone.java.exercise.classes;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, String> phoneBook;

    public PhoneBook(){
        phoneBook = new HashMap();
    }

    public static void main(String[] args) {
        PhoneBook personalPhoneBook = new PhoneBook();
        personalPhoneBook.insert("123456789", "Hugo");
        personalPhoneBook.insert("987654321", "Paco");
        personalPhoneBook.insert("456789123", "Luis");

        try{
            personalPhoneBook.lookUp("12345s6789");
        }catch (PhoneNumberNotFoundException ex){
            ex.printStackTrace();
        }

        personalPhoneBook.delete("456789123");
        personalPhoneBook.updateName("123456789", "Rodrigo");

        for(Map.Entry<String, String> phone : personalPhoneBook.phoneBook.entrySet()){
            System.out.println(phone);
        }
    }

    public void insert(String number, String name){
        phoneBook.put(number, name);
    }

    public String lookUp(String number) throws PhoneNumberNotFoundException{
        String phone = phoneBook.get(number);
        if ( phone == null){
            throw new PhoneNumberNotFoundException("Phone not found");
        }

        return phone;
    }

    public void delete(String number){
        phoneBook.remove(number);
    }

<<<<<<< HEAD
=======
    Map<String, String> phoneBook;

    public PhoneBook(){
        phoneBook = new HashMap();
    }

    public static void main(String[] args) {
        PhoneBook personalPhoneBook = new PhoneBook();
        personalPhoneBook.insert("123456789", "Hugo");
        personalPhoneBook.insert("987654321", "Paco");
        personalPhoneBook.insert("456789123", "Luis");

        try{
            personalPhoneBook.lookUp("12345s6789");
        }catch (PhoneNumberNotFoundException ex){
            ex.printStackTrace();
        }

        personalPhoneBook.delete("456789123");
        personalPhoneBook.updateName("123456789", "Rodrigo");

        for(Map.Entry<String, String> phone : personalPhoneBook.phoneBook.entrySet()){
            System.out.println(phone);
        }
    }

    public void insert(String number, String name){
        phoneBook.put(number, name);
    }

    public String lookUp(String number) throws PhoneNumberNotFoundException{
        String phone = phoneBook.get(number);
        if ( phone == null){
            throw new PhoneNumberNotFoundException("Phone not found");
        }

        return phone;
    }

    public void delete(String number){
        phoneBook.remove(number);
    }

>>>>>>> e3d93fc (Implementing Phone Book exercise)
    public void updateName(String number, String name){
        phoneBook.replace(number, name);
    }
}
