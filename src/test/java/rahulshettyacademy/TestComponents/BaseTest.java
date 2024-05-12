package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage myObj;

	public WebDriver initializeDriver() throws IOException
	{
		//properties class
	    Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
        //prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome"))
        {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
        	System.setProperty("webdriver.gecko.driver", "C:\\Users\\garim\\OneDrive\\Documents\\Java and Selenium WEBDRIVERS\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        	driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge"))
        {
        	//edge
        }
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public List<HashMap<String, String>> getJSONDataToHashMap(String FilePath) throws IOException
	{
		//read the json to string
String jsonContent=FileUtils.readFileToString(new File(FilePath),StandardCharsets.UTF_8);
	
//String to HashMap Jackson Databind
    
    ObjectMapper mapper=new ObjectMapper();
    List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
    return data;
	}
	
	public static String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
    	TakesScreenshot ts = null;
		try {
			ts = (TakesScreenshot)driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	File Source=ts.getScreenshotAs(OutputType.FILE);
    	File file=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
    	FileUtils.copyFile(Source, file);
    	return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
 }


	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication()throws IOException
	{
		driver=initializeDriver();
		myObj=new LandingPage(driver);
		myObj.goTo();
		return myObj;	
	}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		driver.close();
	}
}
