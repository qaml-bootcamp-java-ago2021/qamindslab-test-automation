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

public class GmailSignInPage extends BasePage {
    protected final Logger logger = LogManager.getLogger(GmailSignInPage.class);

    @FindBy(how = How.ID, using = "identifierId")
    private WebElement emailTextBox;

    @FindBy(how = How.CSS, using = "button[type='button'] span")
    private WebElement nextButton;

    @FindBy(how = How.ID, using = "logo")
    private WebElement googleLogo;

    public GmailSignInPage(WebDriver driver) {
        super(driver, "https://www.gmail.com");
    }

    public void setEmail(String username){
        emailTextBox.sendKeys(username);
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public GmailPasswordPage singIn(String username){
        setEmail(username);
        clickNextButton();
        return new GmailPasswordPage(driver);
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(googleLogo));
            logger.info("SingIn Page was loaded");
            return true;
        }catch(RuntimeException ex){
            logger.info("SingIn Page was not loaded. " + ex);
            return false;
        }
    }
}
