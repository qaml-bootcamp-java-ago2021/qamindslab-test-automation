package com.qamindslab.modulethree.testng.exercise.withwebdriver;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GoogleURLTest {
    @Test
    public void validateGoogleUrl() {
        //Arrange
        String expected = "https://www.google.com/";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        //Act
        String actual = driver.getCurrentUrl();

        //Assert
        assertEquals(actual, expected, "Url is not correct.");
    }
}
