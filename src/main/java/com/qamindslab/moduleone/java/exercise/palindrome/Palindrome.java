package com.qamindslab.moduleone.java.exercise.palindrome;

public class Palindrome {
    public static void main(String[] args) {
        String palindrome = "anitalavalatina";
        String reverseString = "";
        for(int i = palindrome.length()-1; i >= 0; i-- ){
            reverseString += palindrome.charAt(i);
        }
        if(palindrome.compareTo(reverseString) == 0){
            System.out.println("The string is a palindrome");
        }else{
            System.out.println("The string is NOT a palindrome");
        }
    }
}
