package com.qamindslab.moduleone.java.exercise.StockSpan;

public class StockSpan {

    public static void main(String[] args) {
        int[] stocks = {100, 60, 70, 65, 80, 85};
        int[] spans = new int[6];
        for(int i = 0; i < stocks.length; i++){
            int index = i;
            int days = 1;
            //System.out.println("Index = " + index);
            //System.out.println("days = " + days);
            //System.out.println("stocks[index] = " + stocks[index]);
            //System.out.println("stocks[i] = " + stocks[i]);
            while(index > 0){
                if(stocks[index] < stocks[i]) {
                    days++;
                }
                index--;
                //System.out.println("W Index = " + index);
                //System.out.println("W days = " + days);
            }
            spans[i] = days;
            System.out.println("spans[i] = " + spans[i]);
        }

    }
}
