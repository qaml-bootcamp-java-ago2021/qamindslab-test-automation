package com.qamindslab.moduleone.selenium.handson.acton;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

// Hands On #3 - Login into Facebook
public class FacebookSessionCreator {
    public static void main(String[] args) throws InterruptedException {
        // Create ChromeDriver instance.
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        // Maximize the browser window.
        driver.manage().window().maximize();
        // Give 10 seconds to the page to be loaded.
        driver.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);
        // Load Facebook page.
        driver.get("https://www.facebook.com/");

        // Find Email text box and place the user email. *Change for a real facebook email account.
        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.sendKeys("email@email.com");

        // Find Password text box and enter the password. *Change for a valid password.
        WebElement passwordTextBox = driver.findElement(By.id("pass"));
        passwordTextBox.sendKeys("12345");

        // Clicking on the login button.
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        // Wait for 10 seconds.
        Thread.sleep(10000);

        // Quit WebDriver.
        driver.quit();
    }
}
