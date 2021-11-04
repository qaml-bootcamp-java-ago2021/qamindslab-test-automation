package com.qamindslab.moduletwo.seleniumlocators.example.locators;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

        // Finding link elements that has a link text as 'Sauce Labs Backpack'

        // Finding all link elements that contains a text 'Sauce Labs'.

        driver.quit();
    }
}
