package com.qamindslab.moduletwo.seleniumlocators.homework;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NASAHyperlinksFinder {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.get("https://www.nasa.gov/");

        System.out.println("hyperlink with text Missions:");
        List<WebElement> missionLinks = driver.findElements(By.xpath("//a[contains(text(), 'Mission')]"));
        for(int i = 0; i < missionLinks.size(); i++){
            System.out.println(missionLinks.get(i).getAttribute("href"));
        }

        System.out.println("hyperlink with text NASA TV");
        List<WebElement> nasaTVLinks = driver.findElements(By.xpath("//a[contains(text(), 'NASA TV')]"));
        for(int i = 0; i < nasaTVLinks.size(); i++){
            System.out.println(nasaTVLinks.get(i).getAttribute("href"));
        }

        System.out.println("hyperlink with text  Mars");
        List<WebElement> marsLinks = driver.findElements(By.xpath("//a[contains(text(), 'Mars')]"));
        for(int i = 0; i < marsLinks.size(); i++){
            System.out.println(marsLinks.get(i).getAttribute("href"));
        }

        System.out.println("All elements with tag name input:.");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for(int i = 0; i < inputs.size(); i++){
            System.out.println(inputs.get(i).getAttribute("value"));
        }

        driver.quit();
    }
}
