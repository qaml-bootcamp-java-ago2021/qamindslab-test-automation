package com.qamindslab.modulefour.instructions.srctest.test;

import com.qamindslab.modulefour.instructions.srcmain.pageobjects.GmailComposePage;
import com.qamindslab.modulefour.instructions.srcmain.pageobjects.GmailInboxPage;
import com.qamindslab.modulefour.instructions.srcmain.pageobjects.GmailPasswordPage;
import com.qamindslab.modulefour.instructions.srcmain.pageobjects.GmailSignInPage;
import com.qamindslab.modulefour.instructions.srctest.common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class GmailPageTestErrors extends BaseTest {
    private GmailSignInPage gmailSignInPage;
    private GmailPasswordPage gmailPasswordPage;

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
    public void singInToGmailEmailError()  {
        // We first need to set the user
        gmailSignInPage.singIn("INCORRECT_EMAIL");

        assertEquals(gmailSignInPage.getErrorMessage(), "No pudimos encontrar tu Cuenta de Google");

        gmailSignInPage.clearEmailInput();

    }

    @Test(dependsOnMethods = {"singInToGmailEmailError"})
    public void singInToGmailPasswordError()  {
        // We first need to set the user
        gmailPasswordPage = gmailSignInPage.singIn("aserrano1768@gmail.com");

        // Wait for password page to be loaded
        assertTrue(gmailPasswordPage.isLoaded());

        // Set the incorrect password
        gmailPasswordPage.setPassword("asjdkjashdkjash");

        assertEquals(gmailPasswordPage.getErrorMessage(), "La contraseña es incorrecta. Vuelve a intentarlo o haz clic en \"¿Olvidaste la contraseña?\" para restablecerla.", "Incorrect message.");
    }

}
