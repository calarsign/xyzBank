package com.planittesting.jupitertoys.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planittesting.jupitertoys.model.pages.HomePage;

import org.junit.jupiter.api.Test;

public class ContactTests extends BaseTestSuite
{

    @Test
    public void verifyIncorrectEmailError()
    {
        var emailError = new HomePage(driver)
            .clickContactMenu()
            .setEmail("notavalidemail")
            .getEmailError();

        assertEquals(
            "Please enter a valid email",
            emailError
        );
    }

    @Test
    public void verifyRequiredFieldsErrors()
    {
        var contactPage = new HomePage(driver)
            .clickContactMenu()
            .clickSubmitButton();

        assertEquals("Forename is required", contactPage.getForenameError());
        assertEquals("Email is required", contactPage.getEmailError());
        assertEquals("Message is required", contactPage.getMessageError());
    }

    @Test
    public void verifyMandatoryFieldErrorsCanBeFixed() {
        var contactPage = new HomePage(driver)
            .clickContactMenu()
            .clickSubmitButton()
            .setForename("Boris")
            .setEmail("boris@boris.com")
            .setMessage("Hello");
            
        assertEquals("", contactPage.getForenameError());
        assertEquals("", contactPage.getEmailError());
        assertEquals("", contactPage.getMessageError());
    }

    @Test
    public void verifyThanksMessageText(){
        var contactPage = new HomePage(driver)
            .clickContactMenu()
            .setForename("Maria")
            .setEmail("maria@yahoo.com")
            .setMessage("sample message")
            .clickSubmitButton()
            .waitToLoad();
        
            assertEquals("Thanks Maria, we appreciate your feedback.", contactPage.getThanksMessageText());
    }
}

