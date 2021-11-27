package com.qamindslab.moduletwo.advancecss.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CSSSelectorStrategy {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.espn.com.mx/");

        List<WebElement> articuloId = driver.findElements(By.cssSelector("article[id]"));

        for (WebElement articuloElement : articuloId) {
            System.out.println("Articulo con elemento ID: " + articuloElement.getText());
        }

        List<WebElement> articuloClassAttribute = driver.findElements(By.cssSelector("article[class='sub-module quicklinks']"));
        System.out.println("Articulos con atributo Class" + articuloClassAttribute.size());

        List<WebElement> elementoUserAccount = driver.findElements(By.cssSelector("*[class~='user-account-management']"));
        System.out.println("Elementos user-account-management: "+ elementoUserAccount.size());

        driver.close();

    }
}