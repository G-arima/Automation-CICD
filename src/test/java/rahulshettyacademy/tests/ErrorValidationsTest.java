package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.ProductCatalouge;
import rahulshettyacademy.pageobjects.cartProducts;

public class ErrorValidationsTest extends BaseTest{
	
    @Test(groups= {"Error Handling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {
		
	    ProductCatalouge myObj1=myObj.loginApplication("test@gmail.XYZ","Admin@123");
		Assert.assertEquals("Incorrect email password.", myObj.getErrorMessage());	
	}
    @Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		String productName="ZARA COAT 3";
		ProductCatalouge myObj1=myObj.loginApplication("garima.lekhi1994@outlook.com","Demo@123");
		List<WebElement> products=myObj1.getProductList();
		myObj1.getProductByName(productName);
	    myObj1.addProductToCart(productName);
	    Thread.sleep(1000);
	    cartProducts myObj2=myObj1.clickoncartbutton();
        myObj2.getcartProducts();
        Boolean match=myObj2.verifyProductTitles("ZARA COAT 33");
        Assert.assertFalse(match);
	}

}
