package com.qamindslab.modulefour.srctest.test;

import com.qamindslab.modulefour.srcmain.pageobjects.GmailLoginPage;
import com.qamindslab.modulefour.srcmain.pageobjects.GmailPasswordPage;
import com.qamindslab.modulefour.srctest.common.BaseTest;
import com.qamindslab.modulethree.configfiles.example.PropertyReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GmailNegativeTest extends BaseTest {

    private GmailLoginPage gmailLoginPage;
    private GmailPasswordPage gmailPasswordPage;

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
    public void validateWrongEmail() {
        String propertyFile = "selenium-configurations.properties";
        String gmailAccount = PropertyReader.getProperty(propertyFile, "INCORRECT_GMAIL_ACCOUNT");

        gmailLoginPage.enterGmailAccount(gmailAccount);

        assertEquals(gmailLoginPage.getErrorMessage(), "No pudimos encontrar tu Cuenta de Google", "Incorrect message.");
    }

    @Test(dependsOnMethods = {"openGmail"})
    public void validateWrongPassword(){
        String propertyFile = "selenium-configurations.properties";
        String gmailAccount = PropertyReader.getProperty(propertyFile, "GMAIL");

        gmailPasswordPage = gmailLoginPage.enterGmailAccount(gmailAccount);
        gmailPasswordPage.isLoaded();

        gmailPasswordPage.loginWithPassword("Wrong password");

        assertEquals(gmailPasswordPage.getErrorMessage(), "La contraseña es incorrecta. Vuelve a intentarlo o haz clic en \"¿Olvidaste la contraseña?\" para restablecerla.", "Incorrect message.");
    }
}