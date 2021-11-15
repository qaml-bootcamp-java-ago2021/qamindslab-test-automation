package com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif;

import org.openqa.selenium.WebDriver;

public class NotWebDriverImplementedException extends Exception{
    public NotWebDriverImplementedException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
