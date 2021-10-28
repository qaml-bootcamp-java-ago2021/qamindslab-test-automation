package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();

        printLoadTime(driver, "https://www.google.com");

        printLoadTime(driver, "https://www.facebook.com");

        printLoadTime(driver, "https://www.espn.com");

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

    public static void printLoadTime(WebDriver driver, String url){

        long startTime = System.currentTimeMillis();

        driver.get(url);

        long endTime = System.currentTimeMillis();

        long totalTime = endTime - startTime;

        System.out.println("[GET] " + driver.getCurrentUrl() + " " + totalTime + " ms");
    }
}
