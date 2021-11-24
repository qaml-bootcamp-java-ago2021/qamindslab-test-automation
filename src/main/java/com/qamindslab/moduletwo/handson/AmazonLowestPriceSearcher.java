package com.qamindslab.moduletwo.handson;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AmazonLowestPriceSearcher {


    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("nintendo switch");
        search.sendKeys(Keys.ENTER);
        WebElement marca = driver.findElement(By.cssSelector("#p_89\\/Nintendo\\ Switch > span > a > div > label > i"));
        marca.click();
        // "//i[@class='a-icon a-icon-star-medium a-star-medium-4']"
        WebElement estrella = driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-4']"));
        estrella.click();
        WebElement orden = driver.findElement(By.cssSelector(".a-dropdown-container"));
        orden.click();
        WebElement lowest = driver.findElement(By.xpath("//a[@id='s-result-sort-select_1']"));
        lowest.click();

        Wait<WebDriver> wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        By pag=By.cssSelector("div[class='sg-col-inner']");
        wait.until(x->x.findElement(pag));
        List<WebElement> elemnt = driver.findElements(By.cssSelector("[class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16']"));
        for(WebElement item:elemnt){
            WebElement Item = driver.findElement(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
        try{
            WebElement precio = item.findElement(By.cssSelector("span[class='a-price-whole']"));
        }catch(Exception ex){
            System.out.println("No tiene precio"+Item.getText());
        }
        }
        driver.close();
    }
}
