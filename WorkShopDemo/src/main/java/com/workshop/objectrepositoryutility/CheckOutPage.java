package com.workshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
