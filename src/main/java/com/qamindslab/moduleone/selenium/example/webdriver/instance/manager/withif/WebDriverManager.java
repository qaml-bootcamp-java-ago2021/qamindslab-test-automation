package com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Locale;

public class WebDriverManager {

    public static WebDriver getDriver(Browser browser) throws NotWebDriverImplementedException {
        File rootPath = new File("src/main/resources");
        WebDriver driver;

        switch (browser){
            case FIREFOX:
                File firefoxFilePath = new File(rootPath, "geckodriver");

                System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
                driver = new FirefoxDriver();
                break;
            case CHROME:
                File chromeFilePath = new File(rootPath, "chromedriver");

                System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
                driver = new ChromeDriver();
                break;
            default:
                throw new NotWebDriverImplementedException("Sorry, the WebDriver you're looking for is not yet implemented.");
        }

        return driver;
    }
}
