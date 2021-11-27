package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigator {
    public static  WebDriver driver;
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();

        printLoadTime(driver, "https://www.google.com");
       // WebElement element_google = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.LLD4me.yr19Zb.LS8OJ > div > img"));
        //myElement(element_google);
        printLoadTime(driver, "https://www.facebook.com");
       // WebElement element_facebook = driver.findElement(By.cssSelector("#content > div > div > div > div._8esl > div > img"));
       // myElement(element_facebook);
        printLoadTime(driver, "https://www.espn.com");
       // WebElement element_spn= driver.findElement(By.cssSelector("#global-nav-mobile-trigger"));
       // myElement(element_facebook);
        driver.navigate().back();
        driver.navigate().back();

        driver.navigate().back();
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        assert driver.getCurrentUrl().equals("https://www.facebook.com/") : "Url is incorrect.";
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());

        driver.quit();

    }
    public static void myElement(WebElement elemen){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elemen));
    }

    public static void printLoadTime(WebDriver driver, String url){
        long startTime = System.currentTimeMillis();
        driver.get(url);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("[GET] " + driver.getCurrentUrl() + " " + totalTime + " ms");
    }
}
