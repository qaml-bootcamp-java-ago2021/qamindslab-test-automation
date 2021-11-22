package com.qamindslab.moduleone.selenium.handson.challenge;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Hands On #6: Challenge 2 - Visit Selenium Hyperlinks in Wikipedia
public class WikipediaSeleniumHyperlinksVisitor {


    public static void main(String[] args) throws InterruptedException{
         WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://es.wikipedia.org/");

        WebElement search = driver.findElement(By.id("searchInput"));
        search.sendKeys("Selenium");

        List<WebElement> elemnt= driver.findElements(By.tagName("p"));
        System.out.println("p "+elemnt.size());
        System.out.println(driver.getCurrentUrl());

        List<WebElement> elemnta=  driver.findElements(By.tagName("a"));
        List<String> Links =new ArrayList<String>();
        for(int i=0;i<elemnta.size();i++){
            if((elemnta.get(i).getAttribute("href"))!=null){
            if(!elemnta.get(i).getAttribute("href").contains("wikipedia")){
                System.out.println(elemnta.get(i).getAttribute("href"));
                Links.add(elemnta.get(i).getAttribute("href"));
            }
            }
        }
        System.out.println(Links.size());
        for(int i=0;i<Links.size();i++){
            driver.navigate().to(Links.get(i));
        }
        Thread.sleep(5000);
        driver.close();

    }
}
