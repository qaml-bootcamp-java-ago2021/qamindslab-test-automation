package com.qamindslab.moduletwo.seleniumlocators.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NASAHyperlinksFinder {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nasa.gov/");
        WebElement linkTexMission = driver.findElement(By.linkText("Missions"));

        String hrefAttribute = linkTexMission.getAttribute("href");
        System.out.println("Missins attribure"+hrefAttribute);
        WebElement linkTexNasaTv = driver.findElement(By.linkText("NASA TV"));

        String hrefAttributeNasaTv = linkTexMission.getAttribute("href");
        System.out.println("NASA TV attribure"+hrefAttributeNasaTv);

        driver.close();
    }

}
