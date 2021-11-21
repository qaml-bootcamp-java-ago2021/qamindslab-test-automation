package com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects;

import com.qamindslab.modulethree.configfiles.exercise.srcmain.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookHomePage extends BasePage {
    @FindBy(how = How.CSS, using = "a[aria-label*='Facebook']")
    private WebElement facebookLogo;

    @FindBy(how = How.CSS, using = "a[href~='https://www.facebook.com/friends/']")
    private WebElement findFriendsLink;

    // UPDATE THIS LINE WITH THE INTENDED USER PROFILE NAME
    @FindBy(how = How.CSS, using = "ul > li a[href*='https://www.facebook.com/<PLACE YOUR FACEBOOK USER PROFILE NAME>']")
    private WebElement profileLink;

    public FacebookHomePage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public void searchFriends(){
        findFriendsLink.click();
    }

    public FacebookProfilePage clickOnProfile(){
        profileLink.click();

        return new FacebookProfilePage(driver);
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(facebookLogo));
            logger.info("Facebook home page is loaded.");
            return true;
        }catch (RuntimeException exception){
            logger.error("Facebook home page was not loaded: " + exception);
            return false;
        }
    }
}
