package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.PaymentPage;
import rahulshettyacademy.pageobjects.ProductCatalouge;
import rahulshettyacademy.pageobjects.cartProducts;

public class SubmitOrderTest extends BaseTest{
	//String productName="ZARA COAT 3";
    @Test(dataProvider="getData", groups="Purchase")
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		String countryName="India";
		String text="THANKYOU FOR THE ORDER.";
		ProductCatalouge myObj1=myObj.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> products=myObj1.getProductList();
		myObj1.getProductByName(input.get("productName"));
	    myObj1.addProductToCart(input.get("productName"));
	    Thread.sleep(1000);
	    cartProducts myObj2=myObj1.clickoncartbutton();
        myObj2.getcartProducts();
        Boolean match=myObj2.verifyProductTitles(input.get("productName"));
        Assert.assertTrue(true);
        PaymentPage myObj3=myObj2.clickoncheckoutButton();
        myObj3.selectTheCountry(countryName);
        ConfirmationPage myObj4=myObj3.placetheorder();
        myObj4.confirmationMessage();
        Assert.assertEquals(true,text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
    
    	
    
    @DataProvider
    public Object[][] getData() throws IOException
    {
    List<HashMap<String,String>> data=getJSONDataToHashMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrderFile.json");	
    return new Object[][] {{data.get(0)},{data.get(1)}};
    }
    // How to write Dependency tests
    //To verify if ZARA COAT 3 is present in the Products Page
    
    //@Test(dependsOnMethods= {"SubmitOrder"})
    //public void OrderHistoryTest() {
    	//ProductCatalouge myObj1=myObj.loginApplication("test@gmail.ABC","Admin@123");
    	//OrdersPage myObj5=myObj1.clickonOrdersbutton();
    	//Assert.assertTrue(myObj5.verifyOrdersDisplay(productName));	
    //}
    //@DataProvider
    //public Object[][] getData() 
   // {
    	//return new Object[][] {{"test@gmail.ABC","Admin@123","ZARA COAT 3"},{"garima.lekhi1994@outlook.com","Demo@123","ADIDAS ORIGINAL"}};
    	
    			//}
				/*
				 * @DataProvider 
				 * public Object[][] getData() 
				 * { HashMap<String,String> map=new
				 * HashMap<String,String>(); 
				 * map.put("email", "test@gmail.ABC");
				 * map.put("password", "Admin@123");
				 * map.put("productName", "ZARA COAT 3");
				 * HashMap<String,String> map1=new HashMap<String,String>(); 
				 * map1.put("email",
				 * "garima.lekhi1994@outlook.com"); 
				 * map1.put("password", "Demo@123");
				 * map1.put("productName","ADIDAS ORIGINAL"); 
				 * return new Object[][]
				 * {{map},{map1}}; }
				 */

}
