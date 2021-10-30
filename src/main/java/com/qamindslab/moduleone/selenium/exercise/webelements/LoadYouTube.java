package com.qamindslab.moduleone.selenium.exercise.webelements;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class LoadYouTube {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void LoadYouTube() throws InterruptedException {
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));
        if(element != null){
            System.out.println("isDisplayed = " + element.isDisplayed());
            System.out.println("isEnabled = " + element.isEnabled());
            Thread.sleep(5000);

            element.sendKeys("Selenium");
            WebElement searchBar = driver.findElement(By.id("search-icon-legacy"));
            if(searchBar != null){
                searchBar.click();
                Thread.sleep(5000);
            }

        }

    }
}
