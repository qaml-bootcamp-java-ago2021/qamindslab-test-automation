package com.qamindslab.moduleone.selenium.handson.challenge;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Hands On #6: Challenge 2 - Visit Selenium Hyperlinks in Wikipedia
public class WikipediaSeleniumHyperlinksVisitor {
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
    public void WikipediaSeleniumHyperlinksVisitor() throws InterruptedException, IOException {

        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement emailInput = driver.findElement(By.id("searchInput"));
        emailInput.sendKeys("selenium\n");

        List<WebElement> pElements =driver.findElements(By.tagName("p"));
        System.out.println("There are " + pElements.size() + " <p> elements on this page");
        System.out.println("Currnet URL is  " + driver.getCurrentUrl());

        List<WebElement> aElements =driver.findElements(By.tagName("a"));
        List<String> externalLinks= new ArrayList<String>();
        for (int i = 0; i < aElements.size(); i++) {

            if(aElements.get(i).getAttribute("href") != null && !aElements.get(i).getAttribute("href").contains("wikipedia")){
                System.out.println("Link is " + aElements.get(i).getAttribute("href"));
                externalLinks.add(aElements.get(i).getAttribute("href"));
            }
        }

        System.out.println("Need to visit " + externalLinks.size() + "external links");
        for (int i = 0; i < externalLinks.size(); i++) {
            driver.navigate().to(externalLinks.get(i));
        }

        Thread.sleep(1000);

        driver.close();
    }

}
