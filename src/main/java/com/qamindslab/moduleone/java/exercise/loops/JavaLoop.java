package com.qamindslab.moduleone.java.exercise.loops;

import java.util.ArrayList;
import java.util.List;

public class JavaLoop {
    public static void main(String[] args) {
        JavaLoop loop = new JavaLoop();
        List<String> multiplesOf = loop.identifyMultiplesOf(100);
        multiplesOf.forEach(System.out::println);
    }

    public List<String> identifyMultiplesOf(int numbersToIterate) {
        List<String> multipleOfThreeAndFive = new ArrayList<>();

        for(int i=1; i<= numbersToIterate; i++){
            if(isMultipleOfThreeAndFive(i)){
                multipleOfThreeAndFive.add("FizzBuzz");
            }else if(isMultipleOf(3, i)){
                multipleOfThreeAndFive.add("Fizz");
            }else if(isMultipleOf(5, i)){
                multipleOfThreeAndFive.add("Buzz");
            }else{
                multipleOfThreeAndFive.add(String.valueOf(i));
            }
        }

        return multipleOfThreeAndFive;
    }

    private boolean isMultipleOfThreeAndFive(int numberToEvaluate){
        return isMultipleOf(3, numberToEvaluate) && isMultipleOf(5, numberToEvaluate);
    }

    private boolean isMultipleOf(int multipleOf, int numberToEvaluate){
        return (numberToEvaluate % multipleOf) == 0;
    }
}
