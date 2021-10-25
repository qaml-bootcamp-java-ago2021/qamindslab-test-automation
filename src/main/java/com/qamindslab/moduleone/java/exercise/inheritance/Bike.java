package com.qamindslab.moduleone.java.exercise.inheritance;

public class Bike {
    private String modelo;
    private int velocidad;

    public Bike(String modelo, int velocidad){
        this.modelo =modelo;
        this.velocidad = velocidad;
    }

    public void speedup(){
        System.out.println("Information from Bike. Modelo: "+this.modelo+" Velocida: "+this.velocidad+" por hora");
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public int getVelocidad() {
        return velocidad;
    }

}
