package Steps;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseLayer.BaseClass;
import PageLayer.CompaniesPage;
import PageLayer.ContactsPage;
import PageLayer.DealsPage;
import PageLayer.HomePage;
import PageLayer.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SnippetsDemo extends BaseClass {

	public static String Firstname;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static ContactsPage contactsPage;
	public static CompaniesPage companiesPage;
	public static DealsPage dealsPage;

	@Given("user open {string} browser")
	public void user_open_browser(String browserName) {

		BaseClass.initialization(browserName);
	}

	@When("user enters valid {string} , {string} and click on login button")
	public void user_enters_valid_and_click_on_login_button(String userName, String passWord)
			throws InterruptedException {

		loginPage = new LoginPage();
		loginPage.loginPageFunctionality(userName, passWord);

		
	}

	@Then("user validate Home Page title")
	public void user_validate_home_page_title() throws InterruptedException {

		homePage = new HomePage();
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Cogmento CRM");
		
	}

	@Then("user validate Home Page URL")
	public void user_validate_home_page_url() throws InterruptedException {

		homePage = new HomePage();
		String actualUrl = homePage.getHomePageUrl();
		boolean a = actualUrl.contains("cogmento");
		Assert.assertEquals(a, true);
		
	}

	@Then("user validate Home Page Logo")
	public void user_validate_home_page_logo() throws InterruptedException {

		boolean logo = driver.findElement(By.xpath("//div[@class='header item']")).isDisplayed();
		Assert.assertEquals(logo, true);
		
	}

	@Given("user click on Contacts button")
	public void user_click_on_contacts_button() throws InterruptedException {

		homePage = new HomePage();
		homePage.contactButtonClick();
		
	}

	@Given("user validate user is on Contacts Page URL")
	public void user_validate_user_is_on_contacts_page_url() throws InterruptedException {

		contactsPage = new ContactsPage();
		String newUrl = contactsPage.getContactsPageUrl();

		boolean b = newUrl.contains("contacts");
		Assert.assertEquals(b, true);
		
	}

	@Given("user click on create contacts button")
	public void user_click_on_create_contacts_button() throws InterruptedException {
		contactsPage = new ContactsPage();
		contactsPage.createContactButton();
		
	}

	@Given("user enter valid {string},{string},{string} and click on save button")
	public void user_enter_valid_and_click_on_save_button(String Firstname, String Middlename, String Lastname)
			throws InterruptedException {

		contactsPage = new ContactsPage();
		contactsPage.addPersonalInformation(Firstname, Middlename, Lastname);
		

	}

	@Given("user delete the created contact by clicking on delete bin")
	public void user_delete_the_created_contact_by_clicking_on_delete_bin() throws InterruptedException {
		Thread.sleep(2000);

		contactsPage = new ContactsPage();
		contactsPage.deleteContact();
	}

	@Given("user click on confirm delete button")
	public void user_click_on_confirm_delete_button() throws InterruptedException {
		// find the physical deletion text and capture it

		
		contactsPage = new ContactsPage();
		contactsPage.confirmDeletedContact();

	}

	@Given("user click on Companies link")
	public void user_click_on_companies_link() throws InterruptedException {
		
		homePage = new HomePage();
		homePage.companiesButtonClick();
		Thread.sleep(3000);
	}

	@Given("user validate the Companies Page Url")
	public void user_validate_the_companies_page_url(DataTable dataTable) throws InterruptedException {

		List<List<String>> ls = dataTable.asLists();

		String tablevalue = ls.get(0).get(0);
		
		companiesPage = new CompaniesPage();
		String uurl = companiesPage.getCompaniesPageUrl();
		boolean d = uurl.contains(tablevalue);
		Assert.assertEquals(d, true);
	}

	@When("user clicks on create new company button")
	public void user_clicks_on_create_new_company_button() throws InterruptedException {
		Thread.sleep(2000);
		companiesPage = new CompaniesPage();
		companiesPage.createNewCompany();
	}

	@Then("user enters valid company name")
	public void user_enters_valid_company_name(DataTable dataTable) throws InterruptedException {

		List<List<String>> ll = dataTable.asLists();

		String compname = ll.get(0).get(0);
		
		companiesPage = new CompaniesPage();
		companiesPage.companyNameInfo(compname);

	}

	@Then("user click on save button")
	public void user_click_on_save_button() throws InterruptedException {
		Thread.sleep(2000);
		companiesPage = new CompaniesPage();
		companiesPage.clickSaveButton();
	}

	@Given("user is on Deals Page and validate the Deals Page url")
	public void user_is_on_deals_page_and_validate_the_deals_page_url() throws InterruptedException {
		
		homePage = new HomePage();
		homePage.dealsButtonClick();
		dealsPage = new DealsPage();
		String dealsurl = dealsPage.getDealsPageUrl();

		boolean g = dealsurl.contains("deals");
		Assert.assertEquals(g, true);
	}

	@When("user click on create deals button")
	public void user_click_on_create_deals_button() throws InterruptedException {
		
		dealsPage = new DealsPage();
		dealsPage.createDealsButton();
	}

	@Then("user enter valid title and amount")
	public void user_enter_valid_title_and_amount() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.name("title")).sendKeys("LifeSaver");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='USD']/following::input[1]")).sendKeys("422");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);
	}

	@Then("user delete the created deal")
	public void user_delete_the_created_deal() throws InterruptedException {
		
		dealsPage = new DealsPage();
		dealsPage.deleteCreatedDeal();
	}

	@Then("user again click on delete bin")
	public void user_again_click_on_delete_bin() throws InterruptedException {
		Thread.sleep(2000);
		dealsPage = new DealsPage();
		dealsPage.againDeletedDeal();
	}

	
	@Then("user click on deals icon")
	public void user_click_on_deals_icon() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Deal']")).click();
	}

	@Then("user click on deleted deals name checkbox and then click on purge deleted button and then click on Ok button")
	public void user_click_on_deleted_deals_name_checkbox_and_then_click_on_purge_deleted_button_and_then_click_on_ok_button()
			throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='ui fitted checkbox'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Purge Selected']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	}

	@Then("user click on settings icon and click on logout")
	public void user_click_on_settings_icon_and_click_on_logout() throws InterruptedException {
		Thread.sleep(2000);
		dealsPage = new DealsPage();
		dealsPage.logOut();
		
	}

	@AfterStep
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {

			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

			scenario.attach(f, "image/png", date + scenario.getName());
		}

		else

		{
			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

			scenario.attach(f, "image/png", date + scenario.getName());

		}

	}
}
