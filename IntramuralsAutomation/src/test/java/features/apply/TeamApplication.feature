Feature: Team Application
  Background:
    Given user has not applied for a team
    Given user is logged in as player
    Given user clicks Team Applications button

  Scenario: Apply to join a team
    When user selects a team from the dropdown menu
    And user clicks Apply button
    Then an alert saying “Team Application Successful” should appear
    # success alert is shown

  # Scenario: Apply to become an active player
    # Feature is not implemented yet

 #  Scenario: Apply to become an inactive player
    # Feature is not implemented yet
