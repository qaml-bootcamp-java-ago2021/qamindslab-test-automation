package com.qamindslab.modulefour.srcmain.pageObject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qamindslab.modulefour.srcmain.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailEditorDialogPage extends BasePage {
    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/Spark.html"); // Timestamp
    ExtentTest extentTest;

    @FindBy(how = How.CSS, using = "div[class='nH Hd']")
    private WebElement emailEditorDialogOpen;

    @FindBy(how = How.NAME, using = "to")
    public WebElement to;

    @FindBy(how = How.NAME, using = "subjectbox")
    public WebElement subjectbox;

    @FindBy(how = How.CSS, using = "span[class='aB  gQ pB']")
    private WebElement bccLink;

    @FindBy(how = How.NAME, using = "bcc")
    private WebElement bbcArea;

    @FindBy(how = How.CSS, using = "span[class='aB gQ pE']")
    private WebElement cclink;

    @FindBy(how = How.NAME, using = "cc")
    private WebElement ccArea;

    @FindBy(how = How.CSS, using = "div.Ar.Au>div.Am.Al.editable.LW-avf.tS-tW")
    private WebElement messageTextArea;

    @FindBy(how = How.CSS, using = "div[class='dC'] > div[class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendButton1;

    @FindBy(how = How.CSS, using = "div[class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendButton;




    public EmailEditorDialogPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        extentReports.attachReporter(extentSparkReporter);
    }

    public void sendEmail(String email_to, String email_cc, String email_bcc, String emailSubject, String message ) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(to),
                ExpectedConditions.visibilityOf(subjectbox)));
        to.click();
        to.sendKeys(email_to);

        cclink.click();
        ccArea.sendKeys(email_cc);

        bccLink.click();
        bbcArea.sendKeys(email_bcc);

        subjectbox.sendKeys(emailSubject);
        messageTextArea.sendKeys(message);

        sendButton.click();

    }

    @Override
    public boolean isLoaded(){
        extentTest = extentReports.createTest("Email Editor dialog Page.");

        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(emailEditorDialogOpen));
            logger.info("Email Editor dialog loaded");

            extentTest.log(Status.PASS, "Email Editor dialog loaded");
            extentReports.flush();
            return true;
        }catch (RuntimeException exception){
            logger.error("Email Editor dialog was not loaded: " + exception);

            extentTest.log(Status.FAIL, "Email Editor dialog no loaded");
            extentReports.flush();

            return false;
        }

    }


}
