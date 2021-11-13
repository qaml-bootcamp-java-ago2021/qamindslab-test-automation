package com.qamindslab.modulethree.pom.example.googlesignin.srcmain.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected String baseUrl;

    public BasePage(WebDriver driver, String baseUrl){
        this.driver = driver;
        this.baseUrl = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        this.driver.get(this.baseUrl);
        this.driver.manage().window().maximize();
    }

    public boolean isLoaded(){
        return false;
    }

    public void close(){
        this.driver.close();
    }
}
