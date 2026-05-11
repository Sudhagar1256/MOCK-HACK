package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void add1Product(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void add2Product(){
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    public String cartCount(){
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }

    public void openCart(){
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public void removeProduct(){

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    public boolean productDisplayed(){
        return driver.findElements(By.className("inventory_item_name")).size() > 0;
    }

    public void continueShop(){
        driver.findElement(By.id("continue-shopping")).click();
    }
}