package com.workshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.workshop.generic.webdriverutility.WebDriverUtility;

public class CheckOutPage {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		sp.checkout();
		selectCountry(country);
		cityEdit.sendKeys(city);
		address1Edit.sendKeys(address);
		zipEdit.sendKeys(zip);
		phoneNoEdit.sendKeys(phone);
		continueBtn.click();
	}

	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	private WebElement contiuneBtn;

	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	private WebElement contiuneBtn_shipping;

	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	private WebElement contiuneBtn_shippingMethod;

	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	private WebElement contiuneBtn_paymentMethod;

	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	private WebElement contiuneBtn_paymentInfo;

	public void continueOrder() {
		contiuneBtn.click();
		contiuneBtn_shipping.click();
		contiuneBtn_shippingMethod.click();
		contiuneBtn_paymentMethod.click();
		contiuneBtn_paymentInfo.click();
	}

	@FindBy(xpath = "//a[@class='product-name']")
	private WebElement productNameText;

	public WebElement getProductNameText() {
		return productNameText;
	}

	public WebElement getConfirmBtn() {
		return confirmBtn;
	}

	public WebElement getOrderSuccesfulMessage() {
		return orderSuccesfulMessage;
	}

	public WebElement getOrderID() {
		return orderID;
	}

	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
	private WebElement confirmBtn;

	@FindBy(xpath = "//div[@class='title']")
	private WebElement orderSuccesfulMessage;

	@FindBy(xpath = "//ul[@class='details']/li[1]")
	private WebElement orderID;
}
