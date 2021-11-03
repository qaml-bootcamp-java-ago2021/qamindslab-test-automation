package com.qamindslab.moduleone.selenium.exercise.webdriver.commonmethods.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagsFrequencyCount {
    public static void main(String [] argas) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        String pageSource = driver.getPageSource();
        String[] functionWord =  pageSource.split("function");
        String[] scriptWord = pageSource.split("script");
        String[] classWord = pageSource.split("class");
        String[] idWord = pageSource.split("id");
        System.out.println("Function quantities is: "+functionWord.length);
        System.out.println("Script word quantities is: "+scriptWord.length);
        System.out.println("Class word quantities is: "+classWord.length);
        System.out.println("Id word quantities is: "+idWord.length);
        driver.close();
    }
}
