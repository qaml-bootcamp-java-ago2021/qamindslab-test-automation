package com.qamindslab.moduletwo.seleniumlocators.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WaitForGoogle {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        driver.findElement(By.id("Unknown ID"));

        //Thread.sleep(10000);
        //driver.quit();
    }
}
