package com.qamindslab.moduleone.selenium.exercise.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadYouTube {
    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.youtube.com/");

        WebElement elementoSearch = driver.findElement(By.id("//*[@id=\"search\"]"));

        elementoSearch.isDisplayed();
        elementoSearch.isEnabled();

        elementoSearch.sendKeys("Selenium");

        WebElement elementoBoton = driver.findElement(By.id("//*[@id=\"search-icon-legacy\"]"));
        elementoSearch.click();
        elementoSearch.wait(5000);
        //driver.qui();
    }
}

