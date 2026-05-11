package com.krct.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ProductPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String loginurl = "https://www.saucedemo.com/";

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean checking(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']"))).isDisplayed();

    }

    public void sortProducts(){
        WebElement drop = driver.findElement(By.className("product_sort_container"));
        Select dropdown = new Select(drop);
        dropdown.selectByVisibleText("Name (A to Z)");

    }

    public String firstProduct(){
        return driver.findElement(By.className("inventory_item_name")).getText();
    }

    public void sortPrice(){

        WebElement drop = driver.findElement(By.className("product_sort_container"));
        Select dropdown = new Select(drop);
        dropdown.selectByVisibleText("Price (low to high)");

    }

    public String firstPrice(){
        return driver.findElement(By.className("inventory_item_price")).getText();
    }

    public String productName(){
        return driver.findElement(By.className("inventory_item_name")).getText();
    }

    public String productPrice(){
        return driver.findElement(By.className("inventory_item_price")).getText();
    }

    public void openProduct(){
        driver.findElement(By.className("inventory_item_name")).click();

    }
    public String insideName(){
        return driver.findElement(By.className("inventory_details_name")).getText();
    }

    public String insidePrice(){
        return driver.findElement(By.className("inventory_details_price")).getText();
    }
    public void addToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
    public void openCartt() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }


}
