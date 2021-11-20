package com.qamindslab.modulethree.testng.exercise.withwebdriver;

import com.qamindslab.modulethree.testng.exercise.withwebdriver.common.BaseTest;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GoogleURLTest extends BaseTest {

    @Test(description = "Open google page and verify url", alwaysRun = true, groups= {"regression"})
    @Parameters({"baseUrl"})
    public void openGoogle(@Optional("") String baseUrl){
        driver.get("https://www.google.com.mx/");
        assertEquals(driver.getCurrentUrl(), baseUrl, "Didn't get expected google url");
    }
}
