Feature: RESTful API CRUD Test

  Scenario: Create a new object
    When I send a POST request to create an object
    Then The response status should be 200
    And The response should contain the object ID

  Scenario: Read the created object
    When I send a POST request to create an object
    And I send a GET request for that object
    Then The response status should be 200
    And The response should contain the correct object data

  Scenario: Update the object
    When I send a POST request to create an object
    And I send a PUT request to update the object
    Then The response status should be 200
    And The response should reflect the updated data

  Scenario: Delete the object
    When I send a POST request to create an object
    And I send a DELETE request for that object
    Then The response status should be 200

  Scenario: Negative case - invalid ID
    When I send a GET request with an invalid object ID
    Then The response status should be 404
