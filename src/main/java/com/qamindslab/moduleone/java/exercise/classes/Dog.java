package com.qamindslab.moduleone.java.exercise.classes;

import javax.swing.*;
/*
# Add a method called “getHumanYears” to get dog age in human years.
# Under your main class validate this new method, use asserts!
* */
public class Dog {

    public static void main(String args[]){
        assert Dog.getHumanYears() < 0 : "This should be major zero";
    }

    public static int getHumanYears(){
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad de tu perro"));
        return edad*7;

    }

}
