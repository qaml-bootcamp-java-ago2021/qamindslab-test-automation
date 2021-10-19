package com.qamindslab.moduleone.java.exercise.loops;

public class JavaLoop {
    public static void main(String args[]) {

        for (int i = 1; i <= 15; i++) {
            System.out.println(i);

            String respuesta="";

            if (i%3 == 0) {
                respuesta = "Fizz";
            }
            if (i%5 == 0) {
                respuesta = "Buzz";
            }
            if (i%3==0 && i%5==0) {
                respuesta="FizzBuzz";
            }
            System.out.println(respuesta);

        }
    }
}