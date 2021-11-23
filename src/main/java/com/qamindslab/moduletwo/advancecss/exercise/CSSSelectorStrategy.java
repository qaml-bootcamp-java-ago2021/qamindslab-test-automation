package com.qamindslab.moduletwo.advancecss.exercise;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CSSSelectorStrategy {

    public static void main(String[] args)  {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.espn.com.mx/");
        List<WebElement> elemnt = driver.findElements(By.cssSelector("article[id]"));
        for(WebElement link :elemnt){
            System.out.println("Article"+link.getText());

        }
        List<WebElement> elemntclass = driver.findElements(By.cssSelector("article[class='sub-module quicklinks']"));
        System.out.println("elementos class"+elemntclass.size());
        List<WebElement> elemntclassuser = driver.findElements(By.cssSelector("*[class~='user-account-managment']"));
        System.out.println("elementos class"+elemntclassuser.size());

        driver.close();
    }


}
