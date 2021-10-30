package com.qamindslab.moduleone.selenium.handson.acton;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

// Hands On #4 - Search on Amazon.
public class AmazonSearcher {
    public static void main(String[] args) throws InterruptedException {
        // Create the instance through our WebDriverManager.
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());

        // Maximize the Browser Window
        driver.manage().window().maximize();

        // Page has 10 seconds to load.
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");

        // Search for 'Selenium'
        WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextBox.sendKeys("Selenium");
        searchTextBox.submit();
        // By pressing enter should work too.
        // searchTextBox.sendKeys(Keys.ENTER);

        // Hold whole application execution (the main Thread) by 10 seconds
        // THIS IS A BAD PRACTICE.
        Thread.sleep(10000);

        // Closing only the Browser window but not moving driver to null.
        driver.close();
    }
}
