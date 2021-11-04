package com.qamindslab.moduletwo.seleniumlocators.exercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortadaInWikipediaPartialLinks {

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
    public void PortadaInWikipediaPartialLinks() throws InterruptedException {
        driver.get("https://es.wikipedia.org/wiki/Portada");
        driver.manage().window().setSize(new Dimension(1661, 933));

        WebElement linkText = driver.findElement(By.linkText("Portada"));
        System.out.println("Text for portada link = " + linkText.getText());
        System.out.println("Text for portada link = " + linkText.getAttribute("href"));

        List<WebElement> links = driver.findElements(By.partialLinkText("Página"));
        System.out.println("Links elements = " + links.size());
        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            System.out.println("Text = " + link.getText());
            System.out.println("href =  = " + link.getAttribute("href"));
        }

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Button elements = " + buttons.size());
        for (int i = 0; i < buttons.size(); i++) {
            WebElement button = buttons.get(i);
            System.out.println("Text Button = " + button.getAttribute("title"));
        }

        Thread.sleep(1000);
        //driver.close();
    }
}
