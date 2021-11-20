package com.qamindslab.modulethree.pom.example.googlesearch.srctest.test;

import com.qamindslab.modulethree.pom.example.googlesearch.srcmain.pageobjects.GoogleMainPage;
import com.qamindslab.modulethree.pom.example.googlesearch.srcmain.pageobjects.GoogleResultsPage;
import com.qamindslab.modulethree.pom.example.googlesearch.srctest.common.BaseTest;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleSearchTest extends BaseTest {
    private GoogleMainPage googleMainPage;
    private GoogleResultsPage googleResultsPage;

    @BeforeClass
    public void initializeGoogleMainPage(){
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultsPage = null;
    }

    @Test
    public void openGoogle(){
        googleMainPage.open();
        Assert.assertTrue(googleMainPage.isLoaded());
    }

    @Test(description = "Search something in google", dependsOnMethods = {"openGoogle"})
    public void searchInGoogle(){
        String expected = "Matrix - Buscar con Google";

        this.googleResultsPage = this.googleMainPage.searchInGoogle("Matrix");
        String actual = googleResultsPage.currentSearch();

        //assertTrue(this.resultsPage.isLoaded());
        assertEquals(actual, expected, "Incorrect Search url.");
    }


    @Test(description = "Search something again", dependsOnMethods = {"searchInGoogle"})
    public void performNewSearch(){
        String expected = "Die Hard 4.0 - Buscar con Google";

        this.googleResultsPage = this.googleResultsPage.search("Die Hard 4.0");
        String actual = googleResultsPage.currentSearch();

        //assertTrue(this.resultsPage.isLoaded());
        assertEquals(actual, expected, "Incorrect Search url.");
    }

    @Test(description = "Click next button", dependsOnMethods = {"performNewSearch"})
    public void clickNextResults(){
        String expected = "Die Hard 4.0 - Buscar con Google";

        this.googleResultsPage.nextResultPage();
        String actual = driver.getTitle();

        //assertTrue(this.resultsPage.isLoaded());
        assertEquals(actual, expected, "Page title is incorrect.");
    }


    @Test(description = "Click prev button", dependsOnMethods = {"clickNextResults"})
    public void clickPrevResults(){
        String expected = "Die Hard 4.0 - Buscar con Google";

        this.googleResultsPage.prevResultPage();
        String actual = driver.getTitle();

        //assertTrue(this.resultsPage.isLoaded());
        assertEquals(actual, expected, "Page title is incorrect.");
    }

    @Test(description = "Search first result found", dependsOnMethods = {"clickPrevResults"})
    public void selectFirstResult(){
        String expected = "Live Free or Die Hard - Wikipedia, la enciclopedia libre";

        String actual = googleResultsPage.getResults().get(0).getTitle();

        assertEquals(actual, expected, "Incorrect Title.");
    }
}
