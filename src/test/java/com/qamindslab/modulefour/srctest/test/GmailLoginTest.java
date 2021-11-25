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
        String expected = "Redactar";
        String actual;
        gmailLogInPage.setUserEmail("banizhermana@gmail.com");
        gmailLogInPage.btnNext();
        gmailLogInPage.setUserPassword("banizhermana12");
        gmailMainPage = gmailLogInPage.btnSigInGmail();
        assertTrue(gmailMainPage.isLoaded());
        actual= this.gmailMainPage.redactarButton.getText();
        assertEquals(actual, expected, "Incorrect string : Redactar");
    }



}
