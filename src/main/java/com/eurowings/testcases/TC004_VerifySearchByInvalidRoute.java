package com.eurowings.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eurowings.pages.SearchFlightByRoute;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class TC004_VerifySearchByInvalidRoute extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "VerifySearchby invalid Route result for today's date";
		testDescription ="Verify User could get error message for flight status with given invalid route";
		//category ="Smoke";
		excelFileName="invalidRouteData";

	} 

	@Test(dataProvider = "fetchData")
	public void runSearchByRoute(String incorrect_departCode, String incorrect_destCode) {
		new SearchFlightByRoute()
		.agreeCookieConsent()
		.enterDepartureAirportCode(incorrect_departCode)
		.enterDestinationAirportCode(incorrect_destCode)
		.enterTomorrowDate()
		.clickShowFlightStatus()
		.verifySearchResultsLayoutDisplayedforInvalidRoute()
		.verifyResultsNotDisplayedforInvalidRoute();
	}

}