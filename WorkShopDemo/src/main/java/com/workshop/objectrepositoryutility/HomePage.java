package com.workshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log out")
	private WebElement logoutBtn;

	public void clickLogout() {
		logoutBtn.click();
	}

	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	@FindBy(id = "small-searchterms")
	private WebElement searchEdit;

	@FindBy(className = "search-box-button")
	private WebElement searchBtn;

	public void searchProduct(String product) {
		searchEdit.sendKeys(product);
		searchBtn.click();
	}
}
