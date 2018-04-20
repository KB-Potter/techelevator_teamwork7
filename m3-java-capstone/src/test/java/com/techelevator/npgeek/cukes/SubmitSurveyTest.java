package com.techelevator.npgeek.cukes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitSurveyTest {
	
	private static WebDriver webDriver;
	
	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}
	
	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/m3-java-capstone/");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}
	
	@Test
	public void find_elements_by_id() {
		WebElement home = webDriver.findElement(By.id("linkOne"));
		WebElement survey = webDriver.findElement(By.id("linkTwo"));
		assertEquals("Home", home.getText());
		assertEquals("Survey", survey.getText());
	}
	
	@Test
	public void check_for_header_and_footer() {
		WebElement header = webDriver.findElement(By.tagName("header"));
		WebElement footer = webDriver.findElement(By.tagName("footer"));
		assertNotNull(header);
		assertNotNull(footer);
	}
	
	@Test
	public void click_image() {
		WebElement parkImgLink = webDriver.findElement(By.id("parkImg"));
		parkImgLink.click();
		
	}

}
