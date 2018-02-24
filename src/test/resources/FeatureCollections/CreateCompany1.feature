#StyoryType=WEB
#Owner=ejagruti
#CreationDate=24-12-2017 Sunday
@CreateComapny
Feature: Create Company
 Background: user is successfully logged in
  	When user opens the "firefox" browser
  	And user enter the url "http://localhost:90/finsys"
  	Then user is on the application login page
    When user enters "dummyfm" as username
    And user enters "passw0rd" as password
    And user clicks on login button
    Then user is on the application home page
    And user gets the message starting with "Welcome" on the top
    
@SmokeTest @RegressionTest
 Scenario: Create Company with all valid inputs
 	Given User is on the Application home page
 	When User clicks on the Manage Company link
 	Then Manage Company page is displayed
 	When User clicks on the New button
 	Then User sees blank company details
 	When User enters "TechM34" as Company Name
 	And  User enters "IT" as Company Type
 	And  User enters  "Support" as Company Subtype
 	And User enters "Pune Wanawadi" as Address
 	And User enters "9980130515" as Phone
 	And User enters "s.gulshetty@gmail.com" as email
 	And User enters "AHJPG9436A" as Pan Details
 	And User enters "AAID4555ID" as Tin Details
 	And User enters "9980130515" as Mobile
 	And User enters "www.google.co.in" as WebSite
 	And User enters "INDIA" as Country
 	And User enters "MAHARASHTRA" as State
 	And User enters "PUNE" as City Name
 	And User enters "30" as Total Employee
 	Then User Clicks on the Save button
 	Then A New Company will be Created as "TechM34"
 	Then click on logout button
 	Then user closes the browser window
 	
 	
@SmokeTest
 Scenario: Create Company with blank Company Type
 	Given User is on the Application home page
 	When User clicks on the Manage Company link
 	Then Manage Company page is displayed
 	When User clicks on the New button
 	Then User sees blank company details
 	When User enters "TechM27" as Company Name
 	Then User Clicks on the Save button
 	Then Error Pop is displayed for Company Type as "Please Select Company Type!!!"
 	Then click on logout button
 	Then user closes the browser window
 
 @SmokeTest
 Scenario: Create Company with blank Country
 Given User is on the Application home page
 	When User clicks on the Manage Company link
 	Then Manage Company page is displayed
 	When User clicks on the New button
 	Then User sees blank company details
 	When User enters "TechM29" as Company Name
 	And  User enters "IT" as Company Type
 	And  User enters  "Support" as Company Subtype
 	And User enters "Pune Wanawadi" as Address
 	And User enters "9980130515" as Phone
 	And User enters "s.gulshetty@gmail.com" as email
 	And User enters "AHJPG9436A" as Pan Details
 	And User enters "AAID4555ID" as Tin Details
 	And User enters "9980130515" as Mobile
 	And User enters "www.google.co.in" as WebSite
  Then User Clicks on the Save button
 	Then Error Pop up is displayed for Country as "Please Select Country!!!"
 	Then click on logout button
 	Then user closes the browser window
 
 @EndToEndTest
 Scenario: Create Company with partial valid & partial invalid inputs
 
 @EndToEndTest
 Scenario: Create Company by passing only mandatory details