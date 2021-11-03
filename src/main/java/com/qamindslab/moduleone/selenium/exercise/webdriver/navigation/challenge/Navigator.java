package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.sunat.gob.pe");
        System.out.println("Right now I am in the web sunat webpage: "+ driver.getTitle());

        driver.navigate().back();
        System.out.println("Rigth now I am in the main google page: "+driver.getTitle());

        driver.navigate().forward();
        System.out.println("Right now I am in the web sunat page again with forwads :"+driver.getTitle());
        driver.navigate().refresh();
        driver.quit();
    }
}
