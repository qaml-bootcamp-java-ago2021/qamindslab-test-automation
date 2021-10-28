package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.get("https://www.facebook.com");

        driver.get("https://www.espn.com");

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
}
