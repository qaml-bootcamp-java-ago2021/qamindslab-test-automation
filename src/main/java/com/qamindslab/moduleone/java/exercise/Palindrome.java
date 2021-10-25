package com.qamindslab.moduleone.java.exercise;

public class Palindrome {
    public static void main(String[] args){

        String originString = "Ana lava lana";
        String newOriginString = originString.toLowerCase().replace(" ", "").replace(".", "").replace(",", "");
        StringBuilder toReverceString = new StringBuilder(newOriginString);
        StringBuilder stringReverted = toReverceString.reverse();
        if (newOriginString.equals(stringReverted.toString())) {
            System.out.println("son iguales Original: " + newOriginString + " convertido: " + stringReverted.toString());
        } else
            System.out.println("no son guiles Original: " + newOriginString + " convertido: " + stringReverted.toString());
    }
}
