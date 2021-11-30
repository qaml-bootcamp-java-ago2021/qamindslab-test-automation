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

    @FindBy(how = How.CSS, using = "#\\:4 > div > div.nH.aqK > div.Cq.aqL > div > div > div:nth-child(5) > div")
    public  WebElement btnActualizar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a")
    public  WebElement profile;


    public GmailMainPage(WebDriver driver) {
        super(driver, PropertyReader.getProperty("selenium-configurations.properties", "GMAIL_URL"));
        extentReports.attachReporter(extentSparkReporter);
    }
    public String getPrincipalLabel(){ return principal.getText(); }
    public String getSocialLabel(){ return social.getText();}
    public String getPromotionsLabel(){ return promotions.getText();}


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
