package com.xyzbank.model;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankManagerLoginPage extends BasePage {

    public BankManagerLoginPage(WebDriver driver){
        super(driver);
    }

    public BankManagerLoginPage clickAddCustomerButton(){
        driver.findElement(By.xpath("//button[@ng-click='addCust()']")).click();
        return this;
    }

    public BankManagerLoginPage setFirstName(String firstName) {
       driver.findElement(By.xpath("//input[@ng-model='fName']")).sendKeys(firstName);
       return this;
    }

    public BankManagerLoginPage setLastName(String lastName) {
        driver.findElement(By.xpath("//input[@ng-model='lName']")).sendKeys(lastName);
        return this;
    }

    public BankManagerLoginPage setPostCode(String postCode) {
        driver.findElement(By.xpath("//input[@ng-model='postCd']")).sendKeys(postCode);
        return this;
    }

    public BankManagerLoginPage clickSubmitCustomerButton() {
        driver.findElement(By.className("btn-default")).click();
        return this;
    }
    
    public String getAlertConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        return text;
    }
}
