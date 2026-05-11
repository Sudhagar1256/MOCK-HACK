package com.krct.tests;

import com.krct.BaseTest;
import com.krct.pages.CheckoutPage;
import com.krct.pages.LoginPage;
import com.krct.pages.ProductPage;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutFlowTest() {

        try {
            driver.get(loginurl);
            LoginPage login = new LoginPage(driver, wait);
            login.details("standard_user", "secret_sauce");
            ProductPage product = new ProductPage(driver, wait);
            product.addToCart();
            product.openCartt();
            CheckoutPage checkout = new CheckoutPage(driver, wait);
            checkout.clickCheckout();
            checkout.enterDetails("Sudhagar", "P", "600001");
            checkout.clickContinue();
            Assert.assertEquals(checkout.getProductName(), "Sauce Labs Backpack");
            Assert.assertTrue(checkout.getTotalPrice().contains("32.39"));
            checkout.clickFinish();
            Assert.assertEquals(checkout.confirmationMessage(), "Thank you for your order!");

        } catch (Exception e) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                File destination = new File("screenshot.png");
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot Taken");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}