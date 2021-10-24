package com.qamindslab.moduleone.java.exercise.classes;

public class Dog {
    public static void main (String args []) {

        assert getHumansYears(1)<=7:"Años perro";
    }

    public static int getHumansYears(int yearsdog){
        return yearsdog*7;
    }

}
