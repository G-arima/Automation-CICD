package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		
		
		//WebElement userEmail=driver.findElement(By.xpath("//input[@type='email']"));
		
		@FindBy(id="userEmail")
		WebElement UserEmail;
		
		//WebElement passwordEle = driver.findElement(By.xpath("//input[@type='password']"));
		//WebElement submit =driver.findElement(By.cssSelector("input[value='Login']"));
		
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(css="div[class*='flyInOut']")
		WebElement errorMessage;
		
		@FindBy(id="login")
		WebElement submit;
		
		public ProductCatalouge loginApplication(String Email,String Password)
		{
		UserEmail.sendKeys(Email);
		passwordEle.sendKeys(Password);
		submit.click();
		ProductCatalouge myObj1=new ProductCatalouge(driver);
		return myObj1;
		}
		
		public String getErrorMessage()
		{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();	
		}
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}

	}


