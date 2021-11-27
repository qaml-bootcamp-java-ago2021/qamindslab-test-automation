package com.qamindslab.modulefour.srctest.test;

import com.qamindslab.modulefour.scrmain.pageobjects.*;
import com.qamindslab.modulefour.srctest.common.BaseTest;
import com.qamindslab.modulethree.configfiles.example.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GmailTest extends BaseTest {

    private GmailLoginPage gmailLoginPage;
    private GmailPasswordPage gmailPasswordPage;
    private GmailLandingPage gmailLandingPage;
    private GmailProfilePopupPage gmailProfilePopupPage;
    private GmailComposeEmailPage composeEmailPage;
    private GmailSentPage gmailSentPage;

    @BeforeClass
    public void initializeGmailPage(){
        this.gmailLoginPage = new GmailLoginPage(this.driver);
    }

    @Test
    public void openGmail(){
        gmailLoginPage.open();
        assertTrue(gmailLoginPage.isLoaded());
    }

    @Test(dependsOnMethods = {"openGmail"})
    public void login(){
        String propertyFile = "selenium-configurations.properties";
        String gmailAccount = PropertyReader.getProperty(propertyFile, "ACTIVE_GMAIL_ACCOUNT");
        String gmailPassword = PropertyReader.getProperty(propertyFile, "GMAIL_PASSWORD");

        gmailPasswordPage = gmailLoginPage.enterGmailAccount(gmailAccount);
        gmailPasswordPage.isLoaded();

        gmailLandingPage = gmailPasswordPage.loginWithPassword(gmailPassword);

        assertTrue(gmailLandingPage.isLoaded());
    }

    @DataProvider(name = "inboxTabs")
    public Object[][] inboxTabs(){
        return new Object[][]{{"Principal"}, {"Social"}, {"Promociones"}};
    }

    @Test(dependsOnMethods = {"login"},
        dataProvider = "inboxTabs"
    )
    public void inboxMainTabsShouldHave(String inboxTab){
        gmailLandingPage.isLoaded();

        List<String> tabs = gmailLandingPage.getTabNames();

        assertTrue(tabs.contains(inboxTab));
    }

    @Test(dependsOnMethods = {"login"})
    public void validateRefreshButtonIsDisplayed(){
        assertTrue(gmailLandingPage.isRefreshButtonDisplayed());
    }

    @Test(dependsOnMethods = {"login"})
    public void validateProfileButtonIsDisplayed(){
        assertTrue(gmailLandingPage.isProfileButtonDisplayed());
    }

    @Test(dependsOnMethods = {"login"})
    public void validateComposeButtonIsDisplayed(){
        assertTrue(gmailLandingPage.isComposeButtonDisplayed());
    }

    @Test(dependsOnMethods = {"validateProfileButtonIsDisplayed"})
    public void validateProfileNameAndEmail(){
        gmailProfilePopupPage = gmailLandingPage.showProfilePopup();

        gmailProfilePopupPage.isLoaded();

        assertTrue(gmailProfilePopupPage.isProfileNameDisplayed());
        assertTrue(gmailProfilePopupPage.isEmailDisplayed());
    }

    @Test(dependsOnMethods = {"validateComposeButtonIsDisplayed", "validateProfileNameAndEmail"})
    public void validateComposeEditorIsDisplayed(){
        composeEmailPage = gmailLandingPage.composeEmail();

        assertTrue(composeEmailPage.isLoaded());
    }

    @Test(dependsOnMethods = {"validateComposeEditorIsDisplayed"})
    public void validateDefaultFieldsAreDisplayed(){
        assertTrue(composeEmailPage.isAllDefaultValuesDisplayed());
    }

    @Test(dependsOnMethods = {"validateDefaultFieldsAreDisplayed"})
    public void validateCCFieldIsShownWhenClickedCCLink(){
        assertTrue(composeEmailPage.isCCTextBoxDisplayed());
    }

    @Test(dependsOnMethods = {"validateDefaultFieldsAreDisplayed"})
    public void validateBCCFieldIsShownWhenClickedBCCLink(){
        assertTrue(composeEmailPage.isBCCTextBoxDisplayed());
    }

    @Test(dependsOnMethods = {"validateCCFieldIsShownWhenClickedCCLink", "validateBCCFieldIsShownWhenClickedBCCLink"})
    public void sendEmail(){
        String to = "belen.Nightwish@gmail.com";
        String cc = "amorxcocinar@gmail.com";
        String bcc = "belen.Nightwish@gmail.com";
        String subject = "Correo Nuevo!";
        String message = "Enviando email de prueba :) =D";
        String file="";

        composeEmailPage.sendEmailWithCCAndBCC(to, cc, bcc, subject, message);
    }

    @Test(dependsOnMethods = {"sendEmail"})
    public void validateEmailIsSent(){
        gmailSentPage = new GmailSentPage(driver);
        gmailSentPage.loadPage();
        gmailSentPage.isLoaded();

        assertEquals(gmailSentPage.getLastEmailSentText(), "Correo Nuevo!", "Correo Nuevo!");
    }

    @Test(dependsOnMethods = {"validateEmailIsSent"})
    public void validateInboxEmailsHaveDescriptionAndDate(){
        gmailLandingPage.clickOnInbox();

        gmailLandingPage.getAllEmailDescription().stream().forEach(Assert::assertNotNull);
        gmailLandingPage.getAllEmailDates().stream().forEach(Assert::assertNotNull);
    }
}
