package com.qamindslab.modulethree.configfiles.exercise.srctest.test;

import com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects.FaceBookHomePage;
import com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects.FaceBookLoginPage;
import com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects.FaceBookProfilePage;
import com.qamindslab.modulethree.configfiles.exercise.srctest.common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class FacebookViewerTest extends BaseTest {
    private FaceBookLoginPage facebookSignInPage;
    private FaceBookHomePage facebookHomePage;
    private FaceBookProfilePage facebookProfilePage;

    @BeforeClass
    void initializePages(){
        this.facebookSignInPage = new FaceBookLoginPage(this.driver);
    }

    @Test
    public void openFacebookPage(){
        facebookSignInPage.open();
        assertTrue(facebookSignInPage.isLoaded());
    }

    @Test(dependsOnMethods = {"openFacebookPage"})
    public void singInToFacebook() throws IOException {
        facebookSignInPage.setUserName("jesk801@hotmail.com");
        facebookSignInPage.setPassword();
        facebookHomePage = facebookSignInPage.clickLoginButton();
        assertTrue(facebookHomePage.isLoaded());
    }

    @Test(dependsOnMethods = {"singInToFacebook"})
    public void searchProfile() throws IOException, InterruptedException {
        facebookProfilePage = facebookHomePage.clickProfile();
        assertTrue(facebookProfilePage.isLoaded());
        Thread.sleep(5000);
    }

}