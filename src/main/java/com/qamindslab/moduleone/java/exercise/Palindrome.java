package com.qamindslab.moduleone.java.exercise;

public class Palindrome {

    public static void main(String[] args) {
        int inicio = 0;
        String frase = "amolapacificapaloma";
        int finalFrase = frase.length()-1;
        boolean esPalindromo = false;

        while ((inicio < finalFrase) && (esPalindromo == false)) {
            if (frase.charAt(inicio) == frase.charAt(finalFrase)) {
                inicio++;
                finalFrase--;
            } else {
                esPalindromo = true;
            }
        }
        if (esPalindromo == false) {
            System.out.println("Es palindromo");
        } else {
            System.out.println("No es palindromo");
        }
    }
}
