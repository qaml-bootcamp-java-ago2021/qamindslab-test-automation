package com.qamindslab.moduletwo.handson;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ESPNAllLeaguesReporter {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.espn.com.mx/");
        List<WebElement> elemnt = driver.findElements(By.cssSelector("*[class~='league'] > div[class~='scoreboard']"));
        for(WebElement item:elemnt){
            WebElement search = item.findElement(By.cssSelector("h2[class~='scoreLabel_title']"));
            System.out.println("******************************");
            System.out.println(search.getText());

            List<WebElement> team = item.findElements(By.cssSelector("div>div>*[class='score_link']>*[class='cscore_details']>ul>li[class*='winner']>div>div>span[class='cscore_name cscore_name--abbrev']"));
            List<WebElement> teams = item.findElements(By.cssSelector("div>div>*[class='score_link']>*[class='cscore_details']>ul>li[class*='winner']>div>div[class='cscore_score update__score']"));
            for(int i=0;i<team.size();i++){
                if((teams.get(i).isDisplayed())|| (!team.get(i).isDisplayed())){
                    WebElement result = item.findElement(By.cssSelector("*[class='scores-next controls']"));
                }
                System.out.println(team.get(i).getText()+"***"+teams.get(i).getText());
            }
        }
        driver.close();
    }
}
