package WorkshopDemoTest;

/**
 * @author Premshankar Mishra
 * 1. Create 2 users
 * 2. add product to cart
 * 3. buy product - for both users
 * 4. assertion - for users creation, aadingProduct, orderID
 * 5. writeback orderID
 * (Don't use hardcoded value)
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.workshop.basetest.BaseClass;
import com.workshop.objectrepositoryutility.CheckOutPage;
import com.workshop.objectrepositoryutility.HomePage;
import com.workshop.objectrepositoryutility.RegisterPage;

public class UsersOrderTest extends BaseClass {

	int colCounter = 0;

	@DataProvider(name = "userData")
	public Object[][] getData() throws Throwable {

		Object[][] objArr = new Object[2][4];

		objArr[0][0] = eLib.getDataFromExcel("usersReg", 1, 1);
		objArr[0][1] = eLib.getDataFromExcel("usersReg", 1, 2);
		objArr[0][2] = eLib.getDataFromExcel("usersReg", 1, 3);
		objArr[0][3] = eLib.getDataFromExcel("usersReg", 1, 4);

		objArr[1][0] = eLib.getDataFromExcel("usersReg", 2, 1);
		objArr[1][1] = eLib.getDataFromExcel("usersReg", 2, 2);
		objArr[1][2] = eLib.getDataFromExcel("usersReg", 2, 3);
		objArr[1][3] = eLib.getDataFromExcel("usersReg", 2, 4);

		return objArr;
	}

	@Test(dataProvider = "userData")
	public void accountCreationAndOrderTest(String fName, String lName, String email1, String email2) throws Throwable {
		RegisterPage rp = new RegisterPage(driver);

		rp.clickRegisterLink();

		String userEmail1 = email1 + jLib.getRandomNumber();
		String userEmail = userEmail1 + email2;

		rp.registerUser(fName, lName, userEmail, userEmail1);

		String userRegConfirmationActual = rp.getRegistrationCompletedText().getText().trim();
		String userRegistrationConfirmationActual = eLib.getDataFromExcel("RegConfirmation", 1, 1);

		Assert.assertEquals(userRegConfirmationActual, userRegistrationConfirmationActual);


		HomePage hp = new HomePage(driver);
		String expectedProduct = eLib.getDataFromExcel("Products", 1, 0);
		hp.searchProduct(expectedProduct);
		String countryName = eLib.getDataFromExcel("CheckoutData", 1, 1);
		String city = eLib.getDataFromExcel("CheckoutData", 5, 0);
		String address = eLib.getDataFromExcel("CheckoutData", 6, 0);
		String zip = eLib.getDataFromExcel("CheckoutData", 8, 0);
		String phone = eLib.getDataFromExcel("CheckoutData", 8, 1);

		CheckOutPage cp = new CheckOutPage(driver);
		cp.completeCheckout(countryName, city, address, zip, phone);

		cp.continueOrder();
		String actualProduct = cp.getProductNameText().getText();

		Assert.assertTrue(actualProduct.contains(expectedProduct));


		cp.getConfirmBtn().click();
		String expectedOrderMessage = eLib.getDataFromExcel("Validation", 1, 1);
		String orderSucessfulMessage = cp.getOrderSuccesfulMessage().getText();

		
	/*	 This is an extra assertion I added, which is not mentioned in the test case   */
		 
		Assert.assertEquals(orderSucessfulMessage, expectedOrderMessage);


		String actualOrderDetails = cp.getOrderID().getText();
		String extpectedOrderDetails = eLib.getDataFromExcel("Validation", 2, 1);

		Assert.assertTrue(actualOrderDetails.contains(extpectedOrderDetails));


		String orderID = jLib.getOrderNumber(actualOrderDetails);
		eLib.setDataIntoExcel("WriteBackOrderID", 1, colCounter, orderID);
		colCounter++;

	}
}