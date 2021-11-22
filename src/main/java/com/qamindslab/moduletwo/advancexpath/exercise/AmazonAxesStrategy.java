package com.qamindslab.moduletwo.advancexpath.exercise;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AmazonAxesStrategy {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");
        WebElement div = driver.findElement(By.xpath("//body/div[1]"));
            System.out.println("body/div: "+div.getText());
        WebElement bodydivl = driver.findElement(By.xpath("//body/div[last()]"));
        System.out.println("Last: "+bodydivl.getText());
        WebElement nav = driver.findElement(By.xpath("//*[@role='navigation']"));
        System.out.println("navigator: "+nav.getText());
        WebElement clas = driver.findElement(By.xpath("//*[contains(@class,'nav')]"));
        System.out.println("Class: "+clas.getText());
        WebElement submit = driver.findElement(By.xpath("//*[@type='submit'][contains(@class,'nav-input')]"));
        System.out.println("sumbit: "+submit.getText());

        Thread.sleep(10000);
        driver.close();
    }
}
