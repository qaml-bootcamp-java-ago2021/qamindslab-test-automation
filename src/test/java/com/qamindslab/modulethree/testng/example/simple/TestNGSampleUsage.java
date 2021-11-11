package com.qamindslab.modulethree.testng.example.simple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGSampleUsage {
    @Test
    public void passTC(){
        Assert.assertEquals("Test", "Test");
    }

    @Test
    public void failTC(){
        Assert.assertEquals("Test", "Fail");
    }
}
