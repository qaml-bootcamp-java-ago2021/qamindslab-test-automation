package com.qamindslab.moduleone.selenium.exercise.webdriver.commonmethods.challenge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagsFrequencyCount {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(1000);

        String sourse = driver.getPageSource();
        String [] funcion = sourse.split("funcion");
        System.out.println("funcion: "+funcion.length);

        String [] script = sourse.split("script");
        System.out.println("script: "+script.length);

        String [] clas = sourse.split("Class");
        System.out.println("Class: "+clas.length);

        String [] id = sourse.split("Id");
        System.out.println("Id: "+id.length);
        driver.close();
    }

}
