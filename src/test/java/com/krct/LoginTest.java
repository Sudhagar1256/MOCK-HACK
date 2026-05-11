package com.krct;

import com.krct.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{


    @DataProvider
    public Object[][] loginData(){
        Object[][] data = new Object[][]{
                {"locked_out_user","secret_sauce"}
        };
        return data;
    }


    @Test
    public void case1Test()
    {
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver, wait);
        login.details("standard_user","secret_sauce");
        login.clickLogin();
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        Assert.assertTrue(msg.isDisplayed());
    }

    @Test(dataProvider = "loginData")
    public void case2Test(String name ,String key){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details(name,key);
        login.clickLogin();
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()= 'Epic sadface: Sorry, this user has been locked out.']")));
        Assert.assertTrue(error.isDisplayed());
    }
    @Test
    public void case3Test(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.clickLogin();
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Epic sadface: Username is required']")));
        Assert.assertTrue(error.isDisplayed());
    }

    @Test
    public void case4Test() {
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("standard_user","secret_sauce");
        login.clickLogin();
        login.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));

    }
}
