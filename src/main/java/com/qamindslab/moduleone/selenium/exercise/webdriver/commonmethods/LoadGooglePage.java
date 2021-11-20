package com.qamindslab.moduleone.selenium.exercise.webdriver.commonmethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadGooglePage {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Titulo: "+driver.getTitle());
        System.out.println("URL: "+driver.getCurrentUrl());
        System.out.println("Soruce: "+driver.getPageSource());
        driver.close();
    }

}
