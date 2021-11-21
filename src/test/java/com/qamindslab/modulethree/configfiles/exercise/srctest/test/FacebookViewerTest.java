package com.qamindslab.modulethree.configfiles.exercise.srctest.test;

import com.qamindslab.modulethree.configfiles.example.PropertyReader;
import com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects.FacebookHomePage;
import com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects.FacebookLoginPage;
import com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects.FacebookProfilePage;
import com.qamindslab.modulethree.configfiles.exercise.srctest.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FacebookViewerTest extends BaseTest {

    private FacebookLoginPage loginPage;
    private FacebookHomePage facebookHomePage;
    private FacebookProfilePage profilePage;

    @BeforeClass
    public void initializeGooglePage(){
        this.loginPage = new FacebookLoginPage(this.driver);
        this.facebookHomePage = null;
    }

    @Test
    public void openFacebook(){
        loginPage.open();
        Assert.assertTrue(loginPage.isLoaded());
    }

    @Test(description = "Login to Facebook", dependsOnMethods = {"openFacebook"})
    public void login(){
        String email = PropertyReader.getProperty("selenium-configurations.properties", "FACEBOOK_EMAIL");
        String password = PropertyReader.getProperty("selenium-configurations.properties", "FACEBOOK_PASSWORD");

        facebookHomePage = loginPage.login(email, password);
        assertTrue(facebookHomePage.isLoaded());
    }

    @Test(description = "Click next button", dependsOnMethods = {"login"})
    public void goToProfile(){
        profilePage = facebookHomePage.clickOnProfile();
    }

    @Test(description = "Click next button", dependsOnMethods = {"goToProfile"})
    public void selectAbout(){
        profilePage.selectAbout();
    }

    @Test(description = "Click next button", dependsOnMethods = {"selectAbout"})
    public void selectFriends(){
        profilePage.selectFriends();
    }

    @Test(description = "Click next button", dependsOnMethods = {"selectFriends"})
    public void selectPhotos(){
        profilePage.selectPhotos();
    }

    @Test(description = "Click next button", dependsOnMethods = {"selectPhotos"})
    public void getFirstPostText(){
        profilePage.selectPosts();
        profilePage.getTimelinePosts();
        System.out.println(profilePage.getTimelinePosts().get(0).getDescription());
    }

    @Test(description = "Search friends", dependsOnMethods = {"getFirstPostText"})
    public void searchFriends() {
        driver.get("https://www.facebook.com/");
        facebookHomePage.searchFriends();
    }
}
