package com.qamindslab.modulefour.srcmain.pageObject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qamindslab.modulefour.srcmain.common.BasePage;
import com.qamindslab.modulethree.configfiles.example.PropertyReader;
import com.qamindslab.modulethree.pom.example.googlesearch.srcmain.pageobjects.GoogleResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLogInPage extends BasePage {
    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/Spark.html"); // Timestamp
    ExtentTest extentTest;

    @FindBy(how = How.ID, using = "identifierNext")
    private WebElement nextUserButton;

    @FindBy(how = How.CSS, using = "#identifierId")
    private WebElement emailBox;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordBox;

    @FindBy(how = How.ID, using = "passwordNext")
    private WebElement nextPasswordButton;

    @FindBy(how = How.ID, using = "logo")
    private WebElement doddle;

    @FindBy(how = How.LINK_TEXT, using = "Gmail")
    private WebElement gmailLink;

    @FindBy(how = How.CSS, using = "div.OyEIQ.uSvLId > div:nth-child(2) > span")
    private WebElement messageInvalidPassword;

    @FindBy(how = How.CLASS_NAME, using = "o6cuMc")
    private WebElement messageEmailNotExist;

    public GmailLogInPage(WebDriver driver) {
        super(driver, PropertyReader.getProperty("selenium-configurations.properties", "GMAIL_URL"));
        extentReports.attachReporter(extentSparkReporter);
    }

    public void setUserEmail(String email){
        emailBox.clear();
        emailBox.sendKeys(email);
    }
    public void btnNext(){
        nextUserButton.click();

    }
    public void setUserPassword(String password){
        passwordBox.clear();
        passwordBox.sendKeys(password);
    }

    public GmailMainPage btnSigInGmail(){
        nextPasswordButton.click();
        return new GmailMainPage(driver);
    }

    public String emailNotExist(){
        return messageEmailNotExist.getText();
    }
    public String invalidPasswordMessage(){
        return messageInvalidPassword.getText();
    }

    @Override
    public boolean isLoaded(){
        extentTest = extentReports.createTest("Gmail Main Page.");

        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(doddle));
            logger.info("Gmail LogIn page loaded");

            extentTest.log(Status.PASS, "Gmail LogIn page loaded");
            extentReports.flush();

            return true;
        }catch (RuntimeException exception){
            logger.error("Gmail LogIn page was not loaded: " + exception);

            extentTest.log(Status.FAIL, "Gmail LogIn main page no loaded");
            extentReports.flush();

            return false;
        }
    }

}
