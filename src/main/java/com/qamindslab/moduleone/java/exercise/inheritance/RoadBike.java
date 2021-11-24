package com.qamindslab.moduleone.java.exercise.inheritance;

import com.qamindslab.moduleone.java.example.inheritance.Bike;

public class RoadBike extends Bike {
    private String brand;
    private int speed;

    public RoadBike(){
      super("merida");
        speed=0;
    }

   //@Override
    public void  speedUp(){
        this.speed=speed+1;
        System.out.println(String.format(this.brand,this.speed));
    }

}
