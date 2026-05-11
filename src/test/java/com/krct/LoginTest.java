package com.krct;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void LoginTest()
    {
        driver.get("https://www.saucedemo.com/");
    }
}
