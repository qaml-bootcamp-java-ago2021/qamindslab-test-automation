package com.qamindslab.moduleone.java.exercise.interfaces;

import com.qamindslab.moduleone.java.example.interfaces.Tank;
import com.qamindslab.moduleone.java.example.interfaces.Vehicle;

public class Truck implements Vehicle{
    int speed;

    public Truck(){
        this.speed = 0;
    }

    public static void main(String[] args) {
        Vehicle truck = (Vehicle) new Truck();
        truck.printSpec();

        Vehicle tank = (Vehicle) new Tank();
        tank.printSpec();
    }

    @Override
    public void speedUp() {
        this.speed += 2;
    }

    @Override
    public void printSpec() {
        System.out.println(this.getClass().getName());
    }
}
