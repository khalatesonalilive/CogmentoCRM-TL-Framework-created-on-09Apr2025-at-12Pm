package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;

public class CompaniesPage extends BaseClass {

	
	@FindBy(xpath="//button[text()='Create']")
	private WebElement createNewCompany;
	
	@FindBy(name="name")
	private WebElement companyName;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveCompanyNameButton;
	
	
	public CompaniesPage()
	{
		
		PageFactory.initElements(driver,this);
	}
	
	
	public String getCompaniesPageUrl()
	{
		
		String d=driver.getCurrentUrl();
		return d;
	}
	
	public void createNewCompany()
	{
		
		Wait.click(createNewCompany);
		
	}
	
	public void companyNameInfo(String compname)
	{
		Wait.sendKeys(companyName, compname);
		
	}
	
	public void clickSaveButton()
	
	{
		Wait.click(saveCompanyNameButton);
	}
}
