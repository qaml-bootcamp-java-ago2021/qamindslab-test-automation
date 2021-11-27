package com.qamindslab.moduletwo.handson;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonLowestPriceSearcher {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx");

        WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextBox.sendKeys("Nintendo Switch");
        searchTextBox.submit();

        WebElement nintendoSwitchLabel = driver.findElement(By.cssSelector("li[id*='Nintendo Switch'] a"));
        nintendoSwitchLabel.click();

        WebElement fourStarsLink = driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-4']"));
        fourStarsLink.click();

        WebElement orderByElement = driver.findElement(By.cssSelector(".a-dropdown-container"));
        orderByElement.click();

        WebElement lowestToHighest = driver.findElement(By.xpath("//a[@id='s-result-sort-select_1']"));
        lowestToHighest.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        By pagination = By.cssSelector("div[class='sg-col-inner']");

        fluentWait.until(x -> x.findElement(pagination));

        List<WebElement> allDisplayedItems = driver.findElements(By.cssSelector("[class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16']"));

        for (WebElement item : allDisplayedItems){
            WebElement identifiedItem = item.findElement(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
            // System.out.println(identifiedItem.getText());

            try{
                WebElement price = item.findElement(By.cssSelector("span[class='a-price-whole']"));
                System.out.println(identifiedItem.getText() + ": " + price.getText());
            }catch (Exception ex){
                System.out.println(identifiedItem.getText() + ": This product doesn't have a price.");
            }
        }

        driver.close();
    }
}
