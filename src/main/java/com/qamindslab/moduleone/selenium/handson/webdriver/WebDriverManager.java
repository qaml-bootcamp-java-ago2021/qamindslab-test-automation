package com.qamindslab.moduleone.selenium.handson.webdriver;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.NotWebDriverImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Locale;

// Hands On #1 - GetCorrectWebDriver
public class WebDriverManager {

    public static WebDriver getDriver(String browser) throws NotWebDriverImplementedException {
        File rootPath = new File("src/main/resources");
        if (browser.toLowerCase(Locale.ROOT).equals("chrome")) {
            File chromeFilePath = new File(rootPath, "chromedriver.exe");

            System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
            return new ChromeDriver();
        } else if (browser.toLowerCase(Locale.ROOT).equals("firefox")) {
            File firefoxFilePath = new File(rootPath, "geckodriver");

            System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
            return new FirefoxDriver();
        } else {
            return null;
        }
    }


}
