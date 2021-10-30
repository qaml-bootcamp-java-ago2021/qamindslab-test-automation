package com.qamindslab.moduleone.selenium.handson.challenge;

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

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Hands On #5: Challenge 1 - Search on QAMinds in Facebook.
public class QAMindsFacebookFinder {
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
    public void QAMindsFacebookFinder() throws InterruptedException, IOException {

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("jesk801@hotmail.com");

        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys(readFile("/home/serrano/pass.txt",  StandardCharsets.US_ASCII));

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        Thread.sleep(20000);
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@type = 'search']"));
        searchTextBox.sendKeys("QA Mindas\n");

        Thread.sleep(10000);

        driver.close();
    }

    private  String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding).replaceAll("\\r|\\n", "");
    }

}
