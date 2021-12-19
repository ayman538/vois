package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
	public    WebDriver driver;
	public PageBase(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	protected static void clickbutton(WebElement button) {

		button.click();
	}
	
	protected static void SetTextElement(WebElement txtelement , String value  ,WebDriver Driver) {
		
		txtelement.clear();
		txtelement.sendKeys(value);
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(txtelement, "value", value));
		
	}
	
	public void waitForPageToLoad() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    wait.until(new ExpectedCondition<Boolean>() {

	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	        }
	    });
	}
}
