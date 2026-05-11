// CheckoutTest.java

package com.krct;

import com.krct.pages.CheckoutPage;
import com.krct.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkoutTest(){

        driver.get(loginurl);

        LoginPage login = new LoginPage(driver,wait);

        login.details("standard_user","secret_sauce");

        CheckoutPage checkout =
                new CheckoutPage(driver,wait);

        checkout.addProduct();

        checkout.openCart();

        checkout.checkout();

        checkout.customerDetails();

        // Verify product name
        Assert.assertEquals(
                checkout.summaryProduct(),
                "Sauce Labs Backpack"
        );

        // Verify total price displayed
        Assert.assertTrue(
                checkout.totalPrice().contains("Total")
        );

        // Finish order
        checkout.finishOrder();

        // Verify confirmation
        Assert.assertEquals(
                checkout.confirmMessage(),
                "Thank you for your order!"
        );
    }
}