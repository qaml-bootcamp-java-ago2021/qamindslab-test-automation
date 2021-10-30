package com.qamindslab.moduleone.selenium.handson.acton;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.Browser;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.NotWebDriverImplementedException;
import com.qamindslab.moduleone.selenium.handson.webdriver.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Hands On #4 - Search on Amazon.
public class AmazonSearcher {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() throws NotWebDriverImplementedException {
        driver = WebDriverManager.getDriver(Browser.CHROME);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void AmazonSearcher() throws InterruptedException, IOException {

        driver.get("https://www.amazon.com.mx/");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        WebElement emailInput = driver.findElement(By.id("twotabsearchtextbox"));
        emailInput.sendKeys("selenium\n");
        Thread.sleep(10000);

        driver.close();
    }
}


