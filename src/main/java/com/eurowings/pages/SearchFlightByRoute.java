package com.eurowings.pages;

import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SearchFlightByRoute extends ProjectSpecificMethods{
	
	public SearchFlightByRoute agreeCookieConsent( ) {
		waitForApperance(locateElement(Locators.XPATH, "//div[@class='o-layer__content cookie-consent__content']"));
		verifyDisplayed(locateElement(Locators.XPATH, "//div[@class='o-layer__content cookie-consent__content']"));
		click(locateElement(Locators.XPATH, "//span[text()='I understand']"));
		reportStep( "Cookie consent is agreed","pass");
		//Scroll to Flight status search section in the page
		WebElement searchSection = locateElement(Locators.XPATH, "//div[@class='flightstatus']");		
		executeTheScript("arguments[0].scrollIntoView();", searchSection);
		verifyDisplayed(locateElement(Locators.XPATH, "//span[text()='Departure airport']"));
		return this;
	}
	
	public SearchFlightByRoute enterDepartureAirportCode(String departCode) {
		//moveToElement(locateElement(Locators.ID, "station-select-200-input"));
		click(locateElement(Locators.XPATH, "//span[text()='Departure airport']"));
		typeAndEnter(locateElement(Locators.ID, "station-select-200-input"), departCode);
		reportStep(departCode +" Departure Airport Code is entered successfully","pass");
		return this;
	}
	public SearchFlightByRoute enterDestinationAirportCode(String destCode) {
		click(locateElement(Locators.XPATH, "//span[text()='Destination airport']"));
		typeAndEnter(locateElement(Locators.ID, "station-select-201-input"), destCode);
		reportStep(destCode+" Destination Airport Code  is entered successfully","pass");
		return this;
	}
	
	public SearchFlightByRoute enterTodayDate() {
		
		//Retrieve today's date
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = new Date();
		 String todayDate= dateFormat.format(date);
		
		click(locateElement(Locators.NAME, "datepicker_input_27"));
		scrollTo(Locators.XPATH, "//ul[contains(@class,'calendar__sheets calendar__sheets--number-of-months-1')]");
		click(locateElement(Locators.XPATH, "//input[@value='"+todayDate+"']"));
		reportStep(todayDate +" is entered successfully","pass");
		WebElement searchSection = locateElement(Locators.XPATH, "//div[@class='flightstatus']");
		executeTheScript("arguments[0].scrollIntoView();", searchSection);
		return this;
	}
	
	public SearchFlightByRoute enterTomorrowDate() {
		
		//Retrieve tomorrrow's date
		 Calendar calendar = Calendar.getInstance();
		 calendar.add(Calendar.DAY_OF_YEAR, 1);
		 Date tomorrow = calendar.getTime();
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String tomorrowDate= dateFormat.format(tomorrow);
		
		click(locateElement(Locators.NAME, "datepicker_input_27"));
		scrollTo(Locators.XPATH, "//ul[contains(@class,'calendar__sheets calendar__sheets--number-of-months-1')]");
		click(locateElement(Locators.XPATH, "//input[@value='"+tomorrowDate+"']"));
		reportStep(tomorrowDate +" is entered successfully","pass");
		WebElement searchSection = locateElement(Locators.XPATH, "//div[@class='flightstatus']");
		executeTheScript("arguments[0].scrollIntoView();", searchSection);
		return this;
	}
	
	public SearchFlightByRouteResults clickShowFlightStatus() {
		click(locateElement(Locators.XPATH, "//span[text()='Show flight status']"));
		reportStep("Show Flight Status button is clicked successfully", "pass");
		return new SearchFlightByRouteResults();
	}
	
	public SearchFlightByRoute typeDepartureAirportCode(String departCode) {
		click(locateElement(Locators.XPATH, "//span[text()='Departure airport']"));
		type(locateElement(Locators.ID, "station-select-200-input"), departCode);
		reportStep(departCode +" Departure Airport Code is typed successfully","pass");
		return this;
	}
	
	public SearchFlightByRoute checkAutoSuggestion(String departCode) {
		WebElement autoSuggest = locateElement(Locators.XPATH, "//div[@class='o-station-select__new-station-list__text']//span");
		waitForApperance(autoSuggest);
		autoSuggest.isDisplayed();
		String asText = autoSuggest.getText();
		if(asText.contains(departCode))
		{
			reportStep("Auto Suggestion displayed successfully","pass");
		}
		return this;
	}
	

}
