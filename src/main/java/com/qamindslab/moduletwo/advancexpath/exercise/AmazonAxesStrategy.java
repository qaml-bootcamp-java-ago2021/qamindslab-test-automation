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
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://es.wikipedia.org/wiki/Selenium");
        List<WebElement> elemnt = driver.findElements(By.xpath("//a[contains(text(),'Selenium')]"));
        List <String> list =new ArrayList<>();
        for(WebElement hiperlinks:elemnt){
          list.add(hiperlinks.getAttribute("href"));
        }

        for(String links:list){
            driver.navigate().to(links);
            System.out.println(driver.getTitle().toUpperCase());
            List<WebElement> elemntdes = driver.findElements(By.xpath("//body/descendant::a/following-sibling::*"));
            for(WebElement link :elemntdes){
                System.out.println(link.getText());

            }
            driver.navigate().back();
        }

        driver.close();
    }
}
