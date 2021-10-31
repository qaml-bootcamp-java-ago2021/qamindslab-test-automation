package com.qamindslab.moduleone.java.exercise.challenge;

public class StockSpan {

    public static void main(String[] args) {
        int[] stocks = {100, 60, 70, 65, 80, 85};
        int[] spans = new int[6];
        for(int i = 0; i < stocks.length; i++){
            int index = i;
            int days = 1;
            while(index > 0){
                if(stocks[index] < stocks[i]) {
                    days++;
                }
                index--;
            }
            spans[i] = days;
            System.out.println("spans[i] = " + spans[i]);
        }

    }
}
