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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AmazonChildrenOfHeadAndLinks {

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
    public void AmazonChildrenOfHeadAndLinks() throws InterruptedException, IOException {

        driver.get("https://www.amazon.com.mx/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> linkElements = driver.findElements(By.xpath("//a"));
        for (int i = 0; i < linkElements.size(); i++) {
            if(linkElements.get(i).getAttribute("href") != null){
                System.out.println("Link is " + linkElements.get(i).getAttribute("href"));
            }
        }

        List<WebElement> childHeadElements = driver.findElements(By.xpath("//head/*"));
        for (int i = 0; i < childHeadElements.size(); i++) {
            if(childHeadElements.get(i).getAttribute("text") != null){
                System.out.println("Head child is " + childHeadElements.get(i).getAttribute("innerHTML"));
            }
        }

        Thread.sleep(1000);

        driver.close();
    }

}
