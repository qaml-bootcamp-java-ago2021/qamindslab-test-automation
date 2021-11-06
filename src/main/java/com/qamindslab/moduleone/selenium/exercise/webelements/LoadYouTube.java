package com.qamindslab.moduleone.selenium.exercise.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadYouTube {
    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.youtube.com/");
        //driver.qui();
    }
}
