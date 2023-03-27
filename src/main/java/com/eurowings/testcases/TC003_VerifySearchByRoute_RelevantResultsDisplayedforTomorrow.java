package com.eurowings.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eurowings.pages.SearchFlightByRoute;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class TC003_VerifySearchByRoute_RelevantResultsDisplayedforTomorrow extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "VerifySearchbyRoute result with given inputs for tomorrow date";
		testDescription ="Verify User could get flight status with given Departure and Destination airports for tomorrow date";
		//category ="Smoke";
		excelFileName="validRouteData";

	} 

	
	@Test(dataProvider = "fetchData")
	public void runSearchByRoute(String departCode, String destCode) {
		new SearchFlightByRoute()
		.agreeCookieConsent()
		.enterDepartureAirportCode(departCode)
		.enterDestinationAirportCode(destCode)
		.enterTomorrowDate()
		.clickShowFlightStatus()
		.verifySearchResultsLayoutDisplayedforValidRoute()
		.verifyGivenRouteResultsDisplayed_TomorrowDate(departCode, destCode);
	}

}