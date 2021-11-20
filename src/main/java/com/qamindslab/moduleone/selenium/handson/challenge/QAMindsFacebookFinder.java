package com.qamindslab.moduleone.selenium.handson.challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

// Hands On #5: Challenge 1 - Search on QAMinds in Facebook.
public class QAMindsFacebookFinder {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        WebElement textboxEmail = driver.findElement(By.id("email"));
        textboxEmail.sendKeys("vulcanraven@live.com.mx");
        WebElement textboxPassword = driver.findElement(By.id("pass"));
        textboxPassword.sendKeys("********");
        WebElement botonLogin = driver.findElement(By.name("login"));
        botonLogin.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


        WebElement textboxSearch = driver.findElement(By.xpath("//input[@type='search']"));
        textboxSearch.sendKeys("QA Minds");
        textboxSearch.sendKeys(Keys.ENTER);

        Thread.sleep(10000);
        driver.quit();
    }
}
