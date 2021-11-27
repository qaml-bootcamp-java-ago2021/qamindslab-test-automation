package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class Navigator {
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
    public void googleSearch2() {
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(1661, 933));
        System.out.println("Current URL is:" + driver.getCurrentUrl());

        driver.navigate().to("https://www.facebook.com/");
        System.out.println("Current URL is:" + driver.getCurrentUrl());

        driver.navigate().to("https://www.espn.com/");
        System.out.println("Current URL is:" + driver.getCurrentUrl());

        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Current URL is:" + driver.getCurrentUrl());

        driver.navigate().forward();
        System.out.println("Current URL is:" + driver.getCurrentUrl());

        assert (driver.getCurrentUrl().equals("https://www.facebook.com/")) : "No nos encontramos en facebook: " + driver.getCurrentUrl() ;

        driver.navigate().refresh();
        driver.close();

    }
}
