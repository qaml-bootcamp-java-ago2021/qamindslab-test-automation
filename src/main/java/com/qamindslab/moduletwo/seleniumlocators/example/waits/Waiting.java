package com.qamindslab.moduletwo.seleniumlocators.example.waits;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

// https://www.selenium.dev/documentation/webdriver/waits/
// https://www.selenium.dev/selenium/docs/api/java/index.html?index-all.html
public class Waiting {
    public static void main(String[] args) {
        //WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("D:\\HandsonQA\\Proyecto\\qamindslab-test-automation\\src\\main\\java\\com\\qamindslab\\moduletwo\\seleniumlocators\\example\\waits\\index.html");

        // Maximize the browser window.
        driver.manage().window().maximize();
        // Waiting time for the web page to be loaded.
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        // Implicitly Waiting time for elements to be on the web page.
        // https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html#implicitlyWait(long,java.util.concurrent.TimeUnit)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement pTag1 = driver.findElement(By.tagName("p"));
        System.out.println(pTag1.getText());

/*
        // Explicitly Waiting time for elements to be on the web page.
        // https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/WebDriverWait.html
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement pTag2 = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("p")));
        System.out.println(pTag2.getText());

        // Fluent Waiting time for elements to be on the web page.
        // https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        // With lambda expression.
        WebElement pTag3 = fluentWait.until(driver1 -> driver1.findElement(By.tagName("p")));
        /*
        WebElement pTag3 = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.tagName("p"));
            }
        });
        System.out.println(pTag3.getText());
        */
    }
}

