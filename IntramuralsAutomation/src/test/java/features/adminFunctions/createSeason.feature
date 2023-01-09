Feature: Create Season

Scenario: Create Season
    Given User is logged in as admin
    When User clicks Add Season button
    Then User should be on the Season Scheduler page
    When User enters season name
    When User clicks submit
    Then Season should appear in the list