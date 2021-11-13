package com.qamindslab.modulethree.testng.example.lifecycle;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class A extends TestNGLifecycle{
    @BeforeClass
    public void beforeClassA(){
        System.out.println("Before Class - 3_A");
    }

    @AfterClass
    public void afterClassA(){
        System.out.println("After Class - 3_A");
    }

    @Test(groups = {"3_A"}, priority=0)
    public void test1A(){
        System.out.println("TEST1 - 3_A");
    }

    @Test(groups = {"3_A"}, priority=1)
    public void test2A(){
        System.out.println("TEST2 - 3_A");
    }

    @Test(groups = {"3_A"}, priority=2)
    public void test3A(){
        System.out.println("TEST3 - 3_A");
    }
}
