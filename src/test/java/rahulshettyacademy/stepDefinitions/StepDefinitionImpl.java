package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.PaymentPage;
import rahulshettyacademy.pageobjects.ProductCatalouge;
import rahulshettyacademy.pageobjects.cartProducts;

public class StepDefinitionImpl extends BaseTest{
	public LandingPage myObj;
	public ProductCatalouge myObj1;
	public cartProducts myObj2;
	public PaymentPage myObj3;
	public ConfirmationPage myObj4;

	@Given("I landed on the Ecommerce Page.")
	public void i_landed_on_the_ecommerce_page() throws IOException {
		
		myObj=launchApplication();
	}
	
	@Given("Logged in with username {string} and password {string}")
	public void logged_in_username_and_password(String username, String password) 
	{
		myObj1=myObj.loginApplication(username,password);
	}
	@When("I add product {string} to cart")
	public void add_product_to_cart(String productName)throws InterruptedException
	{
		ProductCatalouge myObj1=new ProductCatalouge(driver);
		List<WebElement> products=myObj1.getProductList();
	    myObj1.addProductToCart(productName);
	}
	@When("Checkout {string} and submit the Order")
	public void checkout_productName_and_submit_the_order(String productName)
	{
		myObj2=myObj1.clickoncartbutton();
        myObj2.getcartProducts();
        Boolean match=myObj2.verifyProductTitles(productName);
        Assert.assertTrue(match);
        myObj3=myObj2.clickoncheckoutButton();
        myObj3.selectTheCountry("india");
        myObj4=myObj3.placetheorder();
        
	}
	@Then("{string} message is displayed on the confirmation page")
	public void message_is_displayed_on_confirmation_page(String string)
	{
		String confirmMessage=myObj4.confirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        driver.close();
	}
	@Then("{string} message is displayed")
	public void something_message_is_displayed(String strArg1)throws Throwable {
		Assert.assertEquals(strArg1, myObj.getErrorMessage());
		driver.close();
	}
			
}
