package com.qamindslab.moduleone.java.exercise.assertions;

public class Assertion {
    public static void main (String args []) {

    String word1="belen";
    String word2="belen";
    String numero="1000";
    int num =1000;
    int resultado=0;
    assert word1.equals(word2):"No son iguales";
    assert Integer.parseInt(numero)!=num:"Los numeros no son iguales";

    assert (resta(10,10))!=1:"No son iguales";
}

    public static int resta(int n1, int n2){
        return n1-n2;
    }
}
