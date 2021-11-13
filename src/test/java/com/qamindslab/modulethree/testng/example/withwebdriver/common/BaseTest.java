package com.qamindslab.modulethree.testng.example.withwebdriver.common;

import com.qamindslab.modulethree.testng.example.withwebdriver.common.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser){
        try{
            driver = getDriver(browser);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch (NotWebDriverImplementedException e){
            e.printStackTrace();
        }
    }

    private static WebDriver getDriver(String browser) throws NotWebDriverImplementedException {

        if(browser.equalsIgnoreCase("chrome")){
            Map<String, Object> prefs = new HashMap<>();

            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            return new ChromeDriver(options);

        }else if (browser.equalsIgnoreCase("firefox")){
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
