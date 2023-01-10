Feature: Create Season

Scenario: Create Season
    Given user is logged in as admin
    When user clicks Add Season button
    Then user should be on the Season Scheduler page
    When user enters season name
    When user clicks submit
    Then season should appear in the list