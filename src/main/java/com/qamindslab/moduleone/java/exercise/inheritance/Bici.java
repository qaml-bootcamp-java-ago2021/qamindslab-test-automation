package com.qamindslab.moduleone.java.exercise.inheritance;

import com.qamindslab.moduleone.java.example.inheritance.Bike;

public class Bici {
    public static void main(String []args){
        Bike bicicleta = new Bike("Apache");
        bicicleta.speedUp();

        Bike bici2 = new RoadBike();
        bici2.speedUp();

    }
}
