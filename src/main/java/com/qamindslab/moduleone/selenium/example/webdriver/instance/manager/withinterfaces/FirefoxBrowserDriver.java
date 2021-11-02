package com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserDriver implements BrowserDriver{
    @Override
    public WebDriver getInstanceBrowserDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        return new FirefoxDriver();
    }
}
