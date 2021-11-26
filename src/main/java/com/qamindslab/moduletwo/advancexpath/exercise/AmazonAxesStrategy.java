package com.qamindslab.moduletwo.advancexpath.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonAxesStrategy {
    public static void main(String [] args){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://es.wikipedia.org/wiki/Selenium");

        List<WebElement> seleniumLinks = driver.findElements(By.xpath("//a[contains(text(), 'Selenium')]"));
        List<String> listOfLinks = new ArrayList<>();

        for (WebElement link : seleniumLinks) {
            listOfLinks.add(link.getAttribute("href"));
        }

        for (String link : listOfLinks) {
            driver.navigate().to(link);


            System.out.println("Título: " + driver.getTitle().toUpperCase());

            List<WebElement> aElementSiblings = driver.findElements(By.xpath("//body/descendant::a/following-sibling::*"));

            for (WebElement element : aElementSiblings) {
                System.out.println("Sibling text: " + element.getText());
            }
            driver.navigate().back();
        }

    }
}
