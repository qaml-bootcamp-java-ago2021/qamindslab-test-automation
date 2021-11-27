package com.qamindslab.moduleone.selenium.handson.challenge;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Hands On #6: Challenge 2 - Visit Selenium Hyperlinks in Wikipedia
public class WikipediaSeleniumHyperlinksVisitor {
    public static void main(String[] args) throws InterruptedException {
        // Create WebDriver instance
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        // Maximize browser window.
        driver.manage().window().maximize();
        // Load wikipedia.
        driver.get("https://www.wikipedia.org/");

        // Search for Selenium.
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("Selenium");

        // Wait 1 second
        Thread.sleep(1000);

        // Select the first option from the dropdown list.
        WebElement firstOptionFromDropdown = driver.findElement(By.xpath("//*[@id=\"typeahead-suggestions\"]/div/a[1]"));
        firstOptionFromDropdown.click();

        // Find all paragraphs with text 'Selenium' inside each.
        List<WebElement> paragraphWithSearchTopic = driver.findElements(By.xpath("//p[contains(text(), 'Selenium')]"));

        // Find the Header Title page.
        WebElement firstHeading = driver.findElement(By.tagName("h1"));

        // Print current url, search topic and the number of paragraphs with selenium text inside.
        System.out.println("CURRENT URL: " + driver.getCurrentUrl());
        System.out.println("SEARCH TOPIC: " + firstHeading.getText());
        System.out.println("TOTAL NUMBER OF <p> ELEMENTS THAT CONTAINS THE SEARCH TOPICS IN THEIR TEXT IS: " + paragraphWithSearchTopic.size());

        // Get all element hyperlinks that contains selenium text inside.
        List<WebElement> anchorWithSearchTopic = driver.findElements(By.xpath("//a[contains(text(), 'Selenium')]"));

        // Create a LinkedHashMap to get all links
        Map<String, WebElement> links = new LinkedHashMap<>();

        // Read the href attribute (hyperlink) and place it into the LinkedHashMap.
        for(WebElement anchor: anchorWithSearchTopic){
            links.put(anchor.getAttribute("href"), anchor);
        }

        // Print the total number of 'a' elements that contains Selenium text inside.
        System.out.println("TOTAL NUMBER OF <a> ELEMENTS THAT CONTAINS THE SEARCH TOPICS IN THEIR TEXT IS: " + links.size());

        // Print current url and use navigate().to to visit the link page.
        for(Map.Entry<String, WebElement> link : links.entrySet()){
            try{
                if(link.getKey() != null)
                    driver.navigate().to(link.getKey());

                System.out.println("CURRENT URL: " + driver.getCurrentUrl());
                System.out.println("SEARCH TOPIC FROM TITLE PAGE: " + driver.getTitle());
            }catch (WebDriverException ex){
                System.out.println("PAGE IS NOT AVAILABLE");
            }
        }

        // Wait for 5 seconds.
        Thread.sleep(5000);

        // Quit WebDriver.
        driver.quit();
    }
}
