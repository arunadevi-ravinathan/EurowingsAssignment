package com.eurowings.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eurowings.pages.SearchFlightByRoute;
import com.framework.testng.api.base.ProjectSpecificMethods;



public class TC001_VerifySearchByRoute_Today extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "VerifySearchbyRoute with Valid inputs";
		testDescription ="Verify User could get flight status results";
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
		.verifySearchResultsLayoutDisplayedforValidRoute();
	}

}