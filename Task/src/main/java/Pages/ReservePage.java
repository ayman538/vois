package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReservePage extends PageBase {

	public ReservePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(className = "_fecoyn4")
	public WebElement PlaceName;
	
	@FindBy(css = ("div[data-testid='change-dates-checkIn']"))
	public WebElement CheckinDate;
	
	@FindBy(css = ("div[data-testid='change-dates-checkOut']"))
	public WebElement CheckoutDate;
	
	@FindBy(id = "GuestPicker-book_it-trigger")
	public WebElement GuestsNo;
	
	@FindBy(className = "_hdznyn")
	public WebElement TotalPrice;
	
	

}
