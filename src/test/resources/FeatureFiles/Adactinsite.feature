Feature: To Validate Adactin website

  Scenario: To Validate Adactin Login Page
    Given User launch the browser and navigate to adactin login page
    When User enters the username and password in adacting page
    And User clicks the login button in adacting page
    Then User navigated to the adacting home page
    
#  Scenario: To Validate Adactin Home Page
  	When User selected the Location, Hotel, Room Type and Number of Rooms
  	And User selected the Check In and Check Out Dates
  	And User selected the Adults and Children per Room
  	And User Clicks the Search Button