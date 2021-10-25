package com.qamindslab.moduleone.java.example.inheritance;

public class Bike {
    private String brand;
    private int speed;

    public Bike(String brand){
        this.brand = brand;
        this.speed = 0;
    }

    public void speedUp(){
        this.speed += 1;
        System.out.println(String.format("%s speed %d", this.brand, this.speed));
    }
}
