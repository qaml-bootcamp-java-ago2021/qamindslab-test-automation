package com.qamindslab.modulethree.configfiles.handson.srctest.test;

import com.qamindslab.modulethree.configfiles.example.PropertyReader;
import com.qamindslab.modulethree.configfiles.handson.srcmain.pageobjects.GoogleSignInDenied;
import com.qamindslab.modulethree.configfiles.handson.srcmain.pageobjects.GoogleSignIn;
import com.qamindslab.modulethree.configfiles.handson.srctest.common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class GoogleSignInTest extends BaseTest {
    private GoogleSignIn googleSignIn;
    private GoogleSignInDenied googleSignInDenied;

    @BeforeClass
    void initializeGoogleSiginInPage(){
        this.googleSignIn = new GoogleSignIn(this.driver);
    }

    @Test
    public void openGoogleSignIn(){
        googleSignIn.open();
        assertTrue(googleSignIn.isLoaded());
    }

    @Test(dependsOnMethods = {"openGoogleSignIn"})
    void nextButtonShouldNotBeDisplayedAfterClickingOnIt() throws InterruptedException {
        googleSignIn.setEMail(PropertyReader.getProperty("selenium-configurations.properties", "EMAIL"));
        String googleSignNextInButtonText = googleSignIn.getNextButtonText();

        googleSignInDenied = googleSignIn.clickNext();
        googleSignInDenied.isLoaded();
        String googleDeniedNextInButtonText = googleSignInDenied.getNextButtonText();

        assertFalse(googleSignNextInButtonText.equals(googleDeniedNextInButtonText));
    }
}
