package com.qamindslab.moduleone.java.example.classes;

public class Car {
    private int doors;
    private String tires;
    private String windows;
    private int seats;
    private String breaks;

    public void turnOn(){}
    public String turnOff(){return "Car is off.";}
    public void turnOnLights(){
        System.out.println("Lights are on.");
    }
    public boolean turnOfLights(){return false;}
    public void stop(){}
    public void openDoors(){
        System.out.println("Doors are opened.");
    }
}
