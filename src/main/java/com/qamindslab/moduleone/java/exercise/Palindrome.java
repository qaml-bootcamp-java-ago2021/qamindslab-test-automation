package com.qamindslab.moduleone.java.exercise;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("No lemon, no melon"));
    }

    public boolean isPalindrome(String stringToEvaluate){
        String noSpacesString = stringToEvaluate.replace(" ", "");
        char[] strings = noSpacesString.toCharArray();

        String swappedString = reverseString(strings);

        return swappedString.equalsIgnoreCase(noSpacesString);
    }

    private String reverseString(char strings []){
        String reversedString = "";

        for(int i = strings.length-1; i >=0; i--){
            reversedString += strings[i];
        }

        return reversedString;
    }
}
