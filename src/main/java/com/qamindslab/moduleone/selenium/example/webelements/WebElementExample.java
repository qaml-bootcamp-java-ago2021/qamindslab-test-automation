package com.qamindslab.moduleone.selenium.example.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebElementExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement companyLogo = driver.findElement(By.id("header_logo"));
        List<WebElement> companyLogos = driver.findElements(By.id("header_logoa"));

        companyLogo.click();

        System.out.println(companyLogos);


    }
}
