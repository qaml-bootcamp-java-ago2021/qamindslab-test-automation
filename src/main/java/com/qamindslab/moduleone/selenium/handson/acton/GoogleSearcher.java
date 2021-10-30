package com.qamindslab.moduleone.selenium.handson.acton;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.Browser;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.NotWebDriverImplementedException;
import com.qamindslab.moduleone.selenium.handson.webdriver.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Hands On #2 - Search something in Google.
public class GoogleSearcher {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() throws NotWebDriverImplementedException {
        driver = WebDriverManager.getDriver(Browser.CHROME);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void GoogleSearcher() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        assert (driver.getCurrentUrl().equals("https://www.google.com/")) : "No nos encontramos en facebook: " + driver.getCurrentUrl() ;

        //System.out.println("Get tittle = " + driver.getTitle());

        WebElement queryElement = driver.findElement(By.name("q"));
        queryElement.sendKeys("Selenium" + "\n");
        Thread.sleep(5000);
        driver.close();
    }
}
