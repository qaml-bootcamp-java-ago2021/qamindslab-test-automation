package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("GET: "+driver.getCurrentUrl());

        driver.close();
    }
}
