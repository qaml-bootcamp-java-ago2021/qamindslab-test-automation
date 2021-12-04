package com.qamindslab.modulefour.srcmain.pageObject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qamindslab.modulefour.srcmain.common.BasePage;
import com.qamindslab.modulethree.configfiles.example.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailMainPage extends BasePage {
    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/Spark.html"); // Timestamp
    ExtentTest extentTest;

    @FindBy(how = How.XPATH, using = ".//div[contains(text(),'Redactar')]")
    public WebElement redactarButton;

    @FindBy(how = How.CSS, using = "img[class='gb_tc']")
    private WebElement googleLogo;

    @FindBy(how = How.XPATH, using = "//*[@id=':1t']")
    private WebElement principal;

    @FindBy(how = How.XPATH, using = "//*[@id=':1x']")
    private WebElement social;

    @FindBy(how = How.XPATH, using = "//*[@id=':1y']")
    private WebElement promotions;

    @FindBy(how = How.CSS, using = "div.T-I.J-J5-Ji.nu")
    public  WebElement btnActualizar;

    @FindBy(how = How.CSS, using = "a.gb_C.gb_Ma.gb_h>img.gb_Ca.gbii")
    public  WebElement profile;

    @FindBy(how = How.CSS, using = "#gb > div.gb_Fd.gb_Wd.gb_Md > div.gb_0a.gb_E.gb_k.gb_1a.gb_la > div.gb_9a > div.gb_bb > div.gb_lb.gb_mb")
    public  WebElement profileName;

    @FindBy(how = How.CSS, using = "div[class='gb_bb']>div.gb_nb")
    public  WebElement profileEmail;

    @FindBy(how = How.CSS, using = "div[class='TN bzz aHS-bnu']")
    public  WebElement sentButton;

    @FindBy(how = How.CSS, using = "div[class='TN bzz aHS-bnu']")
    public  WebElement theEmailRowSent;


    public GmailMainPage(WebDriver driver) {
        super(driver, PropertyReader.getProperty("selenium-configurations.properties", "GMAIL_URL"));
        extentReports.attachReporter(extentSparkReporter);
    }
    public String getPrincipalLabel(){ return principal.getText(); }
    public String getSocialLabel(){ return social.getText();}
    public String getPromotionsLabel(){ return promotions.getText();}
    public void clickOnProfileButton(){profile.click();}
    public EmailEditorDialogPage clickOnComposeButton(){redactarButton.click();
        return new EmailEditorDialogPage(driver);
    }

    @Override
    public boolean isLoaded(){
        extentTest = extentReports.createTest("Gmail Main Page.");

        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(googleLogo));
            logger.info("Gmail Main page loaded");

            extentTest.log(Status.PASS, "Gmail Main page loaded");
            extentReports.flush();
            return true;
        }catch (RuntimeException exception){
            logger.error("Gmail Main page was not loaded: " + exception);

            extentTest.log(Status.FAIL, "Gmail main page no loaded");
            extentReports.flush();

            return false;
        }

    }


}
