package com.qamindslab.moduleone.java.exercise.loops;

public class FizBuz {
    int num;
    public FizBuz(int numero) {
        this.num = numero;
    }
    public void resultado(){
        for (int i= 1; i<=num; i++){
            if ((i%5==0) && (i%3==0))
                System.out.println("FIZZBUZZ");
            else if (i%3==0)
                System.out.println("FIZZ");
            else if (i%5==0)
                System.out.println("BUZZ");
            else
                System.out.println(i);
        }
    }
}
