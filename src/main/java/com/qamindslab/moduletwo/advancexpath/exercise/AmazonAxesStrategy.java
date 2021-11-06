package com.qamindslab.moduletwo.advancexpath.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAxesStrategy {
    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.mx/");
        WebElement firstDiv = driver.findElement(By.xpath("//body/div[1]"));
        System.out.println("First Div"+ firstDiv.getText());
        WebElement lastDiv = driver.findElement(By.xpath("//body/div[last()]"));
        System.out.println("Last Div"+ lastDiv.getText());
        WebElement roleNavigation = driver.findElement(By.xpath("//*[@role='navigation']"));
        System.out.println("attribute role with text navigation: "+ roleNavigation.getText());
        WebElement classContainNav = driver.findElement(By.xpath("//*[contains(@class,'nav')]"));
        System.out.println("class attribute Contains Nav: "+ classContainNav .getText());
        WebElement attributeSubmitClassAttNavInput = driver.findElement(By.xpath("//*[@type='submit'][contains(@class, 'nav-input')]"));
        System.out.println("submit attribute Contains Nav-input "+ classContainNav .getText());
        driver.close();

    }
}
