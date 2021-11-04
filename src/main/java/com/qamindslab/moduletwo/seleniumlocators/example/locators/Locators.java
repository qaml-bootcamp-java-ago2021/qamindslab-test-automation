package com.qamindslab.moduletwo.seleniumlocators.example.locators;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {
    public final static String CHROME_DRIVER = "webdriver.chrome.driver";
    public final static String CHROME_DRIVER_PATH = "src/main/resources/chromedriver";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);

        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());

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

        driver.quit();
    }
}
