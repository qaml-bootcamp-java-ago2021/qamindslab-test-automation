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

public class GmailInboxPage extends BasePage {
    protected final Logger logger = LogManager.getLogger(GmailInboxPage.class);

    static final String NAME="Arturo Serrano";
    static final String EMAIL="aserrano1768@gmail.com";

    @FindBy(how = How.CSS, using = "table > tbody td[role='heading']")
    private List<WebElement> inboxMainTabs;

    @FindBy(how = How.CSS, using = "img[class='gb_tc']")
    private WebElement googleLogo;

    @FindBy(how = How.CSS, using = "div.T-I.J-J5-Ji.nu")
    private WebElement refreshButton;

    @FindBy(how = How.CSS, using = "a.gb_C.gb_Ma.gb_h>img.gb_Ca.gbii")
    private WebElement profileButton;

    @FindBy(how = How.CSS, using = "div.z0>div.T-I.T-I-KE.L3")
    private WebElement composeButton;

    @FindBy(how = How.CSS, using = "#gb > div.gb_Fd.gb_Wd.gb_Md > div.gb_0a.gb_E.gb_k.gb_1a.gb_la > div.gb_9a > div.gb_bb > div.gb_lb.gb_mb")
    private WebElement profileName;

    @FindBy(how = How.CSS, using = "#gb > div.gb_Fd.gb_Wd.gb_Md > div.gb_0a.gb_E.gb_k.gb_1a.gb_la > div.gb_9a > div.gb_bb > div.gb_nb")
    private WebElement profileEmail;

    private List<String> tabsNames = new ArrayList<String>();

    public GmailInboxPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        tabsNames.add("Principal");
        tabsNames.add("Social");
        tabsNames.add("Promociones");
    }

    public boolean areTabsPresent(){
        for (int i = 0; i < inboxMainTabs.size(); i++) {
            if(!tabsNames.contains(inboxMainTabs.get(i).getText())){
               return false;
            }
        }
        return true;
    }

    public boolean isRefreshButtonVisible(){
        return refreshButton.isDisplayed();
    }

    public boolean isProfileButtonVisible(){
        return profileButton.isDisplayed();
    }

    public boolean isComposeButtonVisible(){
        return composeButton.isDisplayed();
    }

    public boolean areProfileElementsVisible(){
        profileButton.click();
        if(profileName.isDisplayed() && profileEmail.isDisplayed() &&
                profileEmail.getText().equalsIgnoreCase(EMAIL) &&
                profileName.getText().equalsIgnoreCase(NAME)){
            return true;
        }
        return false;
    }

    public GmailComposePage clickComposeEmailButton(){
        composeButton.click();
        return new GmailComposePage(driver);
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(googleLogo));
            logger.info("Inbox Page was loaded");
            return true;
        }catch(RuntimeException ex){
            logger.info("Inbox Page was not loaded. " + ex);
            return false;
        }
    }
}
