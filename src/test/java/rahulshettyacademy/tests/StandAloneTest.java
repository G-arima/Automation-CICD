package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage myObj=new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("test@gmail.ABC");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@123");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-lg-4")));
        List<WebElement> products=driver.findElements(By.cssSelector("div.col-lg-4"));
        WebElement prod=products.stream().filter(product->
        product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector("div.card-body button:last-of-type")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='toast-container']")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
        List<WebElement> cartproducts=driver.findElements(By.xpath("//div[@class='cart']//h3"));
        Boolean match=cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase("ZARA COAT 3"));
        Assert.assertTrue(match);
        driver.findElement(By.xpath("//div[@class='subtotal cf ng-star-inserted']//button")).click();
        driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Ind");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[class='ta-item list-group-item ng-star-inserted']")));
        List<WebElement> options=driver.findElements(By.cssSelector("button[class='ta-item list-group-item ng-star-inserted']"));
        for(WebElement option:options) {
        	if(option.getText().equalsIgnoreCase("India")) {
        		option.click();
        		break;
        	}
        }
        driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
        String text=driver.findElement(By.cssSelector("h1.hero-primary")).getText();
        Assert.assertEquals(true,text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();
        
        
        
        
		
		
		
		
		

	}

}
