package com.qamindslab.moduletwo.seleniumlocators.example.select;

import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.ChromeBrowserDriver;
import com.qamindslab.moduleone.selenium.example.webdriver.instance.manager.withinterfaces.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getBrowserInstance(new ChromeBrowserDriver());

        driver.get("https://formy-project.herokuapp.com/form");

        // Find the select web element through id: 'select-menu'
        WebElement dropdownElement = driver.findElement(By.id("select-menu"));

        // Create an instance the Select object and pass the found dropdownlist.
        Select dropdownSelect = new Select(dropdownElement);
        System.out.println(dropdownSelect.getFirstSelectedOption().getText());

        List<WebElement> options = dropdownSelect.getOptions();

        for (WebElement option : options){
            System.out.println("VALUE ATTRIBUTE: " + option.getAttribute("value"));
            System.out.println("OPTION TEXT: " + option.getText());
        }

        dropdownSelect.selectByIndex(3);
        dropdownSelect.selectByValue("4");
        dropdownSelect.selectByVisibleText("5-9");
    }
}
