package com.qamindslab.moduletwo.advancecss.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CSSSelectorStrategy {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.espn.com.mx/");
        List<WebElement> articleId = driver.findElements(By.cssSelector("article, id"));
        System.out.println("Quantiry arctiles with id: "+ articleId.size());
        for ( WebElement articleIdElement: articleId) {
            //articleId.getText();
            System.out.println(articleIdElement.getText());
        }
        driver.close();
    }
}
