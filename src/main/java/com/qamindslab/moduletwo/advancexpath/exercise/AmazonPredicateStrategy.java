package com.qamindslab.moduletwo.advancexpath.exercise;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AmazonPredicateStrategy {
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
    public void AmazonPredicateStrategy() throws InterruptedException, IOException {

        driver.get("https://www.amazon.com.mx/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement firstDiv = driver.findElement(By.xpath("//body/div[1]"));
        System.out.println("First div's text is " + firstDiv.getText());

        WebElement lastDiv = driver.findElement(By.xpath("//body/div[last()]"));
        System.out.println("Last div's text is " + firstDiv.getText());

        WebElement navigationElement = driver.findElement(By.xpath("//*[@role='navigation']"));
        System.out.println("navigationElement text is " + navigationElement.getText());

        WebElement navElement = driver.findElement(By.xpath("/*[contains(@class, 'nav')]"));
        System.out.println("navElement text is " + navElement.getText());

        WebElement submitElement = driver.findElement(By.xpath("//*[@type='submit'][contains(@class, 'nav-input')]"));
        System.out.println("navElement text is " + submitElement.getText());

        Thread.sleep(1000);

        driver.close();
    }
}
