package com.qamindslab.moduleone.selenium.example.webdriver.instance;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.Browser;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.NotWebDriverImplementedException;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class FirefoxInstance {
    public static void main(String[] args) throws NotWebDriverImplementedException {
        /*
        File rootPath = new File("src/main/resources");
        File firefoxFilePath = new File(rootPath,"geckodriver.exe");

        System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());

/*<<<<<<< HEAD*/
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.youtube.com");
        driver.quit();
        /*
=======*/
        //WebDriver driver = new FirefoxDriver();

        //WebDriver driver = WebDriverManager.getDriver(Browser.FIREFOX);

        //driver.get("https://www.google.com");
//>>>>>>> main
    }
}
