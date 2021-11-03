package com.qamindslab.moduleone.selenium.exercise.webdriver.commonmethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadGooglePage {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");
            driver.get("http://www.youtube.com/");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getPageSource());
            driver.quit();
        }
}
