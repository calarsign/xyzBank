package com.xyzbank.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xyzbank.model.HomePage;

import org.junit.jupiter.api.Test;

public class CustomerDepositTest extends BaseTestSuite {
    
    @Test
    public void customerDeposit() {
        String customerName = "Hermoine Granger";

        var customerLoginPage = new HomePage(driver)
        .clickCustomerLoginPage()
        .setYourName(customerName)
        .clickLoginButton()
        .clickDepositButton()
        .setAmountDepositInput(1000)
        .clickSubmitDepositButton();

        assertEquals("Deposit Successful", customerLoginPage.getDepositSuccessfulMessage());
        assertEquals(customerName, customerLoginPage.getWelcomeName());
        assertEquals("6096", customerLoginPage.getBalance());

    }

}