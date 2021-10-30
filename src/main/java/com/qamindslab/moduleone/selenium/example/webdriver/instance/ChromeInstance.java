package com.qamindslab.moduleone.selenium.example.webdriver.instance;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeInstance {
    public static void main(String[] args) {
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
      //  WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverManager.getDriver("CHROME");

        driver.get("https://www.google.com");
    }
}
