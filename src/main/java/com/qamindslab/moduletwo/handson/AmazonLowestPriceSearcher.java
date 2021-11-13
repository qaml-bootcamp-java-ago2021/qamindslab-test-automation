package com.qamindslab.moduletwo.handson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonLowestPriceSearcher {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.mx/");
        WebElement inputSearch = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement buttonSearch = driver.findElement(By.cssSelector("#nav-search-submit-button"));
        inputSearch.sendKeys("Nintendo Switch");
        buttonSearch.click();
        Thread.sleep(1000);
        WebElement nintendoMarcaCheckbox = driver.findElement(By.xpath("//*[@id='p_89/Nintendo']//i"));
        nintendoMarcaCheckbox.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.close();
    }
}
