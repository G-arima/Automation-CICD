package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class cartProducts extends AbstractComponent{
	WebDriver driver;
	
	public cartProducts(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='cart']//h3")
	List<WebElement> productTitles;
	
	@FindBy(xpath="//div[@class='subtotal cf ng-star-inserted']//button")
	WebElement checkoutButton;

	public List<WebElement> getcartProducts()
	{
		return productTitles;
	}
	public Boolean verifyProductTitles(String productName) 
	{
	Boolean match=getcartProducts().stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productName));
	return match;
	}
	public PaymentPage clickoncheckoutButton()
	{
		checkoutButton.click();
		PaymentPage myObj3=new PaymentPage(driver);
		return myObj3;
	}

	}


