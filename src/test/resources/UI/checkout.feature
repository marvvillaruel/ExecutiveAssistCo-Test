Feature: Checkout Items Test

  Scenario Outline: Add Items to the Card

    Given User navigates to Swag Labs login page
    And User enter valid <username> and <password>
    When User click Login button
    And User is successfully logged in
    And User added an item to the cart
    When User clicks the cart
    Then Item is successfully added

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Remove Items from the Card

    Given User navigates to Swag Labs login page
    And User enter valid <username> and <password>
    When User click Login button
    Then User is successfully logged in
    And User added an item to the cart
    When User clicks the cart
    Then Item is successfully added
    When User Remove the Item from the cart
    Then Item is successfully removed

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Checkout an Item

    Given User navigates to Swag Labs login page
    And User enter valid <username> and <password>
    When User click Login button
    Then User is successfully logged in
    And User added an item to the cart
    When User clicks the cart
    Then Item is successfully added
    And User Checkout the Item
    And User fillout customer information
    When User verify the checkout and finish
    Then a success order is displayed
    Then user can go back to Home Page


    Examples:
      | username      | password     |
      | standard_user | secret_sauce |