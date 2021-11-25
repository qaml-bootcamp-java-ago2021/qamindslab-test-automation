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

import java.util.ArrayList;
import java.util.List;

public class GmailComposePage extends BasePage {
    protected final Logger logger = LogManager.getLogger(GmailComposePage.class);

    static final String TO_EMAIL="jesus.serranop@gmail.com";
    static final String CC_EMAIL="jesus.serranop@gmail.com";
    static final String BCC_EMAIL="jesus.serranop@gmail.com";
    static final String SUBJECT="TEST AUTOMATION WITH SELENIUM";
    static final String MESSAGE="This is an automated email using selenium!";


    @FindBy(how = How.CSS, using = "div[class='dC'] > div[class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendButton;

    @FindBy(how = How.NAME, using = "to")
    private WebElement toList;

    @FindBy(how = How.NAME, using = "bcc")
    private WebElement bccList;

    @FindBy(how = How.NAME, using = "cc")
    private WebElement ccList;

    @FindBy(how = How.CSS, using = "span[class='aB  gQ pB']")
    private WebElement bccButton;

    @FindBy(how = How.CSS, using = "span[class='aB gQ pE']")
    private WebElement ccButton;

    @FindBy(how = How.NAME, using = "subjectbox")
    private WebElement subjectBox;

    @FindBy(how = How.CSS, using = "div.Ar.Au>div.Am.Al.editable.LW-avf.tS-tW")
    private WebElement messageTextBox;

    @FindBy(how = How.XPATH, using = "//a[text()='Enviados']")
    private WebElement sentLink;

    @FindBy(how = How.XPATH, using = "//span/span[contains(text(), 'TEST AUTOMATION WITH SELENIUM')]")
    private WebElement lastEmailSent;


    public GmailComposePage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public void sendEmail(){
        toList.click();
        toList.sendKeys(TO_EMAIL);

        ccButton.click();
        ccList.sendKeys(CC_EMAIL);

        bccButton.click();
        bccList.sendKeys(BCC_EMAIL);

        subjectBox.sendKeys(SUBJECT);
        messageTextBox.sendKeys(MESSAGE);

        sendButton.click();

        sentLink.click();
    }

    public boolean wasEmailSent(){
        logger.info("Validate email was sent");
        logger.info("Text = " + lastEmailSent.getText());
        if(lastEmailSent.getText().equalsIgnoreCase(SUBJECT)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(toList));
            logger.info("Inbox Compose was loaded");
            return true;
        }catch(RuntimeException ex){
            logger.info("Inbox Compose was not loaded. " + ex);
            return false;
        }
    }
}
