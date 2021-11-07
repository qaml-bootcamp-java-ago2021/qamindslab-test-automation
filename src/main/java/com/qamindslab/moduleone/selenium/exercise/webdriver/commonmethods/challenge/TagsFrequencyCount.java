package com.qamindslab.moduleone.selenium.exercise.webdriver.commonmethods.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;
import java.util.HashMap;

public class TagsFrequencyCount {

    public static void main(String [] args){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        String codigoFuente = driver.getPageSource();

        String [] repeticionesFuncion = codigoFuente.split("function");
        String [] repeticionesScript = codigoFuente.split("script");
        String [] repeticionesClass = codigoFuente.split("class");
        String [] repeticionesID = codigoFuente.split("id");

        System.out.println("Function aparece: "+ repeticionesFuncion.length);
        System.out.println("Script aparece: "+ repeticionesScript.length);
        System.out.println("Class aparece: "+ repeticionesClass.length);
        System.out.println("Id  aparece: "+ repeticionesID.length);

        /*
        String palabra= "function";
        int repeticion = 0;
        for(int index=0; index < codigoFuente.length(); index ++ ){
            codigoFuente.substring(index).startsWith(palabra);
            repeticion++;
        }
        System.out.println("Function aparece: "+ repeticion);
        */
    }

}

