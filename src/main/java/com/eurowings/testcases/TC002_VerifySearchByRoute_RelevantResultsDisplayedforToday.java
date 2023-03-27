package com.eurowings.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eurowings.pages.SearchFlightByRoute;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class TC002_VerifySearchByRoute_RelevantResultsDisplayedforToday extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "VerifySearchbyRoute result with given inputs for today date";
		testDescription ="Verify User could get flight status with given Departure and Destination airports for today date";
		//category ="Smoke";
		excelFileName="validRouteData";

	}

	
	@Test(dataProvider = "fetchData")
	public void runSearchByRoute(String departCode, String destCode) {
		new SearchFlightByRoute()
		.agreeCookieConsent()
		.enterDepartureAirportCode(departCode)
		.enterDestinationAirportCode(destCode)
		.enterTodayDate()
		.clickShowFlightStatus()
		.verifySearchResultsLayoutDisplayedforValidRoute()
		.verifyGivenRouteResultsDisplayed_Today(departCode, destCode);
	}

}