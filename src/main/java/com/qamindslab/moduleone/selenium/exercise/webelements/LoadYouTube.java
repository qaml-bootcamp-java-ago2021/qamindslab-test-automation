package com.qamindslab.moduleone.selenium.exercise.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoadYouTube {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,50);

        WebElement txtBoxSearch = driver.findElement(By.xpath("//input[@id='search']"));

        txtBoxSearch = wait.until(ExpectedConditions.elementToBeClickable(txtBoxSearch));
        if(txtBoxSearch!=null){
            System.out.println("the textbox to search is displayed? "+txtBoxSearch.isDisplayed());
            System.out.println("The textbox to search is enable? "+txtBoxSearch.isEnabled());
        }
        txtBoxSearch.click();
        txtBoxSearch.sendKeys("Selenium");
        WebElement btnSearchIconLegacy = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        btnSearchIconLegacy.click();
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
