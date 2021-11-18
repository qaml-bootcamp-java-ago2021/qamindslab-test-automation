package com.qamindslab.modulethree.pom.example.googlesignin.srctest.test;

import com.qamindslab.modulethree.pom.example.googlesignin.srcmain.pageobjects.GoogleSignIn;
import com.qamindslab.modulethree.pom.example.googlesignin.srctest.common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class GoogleSignInTest extends BaseTest {
    private GoogleSignIn googleSignIn;

    @BeforeClass
    void initializeGoogleSiginInPage(){
        this.googleSignIn = new GoogleSignIn(this.driver);
    }

    @Test
    public void openGoogleSignIn(){
        googleSignIn.open();
        assertTrue(googleSignIn.isLoaded());
    }
}
