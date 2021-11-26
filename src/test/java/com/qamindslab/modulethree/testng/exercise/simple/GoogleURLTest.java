package com.qamindslab.modulethree.testng.exercise.simple;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleURLTest {


    @Test
    public void googleurl(){
        String Google="https://www.google.com.mx/";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.mx/");
        String url=driver.getCurrentUrl();

        Assert.assertEquals(url, Google, "Url Incorrecta");


}
}
