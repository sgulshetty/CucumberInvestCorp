package ejagruti.finsys.modules;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ejagruti.finsys.pageobjects.baseclass;
import ejagruti.finsys.pageobjects.homepage;

@SuppressWarnings("deprecation")
public class CreateCompany {
	homepage homepageobj=null;
	
	@Given("^User is on the Application home page$")
	public void user_is_on_the_Application_home_page() throws Exception {
	    System.out.println("User on Application Home Page");
	}
	
	@When("^User clicks on the Manage Company link$")
	public void user_clicks_on_the_Manage_Company_link() throws Exception {
		baseclass.driver.findElement(By.xpath("//a[.='Manage Company']")).click();
		Thread.sleep(6000);
		baseclass.driver.switchTo().frame(0);
		}

	@Then("^Manage Company page is displayed$")
	public void manage_Company_page_is_displayed() throws Exception {
		
		
	}

	@When("^User clicks on the New button$")
	public void user_clicks_on_the_New_button() throws Exception {
		baseclass.driver.findElement(By.xpath("//span[.='New']")).click();
		Thread.sleep(5000);    
	}

	@Then("^User sees blank company details$")
	public void user_sees_blank_company_details() throws Exception {
	    
	}

	@When("^User enters \"(.*)\" as Company Name$")
	public void user_enters_as_Company_Name(String Compname) throws Exception {
	    baseclass.driver.findElement((By.xpath("//input[@name='name']"))).sendKeys(Compname);
	}

	@When("^User enters \"(.*)\" as Company Type$")
	public void user_enters_as_Company_Type(String Comptype) throws Exception {
		Select sel = new Select(baseclass.driver.findElement((By.xpath("//select[@id='companytype']"))));
		sel.selectByValue(Comptype);
		Thread.sleep(3000);
	}

	@When("^User enters  \"(.*)\" as Company Subtype$")
	public void user_enters_as_Company_Subtype(String Compsubtype) throws Exception {
		Select sel = new Select(baseclass.driver.findElement((By.xpath("//select[@name='subtype']"))));
		sel.selectByValue(Compsubtype);
		Thread.sleep(1000);
	}

	@When("^User enters \"(.*)\" as Address$")
	public void user_enters_as_Address(String Address) throws Exception {
		baseclass.driver.findElement((By.xpath("//input[@name='address']/preceding-sibling::*"))).sendKeys(Address);
	}

	@When("^User enters \"(.*)\" as Phone$")
	public void user_enters_as_Phone(String phone) throws Exception {
		baseclass.driver.findElement((By.xpath("//input[@name='phone']/preceding-sibling::*"))).sendKeys(phone);
	}

	@When("^User enters \"(.*)\" as email$")
	public void user_enters_as_email(String email) throws Exception {
		baseclass.driver.findElement((By.xpath("//input[@name='email']"))).sendKeys(email);
	    
	}

	@When("^User enters \"(.*)\" as Pan Details$")
	public void user_enters_as_Pan_Details(String Pandetails) throws Exception {
		baseclass.driver.findElement((By.xpath("//input[@name='pan']"))).sendKeys(Pandetails);
	}

	@When("^User enters \"(.*)\" as Tin Details$")
	public void user_enters_as_Tin_Details(String Tindetails) throws Exception {
		baseclass.driver.findElement((By.xpath("//input[@name='tin']"))).sendKeys(Tindetails);
	}

	@When("^User enters \"(.*)\" as Mobile$")
	public void user_enters_as_Mobile(String mobile) throws Exception {
		baseclass.driver.findElement((By.xpath("//input[@name='mobile']/preceding-sibling::*"))).sendKeys(mobile);
	}

	@When("^User enters \"(.*)\" as WebSite$")
	public void user_enters_as_WebSite(String Website) throws Exception {
		baseclass.driver.findElement((By.xpath("//input[@name='website']"))).sendKeys(Website);
	}

	@When("^User enters \"(.*)\" as Country$")
	public void user_enters_as_Country(String Country) throws Exception {
		Select sel = new Select(baseclass.driver.findElement((By.xpath("//select[@id='countryid']"))));
		sel.selectByVisibleText(Country);
		Thread.sleep(1000);
	}

	@When("^User enters \"(.*)\" as State$")
	public void user_enters_as_State(String State) throws Exception {
		Select sel = new Select(baseclass.driver.findElement((By.xpath("//select[@name='state']"))));
		sel.selectByValue(State);
		Thread.sleep(1000);
	    
	}

	@When("^User enters \"(.*)\" as City Name$")
	public void user_enters_as_City_Name(String CityName) throws Exception {
		Select sel = new Select(baseclass.driver.findElement((By.xpath("//select[@name='city']"))));
		sel.selectByValue(CityName);
		Thread.sleep(1000);
	}

	@When("^User enters \"(.*)\" as Total Employee$")
	public void user_enters_as_Total_Employee(String totalemp) throws Exception {
		baseclass.driver.findElement((By.xpath("//input[@name='totalemployee']/preceding-sibling::*"))).sendKeys(totalemp);
	    
	}

	@Then("^User Clicks on the Save button$")
	public void user_Clicks_on_the_Save_button() throws Exception {
		
	    baseclass.driver.findElement(By.xpath("//span[.='Save']")).click();
	
	}
	
	@SuppressWarnings("deprecation")
	@Then("^A New Company will be Created as \"(.*)\"")
	public void VerifyNewCompanyCreated(String expectedcompany)throws Exception{
		Thread.sleep(4000);
		String actualcomp = baseclass.driver.findElement(By.xpath("//tr[@id='datagrid-row-r1-2-0']/td[1]/div")).getText();
		Assert.assertEquals(expectedcompany, actualcomp);
		System.out.println("Company is Created Successfully");
	}
	
	 @When("^click on logout button$")
		public void ClickOnLogout() throws InterruptedException
		{
		   System.out.println("Inside Logout");
		   Thread.sleep(1000);
		   baseclass.driver.switchTo().defaultContent();
		   homepageobj=new homepage(baseclass.driver);
		   Thread.sleep(1000);
		 	homepageobj.logout.click();
		}
	
	@Then("^Error Pop is displayed for Company Type as \"(.*)\"")
	public void VerifyErrorpopforCompanyType(String expectedAlertMessage) throws InterruptedException{
		Thread.sleep(1000);
		Alert companyTypeAlert = baseclass.driver.switchTo().alert();
		String actualAlertMessage = companyTypeAlert.getText();
		System.out.println(actualAlertMessage);
		Thread.sleep(1000);
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		companyTypeAlert.accept();
	}

	@Then("^Error Pop up is displayed for Country as \"(.*)\"")
	public void VerifyErrorpopforCountry(String expectedAlertMessage) throws InterruptedException{
		Thread.sleep(1000);
		Alert CountryAlert = baseclass.driver.switchTo().alert();
		String actualAlertMessage = CountryAlert.getText();
		System.out.println(actualAlertMessage);
		Thread.sleep(1000);
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		CountryAlert.accept();
	}
	
	
	 
}
