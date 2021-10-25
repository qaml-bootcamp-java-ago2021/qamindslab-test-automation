package com.qamindslab.moduleone.java.exercise.interfaces;

public class Truck implements Vehicle{
    static int velocidad;

    public static void main(String[] args){
        Truck object1= new Truck();
        object1.printSpec();
    }


    public Truck(){
        this.velocidad=150/3;
    }
    @Override
    public void printSpec() {
        System.out.println("La velocidad es: "+velocidad);
    }
}
