package com.qamindslab.moduletwo.seleniumlocators.example.waits.functional;

import java.util.function.Function;

public class GuessTheNumber {
    public static void main(String[] args) {

        NumberGuesser guesser = new NumberGuesser();
        System.out.println(guesser.apply(3));

        System.out.println(new NumberGuesser().apply(3));

        Function guesser1 = guesser;
        System.out.println(guesser1.apply(34));


        Function guesser2 = new Function<Integer, String>(){
            @Override
            public String apply(Integer number) {
                return (number == 3) ? "You're lucky!" : "Give it another try.";
            }
        };

        System.out.println(guesser2.apply(3));

        Function guesser3 = (Function<Integer, String>) number -> (number == 3) ? "You're lucky!" : "Give it another try.";

        System.out.println(guesser3.apply(3));

    }
}

// https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
class NumberGuesser implements Function<Integer, String>{
    @Override
    public String apply(Integer number) {
        return (number == 3) ? "You're lucky!" : "Give it another try.";
    }
}
