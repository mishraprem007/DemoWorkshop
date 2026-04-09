package com.workshop.generic.webdriverutility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void selectbyindex(WebElement element, int index) {
		Select obj = new Select(element);
		obj.selectByIndex(index);
	}

	public void selectByvalue(WebElement element, String value) {
		Select obj = new Select(element);
		obj.selectByValue(value);
	}

	public void selectbyVisibleText(WebElement element, String text) {
		Select obj = new Select(element);
		obj.selectByVisibleText(text);
	}

}
