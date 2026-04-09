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

	@FindBy(className = "product-box-add-to-cart-button")
	private WebElement addToCartBtn;

	@FindBy(linkText = "Shopping cart")
	private WebElement shoppingCartBtn;

	@FindBy(id = "termsofservice")
	private WebElement termofserviceCheckBox;

	@FindBy(id = "checkout")
	private WebElement checkoutBtn;

	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryDD;

	public void selectCountry(String countryName) {
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.selectByvalue(countryDD, countryName);
	}

	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityEdit;

	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement address1Edit;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement zipEdit;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneNoEdit;

	@FindBy(xpath = "//input[@class='button-1 new-address-next-step-button']")
	private WebElement continueBtn;

	public void completeCheckout(String country, String city, String address, String zip, String phone) {

		addToCartBtn.click();
		shoppingCartBtn.click();
		termofserviceCheckBox.click();
		checkoutBtn.click();

		selectCountry(country);
		cityEdit.sendKeys(city);
		address1Edit.sendKeys(address);
		zipEdit.sendKeys(zip);
		phoneNoEdit.sendKeys(phone);

		continueBtn.click();
	}
}
