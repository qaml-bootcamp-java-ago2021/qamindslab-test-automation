package com.qamindslab.modulefour.srctest.test;

import com.qamindslab.modulefour.srcmain.pageObject.GmailLogInPage;
import com.qamindslab.modulethree.configfiles.example.PropertyReader;
import com.qamindslab.modulethree.testng.example.withwebdriver.common.BaseTest;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GmailValidationError extends BaseTest {
    private GmailLogInPage gmailLogInPage;

    @BeforeClass
    public void initializeGoogleMainPage(){
         gmailLogInPage = new GmailLogInPage(driver);

    }
    @Test
    public void openGoogleGmail(){
        gmailLogInPage.open();

        Assert.assertTrue(gmailLogInPage.isLoaded());
    }
    @Test (dependsOnMethods = "openGoogleGmail")
    public void LogInWithAccountNotExist()  {
        String propertyFile = "selenium-configurations.properties";
        String noValidMail = PropertyReader.getProperty(propertyFile, "email_invalid_account");

        String expected = "No pudimos encontrar tu Cuenta de Google";
        String actual;

        gmailLogInPage.setUserEmail(noValidMail);
        gmailLogInPage.btnNext();

        actual = gmailLogInPage.emailNotExist();
        System.out.println("ACTUAL" + actual);
        assertEquals(actual, expected, "the message are not equals");
    }

    @Test (dependsOnMethods = "LogInWithAccountNotExist")
    public void LogInWithInvalidPassword() {
        String propertyFile = "selenium-configurations.properties";
        String emailAccount = PropertyReader.getProperty(propertyFile, "email_valid_account");
        String noValidPassword = PropertyReader.getProperty(propertyFile, "password_email_invalid_account");

        String expected = "La contraseña es incorrecta. Vuelve a intentarlo o haz clic en \"¿Olvidaste la contraseña?\" para restablecerla.";
        String actual;

        gmailLogInPage.setUserEmail(emailAccount);
        gmailLogInPage.btnNext();
        gmailLogInPage.setUserPassword(noValidPassword);
        gmailLogInPage.btnSigInGmail();
        actual = gmailLogInPage.invalidPasswordMessage();
        System.out.println("ACTUAL" + actual);

        assertEquals(actual, expected, "the message are not equals");
    }

}
