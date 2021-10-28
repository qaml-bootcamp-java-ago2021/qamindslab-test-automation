package com.qamindslab.moduleone.java.exercise.palindrome;
import java.util.Scanner;

public class palindrome{

    public static void main(String args[]) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la palabra a evaluar");
        String palabra = entrada.nextLine();

        int incremento = 0;
        int decremento = palabra.length() - 1;
        boolean validacion = false;

        while ((incremento < decremento) && (!validacion)) {

            if (palabra.charAt(incremento) == palabra.charAt(decremento)) {
                incremento++;
                decremento--;

            } else {
                validacion = true;
            }

        }
        if (!validacion) {
            System.out.println(palabra + " SI es un palindromo");
        } else {
            System.out.println(palabra + " NO es un palindromo");
        }
    }
}