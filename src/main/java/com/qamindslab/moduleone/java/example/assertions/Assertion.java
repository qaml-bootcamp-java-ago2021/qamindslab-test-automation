package com.qamindslab.moduleone.java.example.assertions;

public class Assertion {
    public static void main(String[] args) {
        int age = 27;
        assert age >= 18;
        assert 1 > 5: "The message when the condtion is not met.";
    }
}
