package com.qamindslab.moduleone.java.example.interfaces;

public class Tank implements Vehicle{
    private int speed;
    private int numeroLlantas;
    private double peso;
    private int tripulacion;

    public Tank(){

        this.speed = 0;

    }

    @Override
    public void speedUp(){
        this.speed += 1;
        System.out.println(String.format("Velocidad tanque: %s", this.speed));
    }

    @Override
    public void printSpec(){
        this.numeroLlantas = 0;
        this.peso = 66.8;
        this.tripulacion = 4;
        System.out.println(String.format("Llantas: "+ this.numeroLlantas
        +"\nPeso: " + this.peso
        +"\nTripulacion: " + this.tripulacion));
    }
}
