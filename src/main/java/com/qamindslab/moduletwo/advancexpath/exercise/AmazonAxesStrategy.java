package com.qamindslab.moduletwo.advancexpath.exercise;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonAxesStrategy {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://es.wikipedia.org/wiki/Selenium");

        List<WebElement> seleniumLinks = driver.findElements(By.xpath("//a[contains(text(), 'Selenium')]"));
        List<String> listOfLinks = new ArrayList<>();

        for (WebElement link : seleniumLinks) {
            listOfLinks.add(link.getAttribute("href"));
        }

        for (String link : listOfLinks) {
            driver.navigate().to(link);

            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("PAGE TITLE: " + driver.getTitle().toUpperCase());
            System.out.println("---------------------------------------------------------------------------------------");

            List<WebElement> aElementSiblings = driver.findElements(By.xpath("//body/descendant::a/following-sibling::*"));

            for (WebElement element : aElementSiblings) {
                System.out.println("Sibling text: " + element.getText());
            }
            driver.navigate().back();
        }

        driver.close();
    }
}
