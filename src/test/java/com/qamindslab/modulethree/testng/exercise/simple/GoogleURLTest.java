package com.qamindslab.modulethree.testng.exercise.simple;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GoogleURLTest {

        @Test
         public void googleURL(){
            String theURl = "https://www.google.com/";
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");
            String currentURL = driver.getCurrentUrl();
            Assert.assertEquals(theURl,currentURL);
            driver.close();
    }
}
