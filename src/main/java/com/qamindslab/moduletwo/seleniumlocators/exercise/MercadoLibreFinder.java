package com.qamindslab.moduletwo.seleniumlocators.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercadoLibreFinder {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.mx/");

        WebElement busquedaTestBox = driver.findElement(By.name("as_word"));
        busquedaTestBox.sendKeys("PSP 4");

        WebElement button= driver.findElement(By.className("nav-search-btn"));
        button.click();

        WebElement price= driver.findElement(By.className("price-tag-fraction"));
        price.getText();

        WebElement link= driver.findElement(By.className("ui-search-item__title"));
        link.click();

        Thread.sleep(5000);

    }

}
