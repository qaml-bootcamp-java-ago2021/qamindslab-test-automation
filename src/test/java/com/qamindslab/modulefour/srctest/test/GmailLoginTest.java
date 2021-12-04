package com.qamindslab.modulefour.srctest.test;

import com.google.j2objc.annotations.Property;
import com.qamindslab.modulefour.srcmain.pageObject.EmailEditorDialogPage;
import com.qamindslab.modulefour.srcmain.pageObject.GmailLogInPage;
import com.qamindslab.modulefour.srcmain.pageObject.GmailMainPage;
import com.qamindslab.modulethree.configfiles.example.PropertyReader;
import com.qamindslab.modulethree.testng.example.withwebdriver.common.BaseTest;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GmailLoginTest extends BaseTest {
    private GmailLogInPage gmailLogInPage;
    public GmailMainPage gmailMainPage;
    public EmailEditorDialogPage emailEditorDialogPage;
    String propertyFile = "selenium-configurations.properties";
    String validMail = PropertyReader.getProperty(propertyFile, "EMAIL_VALID_ACCOUNT");
    String validPassword = PropertyReader.getProperty(propertyFile, "PASSWORD_EMAIL_VALID_ACCOUNT");
    String profileNAme = PropertyReader.getProperty(propertyFile, "PROFILE_NAME");
    String expected = "Redactar";
    String actualRedactar;

    @BeforeClass
    public void initializeGoogleMainPage() {
        this.gmailLogInPage = new GmailLogInPage(driver);
    }

    @Test
    public void openGoogleGmail() {
        gmailLogInPage.open();

        Assert.assertTrue(gmailLogInPage.isLoaded());
    }

    @Test(dependsOnMethods = "openGoogleGmail")
    public void LogIn() {
        gmailLogInPage.setUserEmail(validMail);
        gmailLogInPage.clickOnElement(gmailLogInPage.nextUserButton);
        gmailLogInPage.setUserPassword(validPassword);
        gmailMainPage = gmailLogInPage.btnSigInGmail();

        assertTrue(gmailMainPage.isLoaded());

        actualRedactar = this.gmailMainPage.redactarButton.getText();
        assertEquals(actualRedactar, expected, "Incorrect string : Redactar");
    }

    @Test(dependsOnMethods = "LogIn")
    public void checkMainTabs() {
        String principalLabelExpected = "Principal";
        String promotionLabelActualExpected = "Promociones";
        String sotialLabelActualExpected = "Social";
        String principalLabelActual = gmailMainPage.getPrincipalLabel();
        String promotionLabelActual = gmailMainPage.getPromotionsLabel();
        String sotialLabelActual = gmailMainPage.getSocialLabel();

        assertEquals(principalLabelActual, principalLabelExpected, "Incorrect string : Principal");
        assertEquals(promotionLabelActual, promotionLabelActualExpected, "Incorrect string : Promociones");
        assertEquals(sotialLabelActual, sotialLabelActualExpected, "Incorrect string : Social");
    }

    @Test(dependsOnMethods = "checkMainTabs")
    public void checkRefreshAndPRofileButtonIsPressent() {
        assertTrue(gmailMainPage.isEnabled(gmailMainPage.btnActualizar));
        assertTrue(gmailMainPage.isEnabled(gmailMainPage.profile));
    }

    @Test (dependsOnMethods = "checkRefreshAndPRofileButtonIsPressent")
    public void verifyNameAndEmailIsWhenTheProfileIsDisplayed(){
        String validMail = PropertyReader.getProperty(propertyFile, "EMAIL_VALID_ACCOUNT");
        String profileNAme = PropertyReader.getProperty(propertyFile, "PROFILE_NAME");
        gmailMainPage.clickOnProfileButton();
        String profileNameActual = gmailMainPage.getElement(gmailMainPage.profileName);
        String profileEmailActual = gmailMainPage.getElement(gmailMainPage.profileEmail);

        assertEquals(profileNameActual, profileNAme, "the profile doesn't match");

        assertEquals(profileEmailActual, validMail, "the email doesn't match");
    }

    @Test (dependsOnMethods = "verifyNameAndEmailIsWhenTheProfileIsDisplayed")
     public void verifyEmailEditorIsDisplayed() {
      emailEditorDialogPage = gmailMainPage.clickOnComposeButton();
      assertTrue(emailEditorDialogPage.isLoaded());
    }

  @Test (dependsOnMethods = "verifyEmailEditorIsDisplayed")
  public void sendEmailAndVerifyIsOnSentSections(){
        emailEditorDialogPage.sendEmail(validMail,validMail,validMail,"test send email","something in this email");
        assertTrue(gmailMainPage.isEnabled(gmailMainPage.sentButton));
    }
}
