package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProblemUserPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProblemUserPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public boolean productsDisplayed(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list"))).isDisplayed();
    }

    public void addProduct(){
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        addBtn.click();
    }

    public void openCart(){
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartBtn.click();
    }

    public String cartCount(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge"))).getText();
    }


    public String imageSource(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_img"))).getAttribute("src");
    }
}