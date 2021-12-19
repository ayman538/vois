package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsResultsPage extends PageBase{

	public HotelsResultsPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(css = ("a[aria-label='Dhiffushi Island Villa- private heaven']"))
	public WebElement TargetHotel;
	
	@FindBy(css = ("div[style='background-color: rgb(34, 34, 34); border-radius: 28px; box-shadow: rgba(0, 0, 0, 0.04) 0px 0px 0px 1px inset, rgba(0, 0, 0, 0.18) 0px 2px 4px; color: rgb(255, 255, 255); height: 28px; padding: 0px 8px; position: relative; transform: scale(1); transform-origin: 50% 50%; transition: transform 250ms cubic-bezier(0, 0, 0.1, 1) 0s;']"))
	public WebElement HighlightedPrice;

	
	@FindBy(css =  "a.l1hlxis8.dir.dir-ltr")
	public WebElement HotelPopup;
	
	public void HoverOnHotel(WebDriver driv) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(TargetHotel));
		Actions Acc= new Actions(driv);
		
		Acc.moveToElement(TargetHotel).perform();
		
	}
	
	public void SelectHotelOnMap(){
		
		HighlightedPrice.click();
	}
	public void  SelectHotel() {
		TargetHotel.click();
		waitForPageToLoad();
	}
	
}
