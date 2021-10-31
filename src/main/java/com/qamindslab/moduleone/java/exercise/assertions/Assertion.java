package com.qamindslab.moduleone.java.exercise.assertions;

public class Assertion {
    public static void main(String[] args) {
        /*int age = 27;
        assert age >= 18;
        assert 1 > 5 : "Wait a minute, that's not true";

        if (1>5){

        }
        else{
            throw new AssertionError("Un momentooooo...");
        }*/
        //Comparación de cadenas
        String cadena1 = "Dog";
        String cadena2 = "Cat";

        assert cadena1.equals(cadena2) : "No son iguales";

        //Comparación entre número y cadena
        Integer numeroComp = 33;
        String cadenaComp = "Guendanabani";

        assert numeroComp.equals(cadenaComp) : "El contenido de un Integer y una cadena son distintos";

        //Validación resta
        System.out.println(resta(10,5));
        assert  Assertion.resta(10,5)!= 5  : "Revisa tu resultado";

        }
        public static int resta(int a, int b){
            int resultado;
            resultado = a - b;
            return resultado;
        }
}
