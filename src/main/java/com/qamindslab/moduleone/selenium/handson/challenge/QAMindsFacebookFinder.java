package com.qamindslab.moduleone.selenium.handson.challenge;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

// Hands On #5: Challenge 1 - Search on QAMinds in Facebook.
public class QAMindsFacebookFinder {

    public static void main(String[] args) throws InterruptedException{
         WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("sagis_bca@hotmail.com");
        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("XXXXXX");
        WebElement button = driver.findElement(By.name("login"));
        button.click();
        Thread.sleep(10000);
        WebElement search = driver.findElement(By.xpath("//input[@type = 'search']"));
        search.sendKeys("QA Minds");
        Thread.sleep(10000);
        driver.close();

    }

}
