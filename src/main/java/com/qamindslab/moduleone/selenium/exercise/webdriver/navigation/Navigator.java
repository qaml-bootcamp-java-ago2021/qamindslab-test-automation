package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {

    public static void main(String [] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://es.wikipedia.org/wiki/The_Animatrix");
        driver.navigate().to("https://www.casadellibro.com/libros-ebooks/gabriel-garcia-marquez/20092");

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


    }
}
