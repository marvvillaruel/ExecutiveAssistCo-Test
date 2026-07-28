Feature: Login Test

  Scenario Outline: Login using valid credentials

    Given User navigates to Swag Labs login page
    And User enter valid <username> and <password>
    When User click Login button
    Then User is successfully logged in

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |


