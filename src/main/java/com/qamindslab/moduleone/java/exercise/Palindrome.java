package com.qamindslab.moduleone.java.exercise;

public class Palindrome {
    /*public static void main (String args []) {
        String word ="anitalavalatina";
        String rever = "";
        for(int i=word.length() -1;i>=0;i--) {
            rever += word.charAt(i);
        }
        if(word.compareTo(rever)==0) {
            System.out.println(word + " es palindromo " + rever);
        } else {
            System.out.println(word + " No es palindromo");
        }
    }*/


    public static void main (String args []) {
        int[] arreglo={100,60,70,65,80,85};
        int[] dias= new int[arreglo.length];
        for(int i=0,d=0;i<arreglo.length ; i++){
            for(int j=i;j>=0;j--){
                if(arreglo[i]>=arreglo[j]){
                  d++;
             }
                dias[i]=d;
            }
            System.out.println("Arreglo["+i+"]="+dias[i]);
        }
    }
}
