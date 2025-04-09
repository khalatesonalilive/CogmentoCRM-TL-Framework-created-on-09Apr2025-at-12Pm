package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[text()='Contacts']")
	private WebElement contactbuttonclick;
	
	@FindBy(xpath="//span[text()='Companies']")
	private WebElement companiesButtonClick;
	
	@FindBy(xpath="//span[text()='Deals']")
	private WebElement dealsPageButton;
	
	
	
	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String getHomePageTitle() {

		String a = driver.getTitle();
		return a;

	}

	public String getHomePageUrl() {

		String b = driver.getCurrentUrl();
		return b;

	}

	public void contactButtonClick()
	{
		Wait.click(contactbuttonclick);
	}
	
	public void companiesButtonClick()
	{
		Wait.click(companiesButtonClick);
		
	}
	public void dealsButtonClick()
	{
		Wait.click(dealsPageButton);
		
	}
	
}
