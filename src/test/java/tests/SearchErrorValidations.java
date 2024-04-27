package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import testComponents.BaseClass;

public class SearchErrorValidations extends BaseClass {
	
	@Test
	 public void ErrorValidation()
	{
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.SearchErrorValidation();
		Assert.assertEquals("Please choose an arrival airport", landingPage.ErrorMsgArrivalAirport());
		Assert.assertEquals("Please choose a departure date", landingPage.ErrorMsgDepartureDate());
		Assert.assertEquals("Please choose a return date", landingPage.ErrorMsgReturnDate());
	}

}
