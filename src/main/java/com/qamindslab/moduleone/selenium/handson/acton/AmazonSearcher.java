package com.qamindslab.moduleone.selenium.handson.acton;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

// Hands On #4 - Search on Amazon.
public class AmazonSearcher {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com.mx/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement textBoxSearch = driver.findElement(By.id("twotabsearchtextbox"));
        textBoxSearch.sendKeys("Selenium");
        textBoxSearch.sendKeys(Keys.ENTER);

        Thread.sleep(10000);
        driver.quit();

    }
}
