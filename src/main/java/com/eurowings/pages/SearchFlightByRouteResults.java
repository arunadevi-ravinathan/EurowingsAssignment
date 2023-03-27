package com.eurowings.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class SearchFlightByRouteResults extends ProjectSpecificMethods {

	public SearchFlightByRouteResults verifySearchResultsLayoutDisplayedforValidRoute() {
		verifyDisplayed(locateElement(Locators.CLASS_NAME,"o-search-flight-status__flight-list-cards"));
		scrollTo(Locators.CLASS_NAME,"o-search-flight-status__flight-list-cards");
		reportStep("Search results displayed ", "pass");
		return this;
	}
	
	public SearchFlightByRouteResults verifyGivenRouteResultsDisplayed_Today(String departCode, String destCode) {
		verifyDisplayed(locateElement(Locators.CLASS_NAME,"o-search-flight-status__flight-list-cards"));
		scrollTo(Locators.CLASS_NAME,"o-search-flight-status__flight-list-cards");
		List<WebElement> departCodeInList = locateElements(Locators.XPATH, "//p[text()='"+departCode+"']" );
		int noOfResults = departCodeInList.size();
		reportStep("Number of results for the Route search:"+ noOfResults, "pass" );
		
		for(WebElement departCodeInResult: departCodeInList)
		{
			String getDeptCode = departCodeInResult.getText();
		      if(!getDeptCode.equals(departCode))
		      {
		    	  reportStep("Incorrect Departure Airport flight status is in the search result list: " + departCodeInResult.getText(), "fail");
		      }	
		}
		
		List<WebElement> destCodeInList = locateElements(Locators.XPATH, "//p[text()='"+destCode+"']" );
	
		for(WebElement destCodeInResult: destCodeInList)
		{
			String getDestCode = destCodeInResult.getText();
			  if(!getDestCode.equals(destCode))
			  {
				  reportStep("Incorrect Destination Airport flight status is in the search result list" + destCodeInResult.getText(), "fail");
			  }	
		}
		reportStep("Search results displayed correctly for the given search route ", "pass");
		return this;
		
	}
	
	public SearchFlightByRouteResults verifyGivenRouteResultsDisplayed_TomorrowDate(String departCode, String destCode) {
		verifyDisplayed(locateElement(Locators.CLASS_NAME,"o-search-flight-status__flight-list-cards"));
		scrollTo(Locators.CLASS_NAME,"o-search-flight-status__flight-list-cards");
		List<WebElement> departCodeInList = locateElements(Locators.XPATH, "//p[text()='"+departCode+"']" );
		int noOfResults = departCodeInList.size();
		reportStep("Number of results for the Route search:"+ noOfResults, "pass" );
		
		for(WebElement departCodeInResult: departCodeInList)
		{
			String getDeptCode = departCodeInResult.getText();
		      if(!getDeptCode.equals(departCode))
		      {
		    	  reportStep("Incorrect Departure Airport flight status is in the search result list: " + departCodeInResult.getText(), "fail");
		      }	
		}
		
		List<WebElement> destCodeInList = locateElements(Locators.XPATH, "//p[text()='"+destCode+"']" );
	
		for(WebElement destCodeInResult: destCodeInList)
		{
			String getDestCode = destCodeInResult.getText();
			  if(!getDestCode.equals(destCode))
			  {
				  reportStep("Incorrect Destination Airport flight status is in the search result list" + destCodeInResult.getText(), "fail");
			  }	
		}
		reportStep("Search results displayed correctly for the given search route ", "pass");
		return this;
		
	}

	public SearchFlightByRouteResults verifySearchResultsLayoutDisplayedforInvalidRoute() {
		verifyDisplayed(locateElement(Locators.CLASS_NAME,"o-search-flight-status__flight-list"));
		scrollTo(Locators.CLASS_NAME,"o-search-flight-status__flight-list");
		reportStep("Search results layout is displayed for invalid route", "pass");
		return this;
	}
	
	public SearchFlightByRouteResults verifyResultsNotDisplayedforInvalidRoute() {
		scrollTo(Locators.XPATH,"//h2[@data-component-name='headline']");
		verifyDisplayed(locateElement(Locators.XPATH,"//h2[@data-component-name='headline']"));
		WebElement errorMessage = locateElement(Locators.XPATH,"//h2[@data-component-name='headline']");
		String message = "Unfortunately, we could not find any results for your search.";
		if(message.equals(errorMessage.getText())){
			reportStep("Error message displayed for user for invalid flight route search", "pass");
		}
		return this;
		
	}
	
	
}
