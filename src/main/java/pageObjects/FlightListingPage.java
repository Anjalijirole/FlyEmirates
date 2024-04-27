package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class FlightListingPage extends AbstractComponent{
	
private WebDriver driver;
	
	public FlightListingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//@FindBy(xpath="//div[contains(@class,\"ts-fbr-flight-list__header-title\")]/h2")
	//private List<WebElement> HeaderOfListedFlights;	
	
	@FindBy(xpath="//div[contains(@class,\"ts-fbr-flight-list__header-date\")]")
	private WebElement DateOFtheListedFlights;
	
	@FindBy(xpath="//div[contains(@class,\"ts-fie__right-side\")]/p/span/following-sibling::span")
	private List<WebElement> DestinationOfListedFlights;
	
	public String GetFlightDate()
	{
		String dateOfFlight = DateOFtheListedFlights.getText();
		return dateOfFlight;
	}
	public boolean IsDestinationInFlightListEqualToSearchParam(String destinationSearchParam)
	{
		boolean isDestinationValid=false;
		for(WebElement destinationOfListedFlight:DestinationOfListedFlights )
		{
			if(destinationOfListedFlight.getText().equals(destinationSearchParam))
			{
				isDestinationValid=true;
			}
			else if(destinationOfListedFlight.getText().trim().length() > 0)
			{
				isDestinationValid=false;
			}
		}
		return isDestinationValid;
	}

}
    
