package com.qamindslab.moduleone.selenium.exercise.webdriver.commonmethods.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class TagsFrequencyCount {

    public static void main(String [] args){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //String codigoFuente = driver.getPageSource();
        /*
        StringTokenizer cadenaToken = new StringTokenizer(codigoFuente);
        String palabraBuscar = "function";
        int contador = 0;

        driver.get("https://www.google.com");

        while(cadenaToken.hasMoreElements()){
            if(cadenaToken.nextElement().equals(palabraBuscar)){
                contador ++;
            }

        }
        System.out.println(palabraBuscar + " aparece " + contador+ " veces");

         */



    }

}

