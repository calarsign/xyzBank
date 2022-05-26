package com.xyzbank.model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage extends BasePage {

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }
    public CustomerLoginPage setYourName(String yourName) {
        driver.findElement(By.id("userSelect")).sendKeys(yourName);
        return this;
     }

     public CustomerLoginPage clickLoginButton() {
         driver.findElement(By.className("btn-default")).click();
         return this;
     }

     public CustomerLoginPage clickDepositButton() {
        driver.findElement(By.xpath("//button[@ng-click='deposit()']")).click();
        return this;
     }

     public CustomerLoginPage setAmountDepositInput(int amount) {
        String s = String.valueOf(amount);
        driver.findElement(By.xpath("//input[@ng-model='amount']")).sendKeys(s);
        return this;
     }

     public CustomerLoginPage clickSubmitDepositButton() {
         driver.findElement(By.className("btn-default")).click();
         return this;
     }
 
     public String getDepositSuccessfulMessage() {
        return driver.findElement(By.xpath("//span[@ng-show='message']")).getText();

     }

     public String getWelcomeName() {
        return driver.findElements(By.cssSelector("span.fontBig.ng-binding")).get(0).getText();

     }

     public String getBalance() {
        return driver.findElements(By.cssSelector("strong.ng-binding")).get(1).getText();
     }





     

}
