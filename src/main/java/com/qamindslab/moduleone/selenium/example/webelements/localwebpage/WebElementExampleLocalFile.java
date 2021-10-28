package com.qamindslab.moduleone.selenium.example.webelements.localwebpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementExampleLocalFile {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        // Change the file url,to your actual directory path.
        driver.get("file:///home/marcodejesus/IdeaProjects/BPA-Agosto2021/qamindslab-test-automation/src/main/java/com/qamindslab/moduleone/selenium/example/webelements/localwebpage/index.html");

        WebElement extraContent = driver.findElement(By.id("Element ID"));

        System.out.println(extraContent.getText());

        driver.quit();
    }
}
