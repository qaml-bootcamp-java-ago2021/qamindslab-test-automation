package com.qamindslab.modulethree.testng.example.withwebdriver.common;

import com.qamindslab.modulethree.testng.example.withwebdriver.common.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    public void setup(String browser){
    }

    private static WebDriver getDriver(String browser) throws NotWebDriverImplementedException {
        return null;
    }

    public void tearDown(){
    }
}
