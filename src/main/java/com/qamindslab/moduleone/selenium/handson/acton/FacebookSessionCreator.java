package com.qamindslab.moduleone.selenium.handson.acton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Hands On #3 - Login into Facebook
public class FacebookSessionCreator {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        WebElement textboxEmail = driver.findElement(By.id("email"));
        textboxEmail.sendKeys("ziriako@gmail.com");
        WebElement textboxPassword = driver.findElement(By.id("pass"));
        textboxPassword.sendKeys("*********");
        WebElement botonLogin = driver.findElement(By.name("login"));
        botonLogin.click();

        Thread.sleep(10000);
        driver.quit();

    }
}
