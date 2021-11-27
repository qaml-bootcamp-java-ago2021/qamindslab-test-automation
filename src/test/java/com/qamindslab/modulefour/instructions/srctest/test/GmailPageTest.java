package com.qamindslab.modulefour.instructions.srctest.test;

import com.qamindslab.modulefour.instructions.srcmain.pageobjects.GmailComposePage;
import com.qamindslab.modulefour.instructions.srcmain.pageobjects.GmailInboxPage;
import com.qamindslab.modulefour.instructions.srcmain.pageobjects.GmailPasswordPage;
import com.qamindslab.modulefour.instructions.srcmain.pageobjects.GmailSignInPage;
import com.qamindslab.modulefour.instructions.srctest.common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.Assert.assertEquals;

public class GmailPageTest extends BaseTest {
    private GmailSignInPage gmailSignInPage;
    private GmailPasswordPage gmailPasswordPage;
    private GmailInboxPage gmailInboxPage;
    private GmailComposePage gmailComposePage;

    @BeforeClass
    void initializePages(){
        this.gmailSignInPage = new GmailSignInPage(this.driver);
    }

    @Test
    public void openGmailPage(){
        gmailSignInPage.open();
        assertTrue(gmailSignInPage.isLoaded());
    }

    @Test(dependsOnMethods = {"openGmailPage"})
    public void singInToGmail()  {
        // We first need to set the user
        gmailPasswordPage = gmailSignInPage.singIn("aserrano1768@gmail.com");

        // Wait for password page to be loaded
        assertTrue(gmailPasswordPage.isLoaded());

        // Set the password
        gmailInboxPage = gmailPasswordPage.setPassword("2GsuP3TXcaRJ7QG");

        // Wait for inbox page to be loaded
        assertTrue(gmailInboxPage.isLoaded());
    }

    @Test(dependsOnMethods = {"singInToGmail"})
    public void validateInboxPage()  {
        // Verify 3 main tabs are present
        assertTrue(gmailInboxPage.areTabsPresent());

        // Refresh button visible
        assertTrue(gmailInboxPage.isRefreshButtonVisible());

        // Profile button visible
        assertTrue(gmailInboxPage.isProfileButtonVisible());

        // Profile button visible
        assertTrue(gmailInboxPage.isComposeButtonVisible());

        // Click profile button and validate name and email
        assertTrue(gmailInboxPage.areProfileElementsVisible());
    }

    @Test(dependsOnMethods = {"validateInboxPage"})
    public void clickComposeEmail() throws InterruptedException {
        gmailComposePage = gmailInboxPage.clickComposeEmailButton();

        // Click profile button and validate name and email
        assertTrue(gmailComposePage.isLoaded());

        gmailComposePage.sendEmail();

        assertTrue(gmailComposePage.wasEmailSent());
    }

}
