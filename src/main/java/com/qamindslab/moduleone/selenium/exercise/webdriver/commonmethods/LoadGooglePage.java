package com.qamindslab.moduleone.selenium.exercise.webdriver.commonmethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadGooglePage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(1000);

        // Printing page title
        String pageTitle = driver.getTitle();
        System.out.println("PAGE TITLE: " + pageTitle);

        // Printing current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("CURRENT URL: " + currentUrl);

        // Printing source code
        String pageSource = driver.getPageSource();
        System.out.println("PAGE SOURCE: " + pageSource);

        driver.close();
    }
}
