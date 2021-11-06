package com.qamindslab.moduletwo.seleniumlocators.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercadoLibreFinder {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(" https://www.mercadolibre.com.mx/");
        WebElement textBoxSearch = driver.findElement(By.name("as_word"));
        textBoxSearch.sendKeys("PS4");

        WebElement btnSearch = driver.findElement(By.className("nav-icon-search"));
        btnSearch.click();
        Thread.sleep(2000);
        WebElement resultSearch = driver.findElement(By.className("ui-search-price__second-line"));
        resultSearch.getText();
        Thread.sleep(2000);
        System.out.println("Price: "+resultSearch.getText());
        driver.close();
    }
}
