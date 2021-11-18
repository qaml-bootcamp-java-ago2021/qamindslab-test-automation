package com.qamindslab.modulethree.pom.example.googlesignin.srcmain.pageobjects;

import com.qamindslab.modulethree.pom.example.googlesignin.srcmain.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSignIn extends BasePage {

    @FindBy(how = How.ID, using = "identifierId")
    private WebElement emailTextBox;

    @FindBy(how = How.CSS, using = ".PrDSKc > button")
    private WebElement forgetLink;

    @FindBy(how = How.CSS, using = "a[jsname='JFyozc']")
    private WebElement moreOptions;

    @FindBy(how = How.CSS, using = "button[type='button'] span")
    private WebElement nextButton;

    @FindBy(how = How.ID, using = "logo")
    private WebElement googleLogo;

    public GoogleSignIn(WebDriver driver) {
        super(driver, "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    }

    public void setEMail(String in){
        emailTextBox.sendKeys(in);
    }
    public void clickForgotEmail(){
        forgetLink.click();
    }
    public void clickMoreOptions(){
        moreOptions.click();
    }

    public String getNextButtonText(){
        return nextButton.getText();
    }

    public String currentSearch(){
        return driver.getTitle();
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(googleLogo));
            logger.info("Google SignIn page is loaded: " + driver.getTitle());
            return true;
        }catch(RuntimeException ex){
            logger.error("Google SignIn page was not loaded. " + ex);
            return false;
        }
    }
}
