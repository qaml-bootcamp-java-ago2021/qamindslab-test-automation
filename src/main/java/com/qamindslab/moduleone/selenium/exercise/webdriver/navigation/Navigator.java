package com.qamindslab.moduleone.selenium.exercise.webdriver.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String urlGoogle = driver.getCurrentUrl();
        System.out.println("The current url should be google: "+urlGoogle);

        driver.navigate().to("https://es-la.facebook.com/");
        String facebookURl = driver.getCurrentUrl();
        System.out.println("I am in facebook the current url is: "+facebookURl);

        driver.navigate().to("https://www.espn.com.pe");
        System.out.println("I am in the espn the current url is: "+driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().back();
        //System.out.println("I did back twice and now I am in google page the url is: "+driver.getCurrentUrl());
        assert facebookURl.equals(urlGoogle);
        driver.navigate().refresh();
        System.out.println("I did back twice and now I am in google page the url is: "+driver.getCurrentUrl());
        driver.close();

    }
}
