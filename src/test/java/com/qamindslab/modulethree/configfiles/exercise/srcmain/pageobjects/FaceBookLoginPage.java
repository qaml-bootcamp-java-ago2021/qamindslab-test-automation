package com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects;

import com.qamindslab.modulefour.instructions.srcmain.common.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FaceBookLoginPage extends BasePage {
    protected final Logger logger = LogManager.getLogger(FaceBookLoginPage.class);

    @FindBy(how = How.ID, using = "email")
    private WebElement emailInput;

    @FindBy(how = How.ID, using = "pass")
    private WebElement passwordInput;

    @FindBy(how = How.NAME, using = "login")
    private WebElement loginButton;

    public FaceBookLoginPage(WebDriver driver) {
        super(driver, "https://www.facebook.com");
    }

    public void setUserName(String userName){
        emailInput.sendKeys(userName);
    }

    public void setPassword() throws IOException {
        passwordInput.sendKeys(readFile("/home/serrano/pass.txt",  StandardCharsets.US_ASCII));
    }

    public FaceBookHomePage clickLoginButton(){
        loginButton.click();

        return new FaceBookHomePage(driver);
    }

    private  String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding).replaceAll("\\r|\\n", "");
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(emailInput));
            logger.info("Inbox Page was loaded");
            return true;
        }catch(RuntimeException ex){
            logger.info("Inbox Page was not loaded. " + ex);
            return false;
        }
    }
}