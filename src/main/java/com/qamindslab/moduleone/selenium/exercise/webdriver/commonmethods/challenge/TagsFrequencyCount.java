package com.qamindslab.moduleone.selenium.exercise.webdriver.commonmethods.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagsFrequencyCount {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(1000);

        // https://www.freeformatter.com/java-regex-tester.html#ad-output
        String pageSource = driver.getPageSource();
        String [] numberOfFunctionWord = pageSource.split("function");
        String [] numberOfScriptWord = pageSource.split("script");
        String [] numberOfClass = pageSource.split(" class=");
        String [] numberOfIds = pageSource.split(" id=");

        System.out.println("function word appears " + numberOfFunctionWord.length + " times in the page source code.");
        System.out.println("script word appears " + numberOfScriptWord.length + " times in the page source code.");
        System.out.println("class word appears " + numberOfClass.length + " times in the page source code.");
        System.out.println("id word appears " + numberOfIds.length + " times in the page source code.");

        driver.close();
    }
}
