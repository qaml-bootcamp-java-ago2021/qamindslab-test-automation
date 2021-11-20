package com.qamindslab.modulethree.testng.exercise.withwebdriver;

import com.qamindslab.modulethree.testng.example.withwebdriver.common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleURLTest extends BaseTest {
    @Test(description = "Open google page", alwaysRun = true, groups= {"regression"})
    @Parameters({"baseUrl"})
    public void openGoogle(@Optional("https://www.google.com/") String baseUrl){
        //String theURl = "https://www.google.com/mx";
        driver.get("https://www.google.com/");
        assertEquals(driver.getCurrentUrl(), baseUrl, "Didn't get expected google url");
        driver.close();
    }

}
