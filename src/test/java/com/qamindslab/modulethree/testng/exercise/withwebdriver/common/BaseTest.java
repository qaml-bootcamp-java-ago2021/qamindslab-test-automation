package com.qamindslab.modulethree.testng.exercise.withwebdriver.common;

import com.qamindslab.modulethree.testng.example.withwebdriver.common.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Optional;

public class BaseTest {
    public WebDriver driver;

    public void setUp(@Optional("chrome") String browser) throws NotWebDriverImplementedException {
        driver =  getBrowser(browser);
        //driver.get("https://www.google.com/");

    }

    public static WebDriver getBrowser(String browser) throws NotWebDriverImplementedException {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            WebDriver driver = new ChromeDriver();
            return driver;
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("permissions.default.desktop-notification", 1);
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);

            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            return new FirefoxDriver(capabilities);
        }else{
            throw new NotWebDriverImplementedException("The web browser driver you're looking for is not yet implemented: " + browser);
        }
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
