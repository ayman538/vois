package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Data.Loadproperties;

public class TestBase {
	
	public  WebDriver driver;
	
	@BeforeSuite
	public  void startdriver()

	{
		
		
		String chromepath=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromepath) ;
		driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Loadproperties.userData.getProperty("URL"));
	
	}
	
	@AfterSuite
	public  void TearDown() {
		driver.quit();
	}

}
