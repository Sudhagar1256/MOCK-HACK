package com.krct;

import com.krct.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

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
        login.details(config.getUsername(), config.getPassword());
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        Assert.assertTrue(msg.isDisplayed());
    }

    @Test(dataProvider = "loginData")
    public void case2Test(String name ,String key){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details(name,key);
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
        login.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));

    }


    @Test
    public void case5Test(){
        try{
            driver.get(loginurl);
            LoginPage login = new LoginPage(driver,wait);
            login.details("sudhagar", "secret_sauce");
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

        }catch (AssertionError e){
            try{
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                File destination = new File("screenshots/LoginError.png");
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot Taken");

            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }
}
