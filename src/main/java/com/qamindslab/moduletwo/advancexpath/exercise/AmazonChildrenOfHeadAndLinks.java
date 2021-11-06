package com.qamindslab.moduletwo.advancexpath.exercise;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonChildrenOfHeadAndLinks {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.mx/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> allA = driver.findElements(By.xpath("//a"));
        System.out.println("Quantity: "+allA.size());
        for (int i=0; i < allA.size(); i++){
            System.out.println(allA.get(i));
        }

        List<WebElement> elementHead = driver.findElements(By.xpath("//head/*"));
        System.out.println("zise heads: "+elementHead.size());
        for (int i=0; i<elementHead.size(); i++){
            System.out.println(elementHead.get(i).getAttribute("innerHTML"));
        }
        driver.close();
    }
}
