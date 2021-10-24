package com.qamindslab.moduleone.java.exercise.challenge;

public class StockSpan {

    public static void main (String args []) {
        int[] arreglo={100,60,70,65,80,85};
        int[] dias= new int[arreglo.length];
        for(int i=0;i<arreglo.length ; i++){
            for(int j=i,d=0;j>=0;j--){
                if(arreglo[i]>=arreglo[j]){
                    d++;
                }
                dias[i]=d;
            }
            System.out.println("Arreglo["+i+"]="+dias[i]);
        }
    }
}
