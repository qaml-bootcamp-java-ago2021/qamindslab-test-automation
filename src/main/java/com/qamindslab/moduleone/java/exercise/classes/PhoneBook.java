package com.qamindslab.moduleone.java.exercise.classes;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, String> phoneBookMap = new HashMap<>();

    PhoneBook(){
        phoneBookMap.put("juan", "123456789");
        phoneBookMap.put("maria", "987654321");
    }
    public static void main(String[] args) {


    }

    public void insert(String number, String name){
       this.phoneBookMap.put(name, number);
    }
}
