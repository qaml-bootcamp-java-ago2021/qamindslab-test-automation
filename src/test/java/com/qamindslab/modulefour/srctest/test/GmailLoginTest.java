package com.qamindslab.modulefour.srctest.test;

import com.google.j2objc.annotations.Property;
import com.qamindslab.modulefour.srcmain.pageObject.GmailLogInPage;
import com.qamindslab.modulefour.srcmain.pageObject.GmailMainPage;
import com.qamindslab.modulethree.configfiles.example.PropertyReader;
import com.qamindslab.modulethree.pom.example.googlesearch.srcmain.pageobjects.GoogleMainPage;
import com.qamindslab.modulethree.pom.example.googlesearch.srcmain.pageobjects.GoogleResultsPage;
import com.qamindslab.modulethree.testng.example.withwebdriver.common.BaseTest;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GmailLoginTest extends BaseTest {
    private GmailLogInPage gmailLogInPage;
    public GmailMainPage gmailMainPage;

    @BeforeClass
    public void initializeGoogleMainPage(){
        this.gmailLogInPage = new GmailLogInPage(driver);

    }

    @Test
    public void openGoogleGmail(){
        gmailLogInPage.open();

        Assert.assertTrue(gmailLogInPage.isLoaded());
    }

    @Test (dependsOnMethods = "openGoogleGmail")
    public void LogIn(){
        String propertyFile = "selenium-configurations.properties";
        String validMail = PropertyReader.getProperty(propertyFile, "email_valid_account");
        String validPassword = PropertyReader.getProperty(propertyFile, "password_email_valid_account");

        String expected = "Redactar";
        String actualRedactar;
        String principalLabelExpected = "Principal";
        String promotionLabelActualExpected = "Promociones";
        String sotialLabelActualExpected = "Social";

        gmailLogInPage.setUserEmail(validMail);
        gmailLogInPage.btnNext();
        gmailLogInPage.setUserPassword(validPassword);
        gmailMainPage = gmailLogInPage.btnSigInGmail();
        assertTrue(gmailMainPage.isLoaded());

        actualRedactar= this.gmailMainPage.redactarButton.getText();
        assertEquals(actualRedactar, expected, "Incorrect string : Redactar");

        String principalLabelActual = gmailMainPage.getPrincipalLabel();
        String promotionLabelActual = gmailMainPage.getPromotionsLabel();
        String sotialLabelActual = gmailMainPage.getSocialLabel();
        assertEquals(principalLabelActual, principalLabelExpected, "Incorrect string : Principal");
        assertEquals(promotionLabelActual, promotionLabelActualExpected, "Incorrect string : Promociones");
        assertEquals(sotialLabelActual, sotialLabelActualExpected, "Incorrect string : Social");

        assertTrue(gmailMainPage.isEnabled(gmailMainPage.btnActualizar));
        assertTrue(gmailMainPage.isEnabled(gmailMainPage.profile));

    }



}
