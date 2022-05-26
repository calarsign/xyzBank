package com.planittesting.jupitertoys.model.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage setEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
        return this;
    }

    private String getErrorText(String id) {
        var elements = driver.findElements(By.id(id));
        if (elements.size() == 0) return "";
        return elements.get(0).getText();
    }

    public String getEmailError() {
        return getErrorText("email-err");
    }

    public String getForenameError() {
        return getErrorText("forename-err");
    }

    public String getMessageError() {
        return getErrorText("message-err");
    }

    public ContactPage clickSubmitButton() {
        driver.findElement(By.className("btn-contact")).click();
        return this;
    }

    public ContactPage setForename(String forename) {
        driver.findElement(By.id("forename")).sendKeys(forename);
        return this;
    }

    public ContactPage setMessage(String message) {
        driver.findElement(By.id("message")).sendKeys(message);
        return this;
    }

    public ContactPage waitToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        return this;
    }

    public String getThanksMessageText(){
        return driver.findElement(By.xpath(("//div[@class='alert alert-success']"))).getText();  
    }
}
