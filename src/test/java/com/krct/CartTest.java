package com.krct;

import com.krct.pages.CartPage;
import com.krct.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void cartTest1(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("standard_user","secret_sauce");
        CartPage cart = new CartPage(driver,wait);
        cart.add1Product();
        Assert.assertEquals(cart.cartCount(), "1");
    }

    @Test
    public void cartTest2(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("standard_user","secret_sauce");
        CartPage cart = new CartPage(driver,wait);
        cart.add1Product();
        cart.add2Product();
        Assert.assertEquals(cart.cartCount(), "2");
    }

    @Test
    public void cartTest3(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("standard_user","secret_sauce");
        CartPage cart = new CartPage(driver,wait);
        cart.add1Product();
        cart.openCart();
        cart.removeProduct();
        Assert.assertFalse(cart.productDisplayed());
    }

    @Test
    public void cartTest4(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("standard_user","secret_sauce");
        CartPage cart = new CartPage(driver,wait);
        cart.add1Product();
        cart.openCart();
        cart.continueShop();
        cart.openCart();
        Assert.assertTrue(cart.productDisplayed());
    }
}