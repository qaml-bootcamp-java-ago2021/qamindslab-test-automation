package com.qamindslab.moduleone.java.exercise.classes;

public class Dog {
    public static void main(String [] args){
        int anioPerro = 0;
        System.out.println(getHumanYears(anioPerro));
        assert Dog.getHumanYears(anioPerro) < 0 : "Ingrese un número entero positivo";

    }
    public static int getHumanYears(int anioPerro){
        int edadPerro;
        edadPerro = anioPerro * 7;
        return edadPerro;
    }

}
