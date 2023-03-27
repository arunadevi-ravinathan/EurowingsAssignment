package com.eurowings.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eurowings.pages.SearchFlightByRoute;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class TC005_VerifyAutoSuggestionforSearchQuery extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "Verify Auto suggestion for Search query";
		testDescription ="Verify User could get auto suggestion list for valid serch query";
		//category ="Smoke";
		excelFileName="validRouteData";

	} 

	@Test(dataProvider = "fetchData")
	public void runSearchByRoute(String departCode, String destCode) {
		new SearchFlightByRoute()
		.agreeCookieConsent()
		.typeDepartureAirportCode(departCode)
		.checkAutoSuggestion(departCode);
	}

}