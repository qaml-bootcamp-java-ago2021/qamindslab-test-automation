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
        driver.manage().window().maximize();

        driver.get("https://www.nasa.gov");
        WebElement linkMission = driver.findElement(By.linkText("Missions"));
        System.out.println("href "+ linkMission.getAttribute("href"));

        WebElement linkTV = driver.findElement(By.linkText("NASA TV"));
        System.out.println("href "+ linkTV.getAttribute("href"));

        List<WebElement> listaInput = driver.findElements(By.tagName("input"));
        for (WebElement lista : listaInput){
            System.out.println(lista.getAttribute("value"));
        }

    }
}