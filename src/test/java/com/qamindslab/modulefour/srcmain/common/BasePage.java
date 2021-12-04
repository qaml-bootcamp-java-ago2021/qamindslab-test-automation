package com.qamindslab.modulefour.srcmain.common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected String baseUrl;
    protected final Logger logger = LogManager.getLogger(com.qamindslab.modulethree.pom.example.googlesearch.srcmain.common.BasePage.class);

    public BasePage(WebDriver driver, String baseUrl){
        this.driver = driver;
        this.baseUrl = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        logger.info("Getting url: " + this.baseUrl);
        this.driver.get(this.baseUrl);
        this.driver.manage().window().maximize();
        logger.info("Got: " + this.driver.getCurrentUrl());
    }

    public boolean isLoaded(){
        return false;
    }

    public void close(){
        logger.info("Closing " + this.getClass().toString());
        this.driver.close();
        logger.info(this.getClass().toString() + " closed.");
    }
    public boolean isEnabled(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public String getElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public void clickOnElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}
