package com.qamindslab.moduleone.java.exercise.assertions;
/*
Reuse Assertions Example Code and test this condition using asserts:
If two string are equal
If an integer is equal to a string
If a number is between a range - create a method
Create a new method called “subtract” with two parameters number A and number B. It should return A - B.
Test your new method using asserts
**/
public class Assertion {
    public static void main(String[] args){
        String string1= "Hola";
        String string2 = "Paola";
        Integer number = 5;
        assert 1 > 5: "The message when the condtion is not met.";
        assert string1.equals(string2) : "The number doesn't equal";
        assert string1.equals(number) : "The string is not equal to number";
        assert 15<number : "The number is not between a range";
    }
}
