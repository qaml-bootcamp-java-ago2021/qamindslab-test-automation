package com.qamindslab.moduleone.selenium.handson.acton;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

// Hands On #2 - Search something in Google.
public class GoogleSearcher {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        
        assert driver.getCurrentUrl().equals("https://www.google.com") : "Revisa la url";

        WebElement cuadroTexto = driver.findElement(By.name("q"));
        cuadroTexto.sendKeys("Deep into that darkness peering, long I stood there...");
        cuadroTexto.sendKeys(Keys.ENTER);

        Thread.sleep(10000);

        driver.quit();
    }
}
