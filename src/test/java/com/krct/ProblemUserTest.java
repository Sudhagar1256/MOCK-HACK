package com.krct;

import com.krct.pages.LoginPage;
import com.krct.pages.ProblemUserPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProblemUserTest extends BaseTest{

    @Test
    public void problemUserTest1(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("problem_user", "secret_sauce");
        ProblemUserPage problem = new ProblemUserPage(driver,wait);
        Assert.assertTrue(problem.productsDisplayed());
    }

    @Test
    public void problemUserTest2(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("problem_user", "secret_sauce");
        ProblemUserPage problem = new ProblemUserPage(driver,wait);
        problem.addProduct();
        Assert.assertEquals(problem.cartCount(), "1");
    }


    @Test
    public void problemUserTest3(){
        driver.get(loginurl);
        LoginPage login = new LoginPage(driver,wait);
        login.details("problem_user", "secret_sauce");
        ProblemUserPage problem = new ProblemUserPage(driver,wait);
        String image = problem.imageSource();
        Assert.assertNull(image);
    }
}