package com.qamindslab.modulethree.testng.example.withwebdriver;

import com.qamindslab.modulethree.testng.example.withwebdriver.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestNGWithWebDriver extends BaseTest {
    @Test(description = "Open google page", alwaysRun = true, groups= {"regression"})
    @Parameters({"baseUrl"})
    public void openGoogle(@Optional("https://www.google.l2/") String baseUrl){
        driver.get("https://www.google.com.mx/");
        assertEquals(driver.getCurrentUrl(), baseUrl, "Didn't get expected google url");
    }

    @Test(description = "Search selenium in google search box",
            dependsOnMethods = {"openGoogle"}, groups = {"regression"})
    public void searchSelenium(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.sendKeys(Keys.ENTER);

        List<WebElement> results = driver.findElements(By.xpath("//h3[contains(@class, 'LC20lb')]"));

        assertTrue(results.size() > 0, "Didn't get any results");
    }
}