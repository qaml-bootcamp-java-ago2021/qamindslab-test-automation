package com.qamindslab.moduleone.selenium.example.webdriver.instance;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.Browser;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.NotWebDriverImplementedException;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeInstance {
<<<<<<< HEAD
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
=======
    public static void main(String[] args) throws NotWebDriverImplementedException {
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
      //  WebDriver driver = new ChromeDriver();
>>>>>>> main

        //WebDriver driver = WebDriverManager.getDriver(Browser.CHROME);

        ChromeBrowserDriver instanceDriver = new ChromeBrowserDriver();
        WebDriver driver = WebDriverManager.getBrowserInstance(instanceDriver);

        driver.get("https://www.google.com");
    }
}
