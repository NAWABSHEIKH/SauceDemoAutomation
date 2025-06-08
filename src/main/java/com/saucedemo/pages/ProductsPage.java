package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']/following::button[1]")
    private WebElement addToCartBackpack;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addBackpackToCart() {
        addToCartBackpack.click();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }
}
