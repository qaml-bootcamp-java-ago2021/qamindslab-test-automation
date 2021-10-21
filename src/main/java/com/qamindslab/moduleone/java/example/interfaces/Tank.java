package com.qamindslab.moduleone.java.example.interfaces;

public class Tank implements Vehicle{
    private int speed;

    Tank(){
        this.speed = 0;
    }

    @Override
    public void speedUp(){
        this.speed += 1;
        System.out.println(String.format("New speed %s", this.speed));
    }
}
