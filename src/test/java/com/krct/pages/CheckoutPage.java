package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    // Add product
    public void addProduct(){

        driver.findElement(
                        By.id("add-to-cart-sauce-labs-backpack"))
                .click();
    }

    // Open cart
    public void openCart(){

        driver.findElement(
                        By.className("shopping_cart_link"))
                .click();
    }

    // Checkout click
    public void checkout(){

        WebElement checkoutBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("checkout"))
        );

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                checkoutBtn
        );

        js.executeScript(
                "arguments[0].click();",
                checkoutBtn
        );

        // VERIFY NEXT PAGE
        wait.until(
                ExpectedConditions.urlContains(
                        "checkout-step-one"
                )
        );
    }

    // Fill customer details
    public void customerDetails(){

        driver.findElement(
                        By.id("first-name"))
                .sendKeys("Sudhagar");

        driver.findElement(
                        By.id("last-name"))
                .sendKeys("P");

        driver.findElement(
                        By.id("postal-code"))
                .sendKeys("625001");

        driver.findElement(
                        By.id("continue"))
                .click();
    }

    // Product name in summary
    public String summaryProduct(){

        return driver.findElement(
                        By.className("inventory_item_name"))
                .getText();
    }

    // Total price
    public String totalPrice(){

        return driver.findElement(
                        By.className("summary_total_label"))
                .getText();
    }

    // Finish order
    public void finishOrder(){

        driver.findElement(
                        By.id("finish"))
                .click();
    }

    // Confirmation message
    public String confirmMessage(){

        return driver.findElement(
                        By.className("complete-header"))
                .getText();
    }
}