package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {
    public static void main(String [] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        System.out.println("Url google: " + driver.getCurrentUrl());
        tiempoDeCarga(driver, driver.getCurrentUrl());

        driver.navigate().to("https://www.facebook.com");
        System.out.println("Url Facebook: " + driver.getCurrentUrl());
        tiempoDeCarga(driver, driver.getCurrentUrl());

        driver.navigate().to("https://www.espn.com.mx/");
        System.out.println("Url ESPN: " + driver.getCurrentUrl());
        tiempoDeCarga(driver, driver.getCurrentUrl());

        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Retrocediendo: " + driver.getCurrentUrl());

        driver.navigate().forward();
        System.out.println("Avanzando: " + driver.getCurrentUrl());

        assert driver.getCurrentUrl().equals("https://www.facebook.com/") : "Revisa tu navegacion";

        driver.navigate().refresh();
        System.out.println("Refrescando: " + driver.getCurrentUrl());

        //driver.close();

    }
    public static void tiempoDeCarga(WebDriver driver, String url){
        long tiempoInicio;
        long tiempoFin;
        long tiempoTotal;
        tiempoInicio = System.nanoTime();
        driver.getCurrentUrl();
        tiempoFin = System.nanoTime();
        tiempoTotal = tiempoFin - tiempoInicio;
        System.out.println("Para cargar: " + driver.getCurrentUrl() + " toma: "  + tiempoTotal + "ns");
    }
}
