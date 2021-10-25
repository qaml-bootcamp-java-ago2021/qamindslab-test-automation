package com.qamindslab.moduleone.java.exercise.inheritance;

public class RoadBike extends Bike{
    private int peso;

    public static void main(String [] args){
            Bike myBike = new Bike("Monañera",150);
            myBike.speedup();
            RoadBike myRoadBike = new RoadBike(myBike.getModelo(), myBike.getVelocidad());
            System.out.println("Information from RoadBike. Modelo: "+myRoadBike.getModelo()+" Velocidad: "+myRoadBike.getVelocidad()+" por hora y Peso: "+myRoadBike.peso);
    }

    public RoadBike(String mode, int velocidad){
        super(mode,velocidad);
        this.peso=15;
    }
}
