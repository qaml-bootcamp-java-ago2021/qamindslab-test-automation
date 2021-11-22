package com.qamindslab.moduleone.selenium.handson.acton;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

// Hands On #4 - Search on Amazon.
public class AmazonSearcher {
    public static void main(String[] args) throws InterruptedException{
       WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
       // WebDriver driver = new ChromeDriver();
        //driver.get("https://www.amazon.com.mx/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");

        WebElement searchTextbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextbox.sendKeys("Selenium");
        searchTextbox.sendKeys(Keys.ENTER);
        WebElement pass = driver.findElement(By.id("pass"));
        Thread.sleep(10000);
        driver.close();

    }

}
