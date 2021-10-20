package com.qamindslab.moduleone.java.exercise.challenge;

public class StockSpan {
    public static void main(String[] args) {
        int stockPrices [] = new int[] {100, 60, 70, 65, 80, 85};
        int stockSpan [] = new int[stockPrices.length];

        stockSpan[0] = 1;

        for(int stockPriceIndex =1; stockPriceIndex<stockPrices.length; stockPriceIndex++){
            stockSpan[stockPriceIndex] = 1;
            System.out.println(stockPrices[stockPriceIndex]);

            int stockPricePreviousIndex = stockPriceIndex-1;

            while((stockPricePreviousIndex >= 0) && (stockPrices[stockPriceIndex] >= stockPrices[stockPricePreviousIndex])){
                stockSpan[stockPriceIndex]++;
                stockPricePreviousIndex--;
            }
/*            for(int j=stockPriceIndex-1; (j >= 0) && (stockPrices[stockPriceIndex] >= stockPrices[j]); j--){
                stockSpan[stockPriceIndex]++;
            }*/
        }

        for(int i : stockSpan){
            System.out.println(i);
        }
    }
}
