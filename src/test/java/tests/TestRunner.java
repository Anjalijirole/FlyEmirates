package tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.ResultByPricePage;
import testComponents.BaseClass;


public class TestRunner extends BaseClass{


	@Test
	public void Search() throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.SearchFlight("BLR");
		ResultByPricePage resultByPricePage = new ResultByPricePage(driver);
		resultByPricePage.ClickOnContinue();
	}

}
