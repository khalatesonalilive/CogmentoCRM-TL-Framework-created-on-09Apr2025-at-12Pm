package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;

public class ContactsPage extends BaseClass {

	@FindBy(xpath="//button[text()='Create']")
	private WebElement createContactsButton;
	
	@FindBy(name="first_name")
	private WebElement fname;
	
	@FindBy(name="middle_name")
	private WebElement mname;
	
	@FindBy(name="last_name")
	private WebElement lname;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveContactButton;
	
	@FindBy(xpath="//i[@class='trash icon']")
	private WebElement deleteContact1;
	
	@FindBy(xpath="//button[text()='Delete']")
	private WebElement confirmContactDelete;

	
public ContactsPage()
{
	PageFactory.initElements(driver, this);
}
	

public String getContactsPageUrl()
{
	
	String c=driver.getCurrentUrl();
	return c;
}
	
	public void createContactButton()
	{
		
		Wait.click(createContactsButton);
	}
	
	public void addPersonalInformation(String Firstname, String Middlename, String Lastname) throws InterruptedException
	{
		
		Wait.sendKeys(fname, Firstname);
		Thread.sleep(2000);
		Wait.sendKeys(mname, Middlename);
		Thread.sleep(2000);
		Wait.sendKeys(lname, Lastname);
		Thread.sleep(2000);
		Wait.click(saveContactButton);
		
	}
	
	public void deleteContact()
	{
		
		Wait.click(deleteContact1);
		
	}
	
	public void confirmDeletedContact()
	{
		
		Wait.click(confirmContactDelete);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
