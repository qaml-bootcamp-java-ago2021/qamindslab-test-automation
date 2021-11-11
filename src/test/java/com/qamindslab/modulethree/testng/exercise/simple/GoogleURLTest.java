package com.qamindslab.modulethree.testng.exercise.simple;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleURLTest {
    @Test
    public void validateGoogleUrl(){
        //Arrange
        String expected = "https://www.google.com/";

        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.get("https://www.google.com/");

        //Act
        String actual = driver.getCurrentUrl();

        //Assert
        assertEquals(actual, expected, "Url is not correct.");
    }
}
