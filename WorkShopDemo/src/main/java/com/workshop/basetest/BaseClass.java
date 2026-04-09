package com.workshop.basetest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.workshop.generic.fileutility.ExcelUtility;
import com.workshop.generic.fileutility.FileUtility;
import com.workshop.generic.webdriverutility.JavaUtility;
import com.workshop.generic.webdriverutility.WebDriverUtility;
import com.workshop.objectrepositoryutility.HomePage;

public class BaseClass {
	public static WebDriver driver;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("==Launch the BROWSER==");
		String browser = fLib.getDataFromProperties("browser");

		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("==Login==");
		String url = fLib.getDataFromProperties("url");
		driver.get(url);
	}

	@AfterMethod
	public void configAM() {
		System.out.println("==Logout==");
		HomePage hp = new HomePage(driver);
		hp.clickLogout();
	}

	@AfterClass
	public void configAC() {
		System.out.println("==Close the BROWSER==");
		driver.quit();

	}

}