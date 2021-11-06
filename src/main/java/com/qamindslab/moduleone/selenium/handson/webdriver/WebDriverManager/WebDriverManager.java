/*package com.qamindslab.moduleone.selenium.handson.webdriver.WebDriverManager;

import java.io.File;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager{

    public static WebDriver getDriver(String browser){

        File rootPath = new File("src/main/resources");

            if(browser.toLowerCase(Locale.ROOT).equals("chrome")){
                File chromePath=new File(rootPath,"chromedriver.exe");
                System.setProperty("webdriver.chrome.driver",chromePath.getPath());
                return new ChromeDriver();
            }
            else if(browser.toLowerCase(Locale.ROOT).equals("firefox")){
                File firefoxPath=new File(rootPath,"geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", firefoxPath.getPath());
                return new FirefoxDriver();
            }
            else{
                return null;
            }
    }

}
*/