package com.qamindslab.moduleone.java.exercise.inheritance;

import com.qamindslab.moduleone.java.example.inheritance.Bike;

public class RoadBike extends Bike {

    private int speed;
    private String brand;

    public RoadBike(){
        super("Merida");
        speed = 0;
    }

    @Override
    public void speedUp(){
        this.speed += 1;
        System.out.println(String.format("%s speed %d", this.brand, this.speed));
    }
}
