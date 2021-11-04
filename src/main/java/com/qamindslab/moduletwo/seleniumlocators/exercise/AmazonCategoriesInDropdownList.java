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
        driver.get("https://www.amazon.com.mx/");

        WebElement elemnt = driver.findElement(By.id("searchDropdownBox"));
        Select dropdown = new Select (elemnt);
        System.out.println("ID "+dropdown.getAllSelectedOptions());


        List<WebElement> opcions = dropdown.getAllSelectedOptions();
        for (WebElement product : opcions){
            System.out.println("all opcions"+product.getText());
        }



        if (dropdown.isMultiple()==true){
            System.out.println("multiplo"+elemnt.getText());
        }

        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByIndex(4);
        dropdown.selectByValue("Auto");
        driver.quit();

    }

}
