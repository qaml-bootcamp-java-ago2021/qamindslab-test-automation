package com.qamindslab.moduleone.java.exercise.classes;

public class Dog {
    public static void main(String[] args) {
        assert getHumanYears(6) == 43 : "Incorrect calculation for Dog age in human years";
    }

    public static float getHumanYears(int dogAge){
        return dogAge*7;
    }
}
