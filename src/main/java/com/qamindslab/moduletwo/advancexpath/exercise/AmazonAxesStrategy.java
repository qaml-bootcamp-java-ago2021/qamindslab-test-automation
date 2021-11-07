package com.qamindslab.moduletwo.advancexpath.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AmazonAxesStrategy {
    public static void main(String [] args){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://es.wikipedia.org/wiki/Selenium");

        WebElement myDynamicElement = driver.findElement(By.id("myDynamicElement"));

    }
}
