package com.qamindslab.moduleone.java.exercise.loops;

public class JavaLoop {

    public static void main (String [] args){

        for (int i=1; i<=100; i++) {
            if(i%3 ==0){
                System.out.println("Friz");
            }
            if(i%5 ==0){
                System.out.println("Buzz");
            }
            if(i%3 ==0 & i%5==0){
                System.out.println("FrizBuzz");
            }
            if(i%3 !=0 & i%5!=0){
                System.out.println(i);
            }


        }




    }

}
