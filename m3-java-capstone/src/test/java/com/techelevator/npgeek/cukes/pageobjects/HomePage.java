package com.techelevator.npgeek.cukes.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver webDriver;
	
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
//	HEADER NAV LINKS
	public HomePage clickHomeLink() {
		WebElement homeNavLink = webDriver.findElement(By.id("linkOne"));
		homeNavLink.click();
		return new HomePage(webDriver);
	}
	
	public HomePage clickLogoLink() {
		WebElement homeLogoLink = webDriver.findElement(By.id("logoImg"));
		homeLogoLink.click();
		return new HomePage(webDriver);
	}
	
	public SurveyPage clickSurveyLink() {
		WebElement surveyNavLink = webDriver.findElement(By.id("linkTwo"));
		surveyNavLink.click();
		return new SurveyPage(webDriver);
	}
//	HEADER NAV LINKS

	public ParkDetailPage clickParkImageLink() {
		WebElement imageLink = webDriver.findElement(By.id("parkImg"));
		imageLink.click();
		return new ParkDetailPage(webDriver);
	}
}
