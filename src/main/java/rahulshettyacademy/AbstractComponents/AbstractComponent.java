package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.cartProducts;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement OrdersHeader;

	
	public void waitForElementToAppear(By findBy) 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementToAppear(WebElement findBy) 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public cartProducts clickoncartbutton() {
		cartHeader.click();
		cartProducts myObj2=new cartProducts(driver);
		return myObj2;
	}
	public OrdersPage clickonOrdersbutton() {
		OrdersHeader.click();
		OrdersPage myObj5=new OrdersPage(driver);
		return myObj5;
	}
	
}
