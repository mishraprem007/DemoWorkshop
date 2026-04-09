package com.workshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "product-box-add-to-cart-button")
	private WebElement addToCartBtn;

	@FindBy(linkText = "Shopping cart")
	private WebElement shoppingCartBtn;

	public void addToCart() {
		addToCartBtn.click();
		shoppingCartBtn.click();
	}
}
