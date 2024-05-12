package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{
	WebDriver driver;
	
	public PaymentPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	private WebElement SelectCountry;
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement SelectSpecificCountry;
	@FindBy(xpath="//a[text()='Place Order ']")
	private	WebElement PlaceOrder;
	private By results=By.cssSelector(".ta-results");
	

	public void selectTheCountry(String countryName)
	{
	Actions a=new Actions(driver);
	a.sendKeys(SelectCountry, countryName).build().perform();
	waitForElementToAppear(results);
	SelectSpecificCountry.click();
	
	}
	public ConfirmationPage placetheorder()
	{
	PlaceOrder.click();
	ConfirmationPage myObj4=new ConfirmationPage(driver);
	return myObj4;
	
	}
	

	}


