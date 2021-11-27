package com.qamindslab.modulethree.testng.example.annotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGGroupsAnnotation {

    @Test(groups = {"brokenTests"})
    public void brokenTest(){
        Assert.assertTrue(false);
    }

    @Test
    public void testMethod(){
        Assert.assertTrue(true);
    }
}
