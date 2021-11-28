package com.qamindslab.modulethree.testng.exercise.withwebdriver;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import com.qamindslab.modulethree.testng.exercise.withwebdriver.common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GoogleURLTest extends BaseTest {

    @Test(description = "Open google page", alwaysRun = true, groups= {"regression"})
    @Parameters({"baseUrl"})
    public void validateGoogleUrl(@Optional("") String baseUrl){
        //Arrange
        String expected = baseUrl;
        driver.get("https://www.google.com/");

        //Act
        String actual = driver.getCurrentUrl();

        //Assert
        assertEquals(actual, expected, "Url is not correct.");
    }
}
