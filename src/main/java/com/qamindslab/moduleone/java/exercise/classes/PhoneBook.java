package com.qamindslab.moduleone.java.exercise.classes;
import java.util.HashMap;

public class PhoneBook {

    static HashMap<String, String> directorio = new HashMap<String, String>();

    public static void main(String [] args){

        directorio.put("4775726408", "Ziriako");
        directorio.put("4776769656", "Lula");
        directorio.put("1234567", "Nuit");
        directorio.put("1234561", "Barto");
        directorio.put("1234562", "Memo");
        directorio.put("1234563", "Kame");


        for(String indice: directorio.keySet()){
            System.out.println("Número: " + indice + "\nNombre: " +directorio.get(indice));
        }

        System.out.println("Despues de agregar un nuevo elemento");
        agregar("4775726409","Luis");

        for(String indice: directorio.keySet()){
            System.out.println("Número: " + indice + "\nNombre: " +directorio.get(indice));
        }

        System.out.println("Despues de modificar un nuevo elemento");
        modificar("4775726409","Jose");

        for(String indice: directorio.keySet()){
            System.out.println("Número: " + indice + "\nNombre: " +directorio.get(indice));
        }
        System.out.println("Despues de eliminar un nuevo elemento");
        eliminar("4775726409");

        for(String indice: directorio.keySet()){
            System.out.println("Número: " + indice + "\nNombre: " +directorio.get(indice));
        }

        busqueda("4775726408");

    }
    public static void agregar(String numero, String nombre){
        directorio.put(numero, nombre);
    }
    public static void modificar(String numero, String nombre){
        directorio.replace(numero, nombre);
    }
    public static void eliminar(String numero){
        directorio.remove(numero);
    }
    public static String busqueda(String numero){
        String telefono = directorio.get(numero);
        return telefono;
    }
}
