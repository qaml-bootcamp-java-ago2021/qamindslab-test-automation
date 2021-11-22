package com.qamindslab.moduleone.selenium.handson.acton;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

// Hands On #2 - Search something in Google.
public class GoogleSearcher {
    public static void main(String[] args) throws InterruptedException{
    WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
      //  System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      //  WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    driver.get("https://www.google.com/");
    assert driver.getCurrentUrl().equals("https://www.google.com/"):"sitio incorrecto";
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("Oso");
        searchTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.close();

    }
}
