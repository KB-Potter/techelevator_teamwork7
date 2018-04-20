package com.techelevator.npgeek.cukes.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParkDetailPage {
	
	private WebDriver webDriver;
	
	public ParkDetailPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public HomePage clickHomeLink() {
		WebElement homeNavLink = webDriver.findElement(By.id("linkOne"));
		homeNavLink.click();
		return new HomePage(webDriver);
	}

}
