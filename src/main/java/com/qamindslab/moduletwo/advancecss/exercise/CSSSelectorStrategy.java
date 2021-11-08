package com.qamindslab.moduletwo.advancecss.exercise;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CSSSelectorStrategy {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.espn.com.mx/");

        List<WebElement> articleElementsWithAttributeId = driver.findElements(By.cssSelector("article[id]"));

        for (WebElement articleElement : articleElementsWithAttributeId) {
            System.out.println("ARTICLE ELEMENTS WITH ATTRIBUTE ID: " + articleElement.getText());
        }

        List<WebElement> articleElementsWithClassAttribute = driver.findElements(By.cssSelector("article[class='sub-module quicklinks']"));
        System.out.println("NUMBER OF ");
        System.out.println("ARTICLE ELEMENTS WITH ATTRIBUTE CLASS = 'sub-module quicklinks': " + articleElementsWithClassAttribute.size());

        // "*[class*='user-account-management']"
        List<WebElement> anyElementContainingUserAccountManagement = driver.findElements(By.cssSelector("*[class~='user-account-management']"));
        System.out.println("NUMBER OF");
        System.out.println("ANY ELEMENT CONTAINING THE WORD user-account-management: "+ anyElementContainingUserAccountManagement.size());

        driver.close();
    }
}
