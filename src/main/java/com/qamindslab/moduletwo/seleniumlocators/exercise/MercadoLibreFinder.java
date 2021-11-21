package com.qamindslab.moduletwo.seleniumlocators.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercadoLibreFinder {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.mercadolibre.com.mx");
        WebElement textboxSearch = driver.findElement(By.name("as_word"));
        textboxSearch.sendKeys("PS4");
        WebElement buttonSearch = driver.findElement(By.className("nav-search-btn"));
        buttonSearch.click();

        WebElement firstProduct = driver.findElement(By.className("ui-search-item__title"));
        firstProduct.click();

        Thread.sleep(10000);
        driver.quit();

    }
}
