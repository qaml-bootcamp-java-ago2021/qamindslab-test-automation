package com.qamindslab.moduletwo.seleniumlocators.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PortadaInWikipediaPartialLinks {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://es.wikipedia.org/wiki/Portada");

        WebElement busquedaTest = driver.findElement(By.linkText("portada"));
        System.out.println(busquedaTest.getText());
        System.out.println(busquedaTest.getAttribute("href"));


        List<WebElement>  links = driver.findElements(By.partialLinkText("Página"));
        for (WebElement product : links){
            System.out.println("paginas: "+product.getText());
            System.out.println(product.getAttribute("href"));
        }
        List<WebElement>  button = driver.findElements(By.tagName("Button"));
        for (WebElement product : button){
            System.out.println("button: "+product.getAttribute("title"));
        }

        driver.quit();

    }

}
