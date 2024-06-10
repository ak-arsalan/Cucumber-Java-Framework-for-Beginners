Feature: Test Login Portal

  Scenario: Validate the successful login message

    Given Visit Test Automation Page
    When I Enter UserName
    And I Enter Password
    And I Click on the Submit Button
    Then A Successful login message coming
