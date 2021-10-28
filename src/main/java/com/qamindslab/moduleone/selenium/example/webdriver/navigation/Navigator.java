package com.qamindslab.moduleone.selenium.example.webdriver.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://es.wikipedia.org/wiki/El_protegido");

        driver.navigate().to("http://selenium-blog.herokuapp.com/");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        //driver.quit();
    }
}
