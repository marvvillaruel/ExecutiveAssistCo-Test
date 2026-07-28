Feature: Login Test

  Scenario: Login using valid credentials

    Given User navigates to Swag Labs login page
    And User enter valid username and password
    When User click Login button
    Then User is successfully logged in
