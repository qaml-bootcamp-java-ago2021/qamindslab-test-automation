package com.qamindslab.moduletwo.seleniumlocators.exercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class MercadoLibreFinder {

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
    public void MercadoLibreFinder() throws InterruptedException {
        driver.get("https://www.mercadolibre.com.mx/");
        driver.manage().window().setSize(new Dimension(1661, 933));

        WebElement inputBox = driver.findElement(By.name("as_word"));
        inputBox.sendKeys("PS4");

        WebElement searchButton = driver.findElement(By.className("nav-search-btn"));
        searchButton.click();

        WebElement firstPrice = driver.findElement(By.className("price-tag-fraction"));
        System.out.println("First price = " + firstPrice.getText());

        WebElement firstLink = driver.findElement(By.className("ui-search-item__title"));
        firstLink.click();

        Thread.sleep(1000);
        //driver.close();
    }
}
