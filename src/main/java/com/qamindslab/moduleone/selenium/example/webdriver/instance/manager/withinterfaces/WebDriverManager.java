package com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    public static WebDriver getBrowserInstance(BrowserDriver driver){
        return driver.getInstanceBrowserDriver();
    }




}

