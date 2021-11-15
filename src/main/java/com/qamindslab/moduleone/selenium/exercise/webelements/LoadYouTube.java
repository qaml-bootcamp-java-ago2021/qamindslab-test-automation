package com.qamindslab.moduleone.selenium.exercise.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoadYouTube {
    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get("http://www.youtube.com/");

        WebElement elementoSearch = driver.findElement(By.id("//*[@id=\"search-input\"]"));

        if(elementoSearch.isDisplayed() && elementoSearch.isEnabled()) {

            elementoSearch.sendKeys("Selenium");
            WebElement elementoBoton = driver.findElement(By.id("//*[@id=\"search-icon-legacy\"]"));
            elementoSearch.click();
        }
        Thread.sleep(5000);
        //driver.qui();
    }
}

