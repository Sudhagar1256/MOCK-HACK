package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void clickCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout"))).click();
    }

    public void enterDetails(String fname, String lname, String zip) {
        driver.findElement(By.id("first-name")).sendKeys(fname);
        driver.findElement(By.id("last-name")).sendKeys(lname);
        driver.findElement(By.id("postal-code")).sendKeys(zip);
    }

    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    public String getProductName() {
        return driver.findElement(
                By.className("inventory_item_name")).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(
                By.className("summary_total_label")).getText();
    }

    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }

    public String confirmationMessage() {
        return driver.findElement(
                By.className("complete-header")).getText();
    }
}