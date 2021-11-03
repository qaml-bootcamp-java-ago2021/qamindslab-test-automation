package com.qamindslab.moduleone.selenium.example.webdriver.instance;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.WebDriverManager;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.NotWebDriverImplementedException;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import org.openqa.selenium.WebDriver;


public class ChromeInstance {

        public static void main(String[] args) throws NotWebDriverImplementedException {
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
      //  WebDriver driver = new ChromeDriver();

        //WebDriver driver = WebDriverManager.getDriver(Browser.CHROME);

        ChromeBrowserDriver instanceDriver = new ChromeBrowserDriver();
       // WebDriver driver = WebDriverManager.getBrowserInstance(instanceDriver);
       // driver.get("https://www.google.com");
    }
}
