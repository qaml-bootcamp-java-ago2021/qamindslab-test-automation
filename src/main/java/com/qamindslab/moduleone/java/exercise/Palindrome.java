package com.qamindslab.moduleone.java.exercise;

public class Palindrome {
    public static void main (String args []) {
        String word ="anitalavalatina";
        String rever = "";
        for(int i=word.length() -1;i>=0;i--) {
            rever += word.charAt(i);
        }
        if(word.compareTo(rever)==0) {
            System.out.println(word + " es palindromo " + rever);
        } else {
            System.out.println(word + " No es palindromo");
        }
    }



}
