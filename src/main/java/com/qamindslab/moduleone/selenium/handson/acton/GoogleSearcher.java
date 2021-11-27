package com.qamindslab.moduleone.selenium.handson.acton;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

// Hands On #2 - Search something in Google.
public class GoogleSearcher {
    public static void main(String[] args) throws InterruptedException {
        // Create a WebDriver instance through WebDriverManager.
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        // Maximize the browser Window.
        driver.manage().window().maximize();
        // Wait 10 seconds to load the page.
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // Go to Google.com.
        driver.get("https://www.google.com");

        // Assert that the current url is 'https://www.google.com/'
        assert driver.getCurrentUrl().equals("https://www.google.com/") : "Incorrect website.";

        // Find the searchTextBox.
        WebElement searchTextBox = driver.findElement(By.name("q"));
        // Send a Search text to find a Selenium WebDriver demo class by Marco De Jesus.
        searchTextBox.sendKeys("MARENA COSTA RICA");
        // Press Enter to perform the search.
        searchTextBox.sendKeys(Keys.ENTER);

        // Wait for 5 seconds.
        Thread.sleep(5000);;

        // Close the Browser Window.
        driver.close();
    }
}
