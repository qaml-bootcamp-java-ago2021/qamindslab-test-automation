package com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects;

import com.qamindslab.modulefour.instructions.srcmain.common.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBookHomePage extends BasePage {
    protected final Logger logger = LogManager.getLogger(FaceBookHomePage.class);

    @FindBy(how = How.CSS, using = "svg.a8c37x1j.ms05siws.hwsy1cff.b7h9ocf4>path.p361ku9c")
    private WebElement logo;

    public FaceBookHomePage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public FaceBookProfilePage clickProfile(){
        driver.navigate().to("https://www.facebook.com/jesuserrano");
        return new FaceBookProfilePage(driver);
    }

    public void clickSearchFriends(){
        driver.navigate().to("https://www.facebook.com/friends/list");
    }
    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(logo));
            logger.info("Inbox Page was loaded");
            return true;
        }catch(RuntimeException ex){
            logger.info("Inbox Page was not loaded. " + ex);
            return false;
        }
    }
}