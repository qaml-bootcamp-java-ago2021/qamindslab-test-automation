package com.qamindslab.modulefour.instructions.srcmain.pageobjects;

import com.qamindslab.modulefour.instructions.srcmain.common.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPasswordPage extends BasePage {

    protected final Logger logger = LogManager.getLogger(GmailPasswordPage.class);

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordextBox;

    @FindBy(how = How.CSS, using = "button[type='button'] span")
    private WebElement nextButton;

    @FindBy(how = How.CSS, using = ".OyEIQ > div:nth-child(2) > span:nth-child(1)")
    private WebElement errorMessage;



    public GmailPasswordPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public GmailInboxPage setPassword(String in){
        passwordextBox.sendKeys(in);
        nextButton.click();
        return new GmailInboxPage(driver);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(passwordextBox));
            logger.info("GmailPasswordPage was loaded");
            return true;
        }catch(RuntimeException ex){
            logger.info("GmailPasswordPage was NOT loaded" + ex);
            return false;
        }
    }
}
