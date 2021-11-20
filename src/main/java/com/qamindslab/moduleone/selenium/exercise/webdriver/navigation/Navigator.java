package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("URL Google: "+driver.getCurrentUrl());
        driver.navigate().to("https://www.facebook.com/");
        System.out.println("URL Facebook"+driver.getCurrentUrl());
        driver.navigate().to("https://www.espn.com.mx/");
        System.out.println("URL ESPN"+driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("back"+driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println("forward"+driver.getCurrentUrl());
        assert driver.getCurrentUrl().equals("https://www.facebook.com/"):"incorrecto";
        driver.navigate().refresh();
        System.out.println("refresh"+driver.getCurrentUrl());
        driver.close();
    }

}
