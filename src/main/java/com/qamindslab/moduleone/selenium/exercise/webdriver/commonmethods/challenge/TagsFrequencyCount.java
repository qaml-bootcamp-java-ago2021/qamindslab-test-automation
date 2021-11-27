package com.qamindslab.moduleone.selenium.exercise.webdriver.commonmethods.challenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class TagsFrequencyCount {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void LoadGooglePage() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(1661, 933));

        String sourceCode = driver.getPageSource();
        System.out.println("function on page = " + sourceCode.split("function").length);
        System.out.println("scripts on page = " + sourceCode.split("script").length);
        System.out.println("classes on page = " + sourceCode.split("class=").length);
        System.out.println("IDs on page = " + sourceCode.split("id=").length);

        Thread.sleep(1000);
        driver.close();
    }
}
