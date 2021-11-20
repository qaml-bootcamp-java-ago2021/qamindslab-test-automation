package com.qamindslab.modulethree.pom.example.googlesearch.srcmain.pageobjects;

import com.qamindslab.modulethree.configfiles.example.PropertyReader;
import com.qamindslab.modulethree.pom.example.googlesearch.srcmain.common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage extends BasePage {
    @FindBy(how = How.NAME, using = "q")
    private WebElement searchBox;

    @FindBy(how = How.NAME, using = "btnK")
    private WebElement searchInGoogleButton;

    @FindBy(how = How.NAME, using = "btnI")
    private WebElement feelingLuckyButton;

    @FindBy(how = How.CLASS_NAME, using = "lnXdpd")
    private WebElement doddle;

    public GoogleMainPage(WebDriver driver) {
        super(driver, PropertyReader.getProperty("selenium-configurations.properties", "GOOGLE_URL"));
    }

    public GoogleResultsPage searchInGoogle(String searchTxt){
        searchBox.clear();
        searchBox.sendKeys(searchTxt);
        //searchBox.sendKeys(Keys.ENTER);
        searchInGoogleButton.click();
        return new GoogleResultsPage(driver);
    }

    public GoogleResultsPage feelingLuckySearch(String searchTxt){
        searchBox.clear();
        searchBox.sendKeys(searchTxt);
        feelingLuckyButton.click();
        return new GoogleResultsPage(driver);
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(doddle));
            logger.info("Google main page loaded");
            return true;
        }catch (RuntimeException exception){
            logger.error("Google main page was not loaded: " + exception);
            return false;
        }
    }
}
