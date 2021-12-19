package Tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Data.Loadproperties;
import Pages.HomePage;
import Pages.HotelsResultsPage;
import Pages.ReservePage;


public class Hotel_Reserve extends TestBase {

	ArrayList< String> res;


	HomePage HomeObject;
	HotelsResultsPage HotelResultObj;
	ReservePage ReserveObj;
	@Test(priority = 1 )
	public void HoverOnHotel_InviewedList() throws InterruptedException, IOException {
		ExcelReader Excel= new ExcelReader();

		res=Excel.GetExcelData(0);
		String TimeFrom=res.get(0);
		res=Excel.GetExcelData(1);
		String TimeTo=res.get(0);

		HomeObject=new HomePage(driver);

		HomeObject.SelectLocation("Mal", driver);

		HomeObject.SelectTimeFrom_To(TimeFrom, TimeTo, driver);

		HomeObject.AddGuests(Excel.GetExcelData(2) , Excel.GetExcelData(3));
		HotelResultObj= new HotelsResultsPage(driver);
		HotelResultObj.HoverOnHotel( driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(HotelResultObj.HighlightedPrice));
		//assert That highlighted price is the same as the hovered one
		assertTrue(HotelResultObj.HighlightedPrice.getText().contains("$7,505"));
		

	}
	@Test(priority = 2 , dependsOnMethods = {"HoverOnHotel_InviewedList"})
	public void Validate_HoveredHotel_AgainstTheOneInMap() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		HotelResultObj= new HotelsResultsPage(driver);
		HotelResultObj.SelectHotelOnMap();
		wait.until(ExpectedConditions.visibilityOf(HotelResultObj.HotelPopup));
		//	Validate the Hotel data you hovered on, is same as the one in the maps
		assertEquals(HotelResultObj.TargetHotel.getAttribute("aria-label"), HotelResultObj.HotelPopup.getAttribute("aria-label"));
	
		
	}
	@Test(priority = 3 , dependsOnMethods = {"Validate_HoveredHotel_AgainstTheOneInMap"})
	public void Validate_ReservationData() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		HotelResultObj= new HotelsResultsPage(driver);
		HotelResultObj.SelectHotel();
		
		ReserveObj= new ReservePage(driver);
		  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		  driver.switchTo().window(tabs.get(1));
		wait.until(ExpectedConditions.visibilityOf(ReserveObj.PlaceName));
		wait.until(ExpectedConditions.visibilityOf(ReserveObj.TotalPrice));
		assertTrue(ReserveObj.PlaceName.getText().contains("Dhiffushi Island Villa- private heaven"));
		assertEquals(ReserveObj.CheckinDate.getText(), "2/2/2022");
		assertEquals(ReserveObj.CheckoutDate.getText(), "3/6/2022");
		assertEquals(ReserveObj.GuestsNo.getText(), "4 guests");
		assertTrue(ReserveObj.TotalPrice.getText().contains("$8,141"));
		
	}

	

}
