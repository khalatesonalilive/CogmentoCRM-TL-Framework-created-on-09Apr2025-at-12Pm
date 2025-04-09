package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;

public class LoginPage  extends BaseClass{

	@FindBy(name="email")
	private WebElement uuname;
	
	@FindBy(name="password")
	private WebElement pass;
	
	@FindBy(xpath="//div[text()='Login']")
	private WebElement loginbutton;
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}

	public void loginPageFunctionality(String userName, String passWord) throws InterruptedException
	{
		
		Wait.sendKeys(uuname, userName);
		
		Wait.sendKeys(pass, passWord);
		
		Wait.click(loginbutton);
		
	}
	

	
	
	
}
