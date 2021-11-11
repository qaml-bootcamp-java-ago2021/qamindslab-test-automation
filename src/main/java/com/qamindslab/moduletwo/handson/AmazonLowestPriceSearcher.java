package com.qamindslab.moduletwo.handson;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.Browser;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withif.NotWebDriverImplementedException;
import com.qamindslab.moduleone.selenium.handson.webdriver.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AmazonLowestPriceSearcher {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() throws NotWebDriverImplementedException {
        driver = WebDriverManager.getDriver(Browser.CHROME);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void AmazonLowestPriceSearcher() throws InterruptedException, IOException {

        driver.get("https://www.amazon.com.mx/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement siteSearch = driver.findElement(By.name("field-keywords"));
        siteSearch.sendKeys("Nintendo Switch\n");

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("span>a>div>label>i"));
        checkBoxes.get(0).click();

        List<WebElement> selectOptions = new Select(driver.findElement(By.id("s-result-sort-select"))).getOptions();
        for (int i = 0; i < selectOptions.size(); i++) {
            WebElement option = selectOptions.get(i);
            System.out.println("Text Button = " + option.getText());
            if(option.getText().equals("Precio: de más bajo a más alto")){
                option.click();
                break;
            }
        }

        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
        for (int i = 0; i < prices.size(); i++) {
            WebElement price = prices.get(i);
            System.out.println("Price is = " + price.getText());
        }

        List<WebElement> tittles = driver.findElements(By.cssSelector("a.a-link-normal.a-text-normal>span.a-size-medium.a-color-base.a-text-normal"));
        for (int i = 0; i < tittles.size(); i++) {
            WebElement tittle = tittles.get(i);
            System.out.println("tittle is = " + tittle.getText());
        }

        Thread.sleep(10000);

        driver.close();
    }
}
