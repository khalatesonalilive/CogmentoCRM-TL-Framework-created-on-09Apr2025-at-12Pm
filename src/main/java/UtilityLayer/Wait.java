package UtilityLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class Wait extends BaseClass {

	// sendKeys() method
	public static void sendKeys(WebElement wb, String value) {

		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb)).sendKeys(value);

	}
	
	
	
	//click() method
	public static void click(WebElement wb)
	{
		
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb)).click();
	}
}
