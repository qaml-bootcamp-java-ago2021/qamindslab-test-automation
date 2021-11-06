package com.qamindslab.playground;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

// https://www.browserstack.com/guide/drag-and-drop-in-selenium
public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://formy-project.herokuapp.com/dragdrop");

        WebElement fromElement = driver.findElement(By.tagName("img"));
        WebElement toElement = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);

        Thread.sleep(5000);

        Action dragAndDrop = actions.clickAndHold(fromElement)
                .moveToElement(toElement)
                .build();

        dragAndDrop.perform();

        Thread.sleep(2000);

        driver.navigate().refresh();
        fromElement = driver.findElement(By.tagName("img"));
        toElement = driver.findElement(By.id("box"));

        actions.dragAndDrop(fromElement, toElement)
                .build()
                .perform();

    }
}
