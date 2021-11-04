package com.qamindslab.moduletwo.seleniumlocators.example.locators;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsLinkTag {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        // Locator types.
        WebElement usernameTextBox = driver.findElement(By.id("user-name"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.name("password"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(5000);

        // Finding the 'PRODUCTS' title element through its tag name: 'span'
        WebElement productTitle = driver.findElement(By.tagName("span"));
        System.out.println(productTitle.getText());

        // Finding link elements that has a link text as 'Sauce Labs Backpack'
        WebElement backpack = driver.findElement(By.linkText("Sauce Labs Backpack"));
        System.out.println(backpack.getText());

        // Finding all link elements that contains a text 'Sauce Labs'.
        List<WebElement> productList = driver.findElements(By.partialLinkText("Sauce Labs"));
        for (WebElement product : productList){
            System.out.println(product.getText());
        }

        driver.quit();
    }
}
