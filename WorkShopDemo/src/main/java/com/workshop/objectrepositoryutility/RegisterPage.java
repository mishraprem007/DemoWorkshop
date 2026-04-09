package com.workshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log out")
	private WebElement logoutBtn;

	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	private WebElement registrationCompletedText;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;

	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement regLink;

	@FindBy(id = "gender-male")
	private WebElement MaleRadioBtn;

	@FindBy(name = "FirstName")
	private WebElement editFN;

	@FindBy(name = "LastName")
	private WebElement editLN;

	@FindBy(name = "Email")
	private WebElement editEmail;

	@FindBy(name = "Password")
	private WebElement editPassword;

	@FindBy(name = "ConfirmPassword")
	private WebElement editConfPassword;

	@FindBy(id = "register-button")
	private WebElement regBtn;

	public WebElement getRegistrationCompletedText() {
		return registrationCompletedText;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getRegLink() {
		return regLink;
	}

	public WebElement getMaleRadioBtn() {
		return MaleRadioBtn;
	}

	public WebElement getEditFN() {
		return editFN;
	}

	public WebElement getEditLN() {
		return editLN;
	}

	public WebElement getEditEmail() {
		return editEmail;
	}

	public WebElement getEditPassword() {
		return editPassword;
	}

	public WebElement getEditConfPassword() {
		return editConfPassword;
	}

	public WebElement getRegBtn() {
		return regBtn;
	}

	public void clickRegisterLink() {
		regLink.click();
	}

	public void registerUser(String fname, String lname, String email, String password) {
		MaleRadioBtn.click();
		editFN.sendKeys(fname);
		editLN.sendKeys(lname);
		editEmail.sendKeys(email);
		editPassword.sendKeys(password);
		editConfPassword.sendKeys(password);
		regBtn.click();
	}

	public void clickContinue() {
		continueBtn.click();
	}

}