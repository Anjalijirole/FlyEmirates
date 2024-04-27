package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;
import abstractComponent.DatePicker;

public class LandingPage extends AbstractComponent{
	
private WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
	private WebElement acceptBtn;
	
	@FindBy(name="Arrival airport")
	private WebElement arrivalAirportInput;
	
	@FindBy(xpath="//li[contains(@class,'location__item')]")
	private WebElement listOfDestinations;
	
	@FindBy(xpath="//label[@class='checkbox flexible-date']/input")
	private WebElement flexiDateCheckbox;
	
	@FindBy(xpath="//label[@class='checkbox one-way']/input")
	private WebElement oneWayCheckbox;
	
	@FindBy(xpath="//button/span[contains(text(),'Search flights')]")
	private WebElement searchFlightButton;
	
	public void Goto() {
		driver.get("https://www.emirates.com/ae");
		
	}
	
	public void AcceptCookies() {
		acceptBtn.click();
	}
	
	public void SearchFlight(String arrivalAirportCode, String inputDate)
	{
		waitForWebElementIsClickable(arrivalAirportInput);
		arrivalAirportInput.click();
		arrivalAirportInput.sendKeys(arrivalAirportCode);
		WebElement element = listOfDestinations.findElement(By.xpath("//div/p[contains(text(),'"+ arrivalAirportCode +"')and contains(@class,'highlight')]"));
		waitForWebElementIsClickable(element);
		element.click();
	
		flexiDateCheckbox.click();
		oneWayCheckbox.click();
		DatePicker dp = new DatePicker(driver);
		dp.datePicker(driver,inputDate);
		waitForWebElementIsClickable(searchFlightButton);
		searchFlightButton.click();
		
	}

	
	
	

}
