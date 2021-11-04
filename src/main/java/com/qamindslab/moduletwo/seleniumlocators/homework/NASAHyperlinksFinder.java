package com.qamindslab.moduletwo.seleniumlocators.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NASAHyperlinksFinder {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nasa.gov/");

        WebElement busquedaTest = driver.findElement(By.linkText("Missions"));
        System.out.println("Text "+busquedaTest.getText());
        System.out.println("href "+busquedaTest.getAttribute("href"));

        WebElement nassa = driver.findElement(By.linkText("NASA TV"));
        System.out.println("Text "+nassa.getText());
        System.out.println("href "+nassa.getAttribute("href"));

        List<WebElement>  names = driver.findElements(By.tagName("input"));
        for (WebElement product : names){
            System.out.println("input: "+product.getAttribute("value"));
        }

        driver.quit();

    }

}
