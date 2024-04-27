package tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstractComponent.DatePicker;
import pageObjects.FlightListingPage;
import pageObjects.LandingPage;
import pageObjects.ResultByPricePage;
import testComponents.BaseClass;


	public class SearchFlightTest extends BaseClass{


		@Test(dataProvider = "getData")
		public void Search(HashMap<String, String> searchParam) throws IOException {

			LandingPage landingPage = new LandingPage(driver);
			String arrivalAirportCode = searchParam.get("arrivalAirportCode");
			String arrivalDate = searchParam.get("arrivalDate");
			landingPage.SearchFlight(arrivalAirportCode,arrivalDate);
			ResultByPricePage resultByPricePage = new ResultByPricePage(driver);
			resultByPricePage.ClickOnContinue();
			DatePicker datePicker = new DatePicker(driver);
			FlightListingPage flightListingPage = new FlightListingPage(driver);
			Assert.assertEquals(flightListingPage.GetFlightDate(), datePicker.convertToLongFormat(arrivalDate));
			Assert.assertTrue(flightListingPage.IsDestinationInFlightListEqualToSearchParam(arrivalAirportCode));
			
		}
		
		@DataProvider
		public Object[][] getData() throws IOException {

			List<HashMap<String, String>> data = getJsonDataToMap(
					System.getProperty("user.dir") + "//src//test//java//data//TestData.json");
			return new Object[][] { { data.get(0)},{ data.get(1)} };

		}
	}



