package com.qamindslab.moduleone.selenium.exercise.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadYouTube {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        WebElement elemento = driver.findElement(By.xpath("//input[@id='search']"));
        System.out.println("Display: "+elemento.isDisplayed());
        System.out.println("Enable: "+elemento.isEnabled());
        elemento.sendKeys("Selenium");
        WebElement Button = driver.findElement(By.id("search-icon-legacy"));
        Button.click();
        Thread.sleep(5000);
        driver.close();
    }


}
