package com.qamindslab.moduletwo.seleniumlocators.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonCategoriesInDropdownList {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com.mx");
        WebElement dropdownElement = driver.findElement(By.id("searchDropdownBox"));
        Select dropdownAmazon = new Select(dropdownElement);

        //List<WebElement> allOptions = dropdownAmazon.getOptions();
        for (WebElement option: dropdownAmazon.getOptions()) {
            System.out.println(option.getText());
        }

        System.out.println(dropdownAmazon.isMultiple() ? "It's Multiple Dropdown." : "It's not Multiple Dropdown.");
        /*if(dropdownAmazon.isMultiple() == true){
            System.out.println("Sí es múltiple");
        }*/

        System.out.println("Primera opción: " + dropdownAmazon.getFirstSelectedOption().getText());

        dropdownElement.click();
        dropdownAmazon.selectByIndex(4);

        dropdownElement.click();
        dropdownAmazon.selectByValue("Auto");

        driver.quit();
    }
}