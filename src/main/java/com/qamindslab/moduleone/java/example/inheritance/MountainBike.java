package com.qamindslab.moduleone.java.example.inheritance;

public class MountainBike extends Bike{
    private int seatHeight;

    MountainBike (String brand){
        super(brand);
        this.seatHeight = 0;
    }

    public void setSeatHeight(int newHeight){
        this.seatHeight = newHeight;
    }
}
