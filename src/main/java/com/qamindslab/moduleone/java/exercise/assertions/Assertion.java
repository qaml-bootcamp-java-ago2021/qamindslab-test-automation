package com.qamindslab.moduleone.java.exercise.assertions;

public class Assertion {
    public static void main(String[] args) {
        assert "Casting".equals("Dummy String") : "Incorrect strings.";

        //Integer numberToCompare = 3;
        //assert numberToCompare.equals("test") : "An Integer is not equal to a String";

        //assert (6 >= 0) && (6<=5) : "Number is not between 0 and 5";

        //assert subtract(4, 2) == 1 : "Subtraction is not right.";
    }

    public static int subtract(int a, int b){
        return a - b;
    }
}
