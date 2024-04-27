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
	
	@FindBy(xpath="//button/span[text()='Continue']")
	private WebElement continueBtn;
	
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
	
	@FindBy(xpath="//div[@class='grid__item error-wrapper visible']/div[@class='widget__inline__error']/ul[@class='widget__inline__error_listing']/li/p[contains(@class,'destination')]")
	private WebElement arrivalAirportErrorMesg;
	
	@FindBy(xpath="//div[@class='grid__item error-wrapper visible']/div[@class='widget__inline__error']/ul[@class='widget__inline__error_listing']/li/p[contains(@class,'departure')]")
	private WebElement departureDateErrorMsg;
	
	@FindBy(xpath="//div[@class='grid__item error-wrapper visible']/div[@class='widget__inline__error']/ul[@class='widget__inline__error_listing']/li/p[contains(@class,'return')]")
	private WebElement returnDateErrorMsg;
	
	public void Goto() {
		driver.get("https://www.emirates.com/ae");
		
	}
	
	public void AcceptCookies() {
		acceptBtn.click();
	}
	
	public void SearchFlight(String arrivalAirportCode, String inputDate)
	{
		waitForWebElementIsClickable(arrivalAirportInput);
		Click(arrivalAirportInput);
		arrivalAirportInput.sendKeys(arrivalAirportCode);
		WebElement arrivalAirportDropdown = listOfDestinations.findElement(By.xpath("//div/p[contains(text(),'"+ arrivalAirportCode +"')and contains(@class,'highlight')]"));
		waitForWebElementIsClickable(arrivalAirportDropdown);
		Click(arrivalAirportDropdown);
	
		Click(flexiDateCheckbox);
		Click(oneWayCheckbox);
		DatePicker dp = new DatePicker(driver);
		dp.datePicker(driver,inputDate);
		waitForWebElementIsClickable(searchFlightButton);
		Click(searchFlightButton);
		
	}
	
	public void SearchErrorValidation() 
	{
		waitForWebElementIsClickable(continueBtn);
		Click(continueBtn);
		waitForWebElementIsClickable(searchFlightButton);
		Click(searchFlightButton);
		
		}
	
	public String ErrorMsgArrivalAirport()
	{
		String arrivalAirportMsg=arrivalAirportErrorMesg.getText();
		return arrivalAirportMsg;
	}
	
	public String ErrorMsgDepartureDate()
	{
		String departureDaterMsg=departureDateErrorMsg.getText();
		return departureDaterMsg;
	}
	
	public String ErrorMsgReturnDate()
	{
		String returnDateMsg=returnDateErrorMsg.getText();
		return returnDateMsg;
	}
	
	private void Click(WebElement element)
	{
		element.click();
	}
    
	
	
	

}
