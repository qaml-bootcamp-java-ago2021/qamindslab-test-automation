package com.qamindslab.moduletwo.advancexpath.exercise;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonChildrenOfHeadAndLinks {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");

        List<WebElement> allHyperlinks = driver.findElements(By.xpath("//a"));

        System.out.println("ALL HYPERLINKS TEXT: ");
        for (WebElement hyperlink : allHyperlinks) {
            System.out.println(hyperlink.getText());
        }

        List<WebElement> allChildElementsOfHead = driver.findElements(By.xpath("//head/*"));

        System.out.println("ALL CHILD ELEMENTS CONTENT: ");
        for (WebElement child : allChildElementsOfHead) {
            System.out.println(child.getAttribute("innerHTML"));
        }

        Thread.sleep(10000);

        driver.close();
    }
}
