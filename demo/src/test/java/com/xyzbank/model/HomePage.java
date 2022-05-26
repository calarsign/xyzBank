package com.xyzbank.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CustomerLoginPage clickCustomerLoginPage(){
        driver.findElement(By.xpath("//button[@ng-click='customer()']")).click();
        return new CustomerLoginPage(driver);
    }

    public BankManagerLoginPage clickBankManagerLoginPage(){
        driver.findElement(By.xpath("//button[@ng-click='manager()']")).click();
        return new BankManagerLoginPage(driver);
    }
}
