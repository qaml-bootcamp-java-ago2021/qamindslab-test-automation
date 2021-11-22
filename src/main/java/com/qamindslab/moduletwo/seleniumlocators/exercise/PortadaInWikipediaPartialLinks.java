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
        driver.manage().window().maximize();

        driver.get("https://es.wikipedia.org/wiki/Portada");
        WebElement linkPortada = driver.findElement(By.linkText("Portada"));
        System.out.println("href: "+ linkPortada.getAttribute("href"));

        List<WebElement> listaPagina = driver.findElements(By.partialLinkText("Pagina"));
        for (WebElement lista : listaPagina){
            System.out.println(lista.getAttribute("href"));
        }
        List<WebElement> listaBoton = driver.findElements(By.tagName("button"));
        for (WebElement lista : listaBoton){
            System.out.println(lista.getAttribute("title"));
        }
    }
}