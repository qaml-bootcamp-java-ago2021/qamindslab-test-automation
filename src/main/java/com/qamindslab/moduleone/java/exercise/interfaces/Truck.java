package com.qamindslab.moduleone.java.exercise.interfaces;
import com.qamindslab.moduleone.java.example.interfaces.Vehicle;

public class Truck implements Vehicle{

    private int speed;
    private int numeroLlantas;
    private int pasajeros;

    Truck(){
        this.speed = 0;
    }

    @Override
    public void speedUp(){
        this.speed +=2;
        System.out.println(String.format("Velocidad de camioneta: %s", this.speed));
    }
    @Override
    public void printSpec(){
        this.numeroLlantas = 4;
        this.pasajeros=5;
        System.out.println(String.format("Llantas: " + this.numeroLlantas
        +"\nPasajeros: " + this.pasajeros));

    }
}
