package com.xyzbank.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import com.xyzbank.model.HomePage;

import org.junit.jupiter.api.Test;

public class AddCustomerTest extends BaseTestSuite{
    
    @Test
    public void addCustomerRequiredFields() {
        var bankManagerLoginPage = new HomePage(driver)
        .clickBankManagerLoginPage()
        .clickAddCustomerButton()
        .setFirstName("Maria")
        .setLastName("Cortez")
        .setPostCode("2000")
        .clickSubmitCustomerButton();
        
        var alertString = bankManagerLoginPage.getAlertConfirmation();
        System.out.println(alertString);

        assertEquals("Customer added successfully with customer id :6", alertString);
        //assertTrue(alertString.contains("Customer added successfully with customer id :"));
        //returns true if alert contains "Customer added successfully with customer id :"
    }

    @Test
    public void checkExistingAccount() {
        var bankManagerLoginPage = new HomePage(driver)
        .clickBankManagerLoginPage()
        .clickAddCustomerButton()
        .setFirstName("Hermoine")
        .setLastName("Granger")
        .setPostCode("E859AB")
        .clickSubmitCustomerButton();
        
        var alertString = bankManagerLoginPage.getAlertConfirmation();
        System.out.println(alertString);
        
        assertEquals("Please check the details. Customer may be duplicate.", alertString);
       
    }
}
