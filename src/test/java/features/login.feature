Feature: Login Feature

  Scenario: Login with valid credentials
    Given user is on login page
    When user login with username "Admin" and password "admin123"
    Then user logged sucessfully and go to "dashboard/index"
    When I get current records
    And Add new Record with employeeName "test"
    Then Verify that the number of records increased by one
    When I Search with the username for the new user
    Then varify that new user is displayed in result search
    When  I delete the newly created user
    Then Varify that the number is records decreased by one



