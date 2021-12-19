package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.rmi.CORBA.Tie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "bigsearch-query-location-input")
	public WebElement Location;


	@FindBy(id = "bigsearch-query-location-listbox")
	public WebElement LocationList;


	@FindBy(css  = "table.cvkwaj")
	public WebElement CalendarTable;


	@FindBy(className = "_1258d0t")
	public WebElement Days;




	@FindBy(id = "FLEXIBLE_DESTINATIONS-go-anywhere--anytime")
	public WebElement Searchsuggestions;


	@FindBy(xpath = "//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table")
	public WebElement LeftTable;

	@FindBy(xpath = "//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[3]/div/table")
	public WebElement RightTable;

	@FindBy(css = ("button[aria-label='Next']"))
	public WebElement NextButton;


	@FindBy(css = ("div[data-testid='structured-search-input-field-guests-button']"))
	public WebElement GuestsButton;

	@FindBy(css = ("button[data-testid='stepper-adults-increase-button']"))
	public WebElement AdultIncreaseBtn;


	@FindBy(css = ("button[data-testid='stepper-children-increase-button']"))
	public WebElement ChildrenIncreaseBtn;

	@FindBy(css = ("button[data-testid='stepper-infants-increase-button']"))
	public WebElement infrantsIncreaseBtn;


	@FindBy(css = ("button[data-testid='stepper-pets-increase-button']"))
	public WebElement PetsIncreaseBtn;
	
	@FindBy(className = "_1mzhry13")
	public WebElement SearchBtn;




	public void SelectLocation( String locationName , WebDriver driver ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		clickbutton(Location);
		wait.until(ExpectedConditions.visibilityOf(Searchsuggestions));
		SetTextElement(Location, locationName, driver);

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("bigsearch-query-location-suggestion-1") , "Maldive Islands, Maldives"));
		
		WebElement SecondOption=driver.findElement(By.id("bigsearch-query-location-suggestion-1"));

		SecondOption.click();

	}


	public void SelectTimeFrom_To( String TimeFrom , String TimeTo, WebDriver driver ) throws InterruptedException {

		while(!SelectTime(TimeFrom)) {

			NextButton.click();
			Thread.sleep(1000);

		}

		while(!SelectTime(TimeTo)) {


			NextButton.click();
			Thread.sleep(1000);

		}




	}

	public  boolean SelectTime( String Time) {

		Boolean GetTime=false;
		List<WebElement> Days=driver.findElements(By.cssSelector("div._1258d0t"));
		//System.out.println(Days.size());
		for (int s = 0; s < Days.size(); s++) {

			if(Days.get(s).getAttribute("data-testid").contains(Time) && Days.get(s).isDisplayed() && Days.get(s).isEnabled()  ) {
				Days.get(s).click();
				GetTime=true;
				break;

			}
		}
		return GetTime;

	}

	public  void AddGuests( ArrayList<String> GuestType ,  ArrayList<String> GuestNo) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		GuestsButton.click();
		wait.until(ExpectedConditions.visibilityOf(AdultIncreaseBtn));
		for (int i = 0; i < GuestType.size(); i++) {
			if(GuestType.get(i).contains("Adults")) {

				Integer AdultsNo= Integer.parseInt(GuestNo.get(i)); 
				for (int j = 0; j < AdultsNo; j++) {
					AdultIncreaseBtn.click();

				}
			}

			else if(GuestType.get(i).contains("Children")) {

				Integer ChildrenNo= Integer.parseInt(GuestNo.get(i)); 
				for (int j = 0; j < ChildrenNo; j++) {
					ChildrenIncreaseBtn.click();

				}
			}
			
			else if(GuestType.get(i).contains("Infants")) {

				Integer InfantsNo= Integer.parseInt(GuestNo.get(i)); 
				for (int j = 0; j < InfantsNo; j++) {
					infrantsIncreaseBtn.click();

				}
			}
			
			else if(GuestType.get(i).contains("Pets")) {

				Integer PetsNo= Integer.parseInt(GuestNo.get(i)); 
				for (int j = 0; j < PetsNo; j++) {
					PetsIncreaseBtn.click();

				}
			}

			
			



		}


		SearchBtn.click();
		waitForPageToLoad();
	}


}
