package com.qamindslab.moduletwo.handson;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class INaturalistCategoriesIdentifier {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.inaturalist.org/");
        Actions action =new Actions(driver);
        WebElement elemnt = driver.findElement(By.id("header-more-dropdown-toggle"));
        action.moveToElement(elemnt);
        WebElement elemnt2 = driver.findElement(By.cssSelector("Li>a[href*='places']"));
        action.moveToElement(elemnt2);
        action.click().build().perform();
        WebElement search= driver.findElement(By.id("q"));
        search.sendKeys("Bosque los Colomos");
        WebElement button= driver.findElement(By.name("commit"));
        button.click();
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'/places/bosque-los-colomos-ja-mx')]"));
        result.click();
        List<WebElement> categorias = driver.findElements(By.cssSelector(".taxon_links a"));
        List<String> links =new ArrayList<>();
        for(WebElement link:categorias){
            links.add(link.getAttribute("href"));
        }
        for(int i=0;i<categorias.size();i++){
            driver.navigate().to(links.get(i));
            List<WebElement> subcategorias = driver.findElements(By.cssSelector(".guide_taza .comname"));
            if(subcategorias.size()> 0){
                System.out.println(subcategorias.get(0).getText());
            }
            else{
                List<WebElement> error = driver.findElements(By.cssSelector(".taxon_links a"));
                System.out.println(error.get(i).getText());
            }

        }

        driver.close();
    }
}
