package com.qamindslab.moduletwo.advancexpath.exercise;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AmazonPredicateStrategy {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");

        WebElement primerDiv = driver.findElement(By.xpath("//body/div[1]"));
        System.out.println("Primer div" + primerDiv.getText());

        WebElement ultimoDiv = driver.findElement(By.xpath("//body/div[last()]"));
        System.out.println("Último div" + ultimoDiv.getText());

        WebElement roleNavigation = driver.findElement(By.xpath("//*[@role='navigation']"));
        System.out.println("Role Navigation: " + roleNavigation.getText());

        WebElement classNav = driver.findElement(By.xpath("*[contains(@class, 'nav')]"));
        System.out.println("Class Navigation: " + classNav.getText());

        WebElement atributoType = driver.findElement(By.xpath("//*[@type='submit'][contains(@class, 'nav-input')]"));
        System.out.println("Type Attribute: " + atributoType.getText());

        Thread.sleep(10000);
        driver.quit();
    }
}

