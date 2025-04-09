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
		System.out.println("for GitHub Practice adding TC 1 Case by Sonali");
		System.out.println("for GitHub Practice adding TC 2 Case by Nikhil");
		System.out.println("for GitHub Practice adding TC 3 Case by Sonali");
		System.out.println("for GitHub Practice adding TC 3 Case by Sonali");
		System.out.println("for GitHub Practice adding TC 5 Case by Sonali");
		
		Wait.sendKeys(uuname, userName);
		
		Wait.sendKeys(pass, passWord);
		
		Wait.click(loginbutton);
		
	}
	

	
	
	
}
