package com.qamindslab.moduletwo.seleniumlocators.exercise;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.NotWebDriverImplementedException;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MercadoLibreFinder {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.get("https://www.mercadolibre.com.mx/");

        WebElement searchBox = driver.findElement(By.name("as_word"));
        searchBox.sendKeys("PS4");

        WebElement searchButton = driver.findElement(By.className("nav-search-btn"));
        searchButton.click();

        WebElement firstResult = driver.findElements(By.className("ui-search-item__title")).get(0);
        firstResult.click();

        driver.quit();
    }
}
