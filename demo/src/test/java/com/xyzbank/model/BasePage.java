package com.xyzbank.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    } 

    public HomePage clickHomePage(){
        driver.findElement(By.className("btn home")).click();
        return new HomePage(driver);
    }
}
