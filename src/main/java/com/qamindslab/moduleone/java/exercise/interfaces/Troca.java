package com.qamindslab.moduleone.java.exercise.interfaces;

import com.qamindslab.moduleone.java.example.interfaces.Tank;
import com.qamindslab.moduleone.java.example.interfaces.Vehicle;

public class Troca {
    public static void main(String [] args){

        Vehicle tanque = new Tank();
        Vehicle camioneta = new Truck();

        tanque.speedUp();
        tanque.printSpec();

        camioneta.speedUp();
        camioneta.printSpec();

    }
}
