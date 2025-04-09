package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;

public class DealsPage extends BaseClass {

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createDealsButton;

	@FindBy(name = "title")
	private WebElement dealTitle;

	@FindBy(xpath = "//div[text()='USD']/following::input[1]")
	private WebElement dealsAmount;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveDealsButton;

	@FindBy(xpath = "//i[@class='trash icon']")
	private WebElement deleteDealStep1;

	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteDealStep2;

	@FindBy(xpath = "//i[@class='trash alternate outline icon']")
	private WebElement againClickOnDeletedDeal;

	@FindBy(xpath = "//a[text()='Deal']")
	private WebElement dealsIcon;

	@FindBy(xpath = "//div[@class='ui fitted checkbox'])[2]")
	private WebElement dealsCheckbox;

	@FindBy(xpath = "//button[text()='Purge Selected']")
	private WebElement purgeSelectedButton;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okButtonClick;

	@FindBy(xpath = "(//i[@class='settings icon'])[1]")
	private WebElement settingsIcon;

	@FindBy(xpath = "//i[@class='power icon']")
	private WebElement logoutButton;

	public DealsPage() {

		PageFactory.initElements(driver, this);
	}

	public String getDealsPageUrl() {
		String rr = driver.getCurrentUrl();
		return rr;
	}

	public void createDealsButton() {

		Wait.click(createDealsButton);
	}

	public void deleteCreatedDeal() throws InterruptedException {

		Wait.click(deleteDealStep1);
		Thread.sleep(3000);
		Wait.click(deleteDealStep2);

	}

	public void againDeletedDeal()

	{
		Wait.click(againClickOnDeletedDeal);
	}

	

	public void logOut() throws InterruptedException {
		Thread.sleep(1000);
		Wait.click(settingsIcon);
		Thread.sleep(1000);
		Wait.click(logoutButton);
	}

}
