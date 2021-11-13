package com.qamindslab.modulethree.testng.example.lifecycle;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class B extends TestNGLifecycle{
    @BeforeClass
    public void beforeClassB(){
        System.out.println("Before Class - 3_B");
    }

    @AfterClass
    public void afterClassB(){
        System.out.println("After Class - 3_B");
    }
    @Test(groups = {"3_B"}, priority=3)
    public void test1B(){
        System.out.println("TEST1 - 3_B");
    }
    @Test(groups = {"3_B"}, priority=4)
    public void test2B(){
        System.out.println("TEST2 - 3_B");
    }
    @Test(groups = {"3_B"}, priority=5)
    public void test3B(){
        System.out.println("TEST3 - 3_B");
    }
}
