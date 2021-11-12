package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {
    public static void main(String [] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        System.out.println("Url google: " + driver.getCurrentUrl());

        driver.navigate().to("https://www.facebook.com");
        System.out.println("Url Facebook: " + driver.getCurrentUrl());

        driver.navigate().to("https://www.espn.com.mx/");
        System.out.println("Url ESPN: " + driver.getCurrentUrl());

        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Retrocediendo: " + driver.getCurrentUrl());

        driver.navigate().forward();
        System.out.println("Avanzando: " + driver.getCurrentUrl());
        
        
        driver.navigate().refresh();
        System.out.println("Refrescando: " + driver.getCurrentUrl());

        //driver.close();

    }
}
