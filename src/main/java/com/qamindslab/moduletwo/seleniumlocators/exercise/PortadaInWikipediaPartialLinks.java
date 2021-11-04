package com.qamindslab.moduletwo.seleniumlocators.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PortadaInWikipediaPartialLinks {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://es.wikipedia.org/wiki/Portada");
        WebElement txtPortada = driver.findElement(By.linkText("Portada"));
        System.out.println("The text Portada: "+txtPortada);

        String attributeHref = txtPortada.getAttribute("href");
        System.out.println("The attribute href: "+attributeHref);

        List<WebElement> linkTextPagina = driver.findElements(By.partialLinkText("Página"));
        System.out.println("the link partial text pagina"+linkTextPagina.size());
        for(int i = 0; i< linkTextPagina.size(); i++){
            WebElement elemento =linkTextPagina.get(i);
            System.out.println("The number "+ i +" that contain Página is: "+elemento.getText()+" and this is the href attribute"+elemento.getAttribute("href"));

        }

        List<WebElement> tagNameButton = driver.findElements(By.tagName("button"));

        for (int i = 0; i<tagNameButton.size(); i ++){
            WebElement text = tagNameButton.get(i);
            System.out.println("The text in the button is: "+text.getText());
        }
        driver.quit();
    }
}
