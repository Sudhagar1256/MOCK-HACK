package com.krct.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By username = By.id("user-name");
    protected By password = By.id("password");
    protected By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterUsername(String user){
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void details(String user, String pass){
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public void logout(){
        driver.findElement(By.id("react-burger-menu-btn")).click();
        WebElement logbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        logbtn.click();
    }
}