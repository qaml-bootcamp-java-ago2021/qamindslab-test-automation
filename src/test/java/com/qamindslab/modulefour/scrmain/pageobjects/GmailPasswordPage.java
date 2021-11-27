package com.qamindslab.modulefour.scrmain.pageobjects;

import com.qamindslab.modulefour.scrmain.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPasswordPage extends BasePage {

    @FindBy(how = How.CSS, using = "input[type='password']")
    private WebElement passwordTextBox;

    @FindBy(how = How.XPATH, using = "//div[1]/div/div/button/span")
    private WebElement nextButton;

    @FindBy(how = How.CSS, using = "div[jsname='B34EJ'] > span")
    private WebElement errorMessage;

    public GmailPasswordPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public com.qamindslab.modulefour.scrmain.pageobjects.GmailLandingPage loginWithPassword(String password){
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
        nextButton.click();

        return new com.qamindslab.modulefour.scrmain.pageobjects.GmailLandingPage(driver);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
            logger.info("Gmail Password successfully.");
            return true;
        }catch (RuntimeException exception){
            logger.info("Gmail Password was not loaded. " + exception);
            return false;
        }
    }
}
