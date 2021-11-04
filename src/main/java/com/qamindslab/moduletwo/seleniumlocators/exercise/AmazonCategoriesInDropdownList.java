package com.qamindslab.moduletwo.seleniumlocators.exercise;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AmazonCategoriesInDropdownList {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");

        WebElement elementDropdown = driver.findElement(By.id("searchDropdownBox"));
        Select searchDropdown = new Select(elementDropdown);

        for (WebElement option: searchDropdown.getOptions()) {
            System.out.println(option.getText());
        }

        System.out.println(searchDropdown.isMultiple() ? "It's Multiple Dropdown." : "It's not Multiple Dropdown.");

        System.out.println("The first selected option is: " + searchDropdown.getFirstSelectedOption().getText());

        elementDropdown.click();
        searchDropdown.selectByIndex(0);

        elementDropdown.click();
        searchDropdown.selectByValue("search-alias=automotive");

        for(WebElement selectedOption : searchDropdown.getAllSelectedOptions()){
            System.out.println("SELECTED OPTIONS: " + selectedOption.getText());
        }

        driver.quit();
    }
}
