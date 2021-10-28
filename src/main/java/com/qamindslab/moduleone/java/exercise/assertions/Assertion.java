package com.qamindslab.moduleone.java.exercise.assertions;

public class Assertion {
    public static void main(String[] args) {
        String string1 = "Hola";
        String string2 = "Mundo";
        assert  string1.equals(string2) : "Strings are NOT equal";

        String string3 = "10";
        int number = 10;
        assert Integer.parseInt(string3) != number : "Strings is NOT equal number";

        assert (substract(5, 4) != 1) : "Expected value should be 1";
    }

    public static int substract(int numberA, int numberB){
        return numberA - numberB;
    }
}
