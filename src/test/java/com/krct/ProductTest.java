package com.krct;

import com.krct.pages.LoginPage;
import com.krct.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productTest1(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("standard_user","secret_sauce");
        ProductPage product = new ProductPage(driver,wait);
        Assert.assertTrue(product.checking());
    }

    @Test
    public void productTest2(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("standard_user","secret_sauce");

        ProductPage product = new ProductPage(driver,wait);
        product.sortProducts();
        Assert.assertEquals(product.firstProduct(),"Sauce Labs Backpack");
    }

    @Test
    public void productTest3(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("standard_user","secret_sauce");
        ProductPage product = new ProductPage(driver,wait);
        product.sortPrice();
        Assert.assertEquals(product.firstPrice(),"$7.99");
    }

    @Test
    public void productTest4(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("standard_user","secret_sauce");
        ProductPage product = new ProductPage(driver,wait);
        String name = product.productName();
        String price = product.productPrice();
        product.openProduct();
        Assert.assertEquals(product.insideName(),name);
        Assert.assertEquals(product.insidePrice(),price);
    }
}
