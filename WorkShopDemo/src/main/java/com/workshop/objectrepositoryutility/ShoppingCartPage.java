package com.workshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.workshop.generic.webdriverutility.WebDriverUtility;

public class ShoppingCartPage {
	WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "termsofservice")
	private WebElement termofserviceCheckBox;

	@FindBy(id = "checkout")
	private WebElement checkoutBtn;

	public void checkout() {
		SearchPage sp = new SearchPage(driver);
		sp.addToCart();
		termofserviceCheckBox.click();
		checkoutBtn.click();
	}

}
