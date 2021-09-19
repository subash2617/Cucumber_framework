Feature: To Validate Adactin website

  Scenario: To Validate Adactin Login Page
    Given User launch the browser and navigate to adactin login page
    When User enters the username and password in adacting page
    When User clicks the login button in adacting page
    Then User navigated to the adacting home page
  	When User selected the Location, Hotel, Room Type and Number of Rooms
  	When User selected the Check In and Check Out Dates
  	When User selected the Adults and Children per Room
  	When User Clicks the Search Button