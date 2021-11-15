package com.qamindslab.moduleone.selenium.handson.webdriver;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.Browser;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.NotWebDriverImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Locale;

// Hands On #1 - GetCorrectWebDriver
public class WebDriverManager {
    
    public static WebDriver getDriver(Browser browser) throws NotWebDriverImplementedException{
        File rootPath = new File ("src/main/resources");
        WebDriver driver;

        switch(browser){
            case FIREFOX:
                File firefoxFilePath = new File (rootPath, "geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
                driver = new FirefoxDriver();
                break;

            case CHROME:
                File chromeFilePath = new File (rootPath, "chromedriver");
                System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
                driver = new ChromeDriver();
                break;

            default:
                throw new NotWebDriverImplementedException("Webdriver not implemented");
        }

/*
        if(browser.toLowerCase(Locale.ROOT).equals("chrome")){
            File chromeFilePath = new File (rootPath, "chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
            return new ChromeDriver();
        }
        else if (browser.toLowerCase(Locale.ROOT).equals("firefox")){
            File firefoxFilePath = new File (rootPath, "geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
            return new FirefoxDriver();
        }
        else{
            throw new NotWebDriverImplementedException("Webdriver not implemented");
        }

 */
    return null;
    }
    
}
