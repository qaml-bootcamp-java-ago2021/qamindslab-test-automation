package com.qamindslab.modulethree.testng.exercise.withwebdriver;
import com.qamindslab.modulethree.testng.example.withwebdriver.common.BaseTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleURLTest extends BaseTest {

    @Test(description = "Google open", alwaysRun = true, groups= {"regression"})
    @Parameters({"baseUrl"})
    public void validateGoogleUrl(@Optional("") String baseUrl){
        //Arrange
        String expected = baseUrl;
        driver.get("https://www.google.com/");

        //Act
        String actual = driver.getCurrentUrl();

        //Assert
        assertEquals(actual, expected, "Url incorrecta.");
    }
}
