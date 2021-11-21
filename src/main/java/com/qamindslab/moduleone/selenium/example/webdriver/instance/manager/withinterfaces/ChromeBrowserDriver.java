package com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserDriver implements BrowserDriver{
    @Override
    public WebDriver getInstanceBrowserDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    }
}
