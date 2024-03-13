Feature: Authenticating User
  THis feature checks for user credentials

  Scenario: Successful login scenario
    Given user opens facebook login page
    When user enters username and password
    And user clicks on login button
    Then user is on home page
