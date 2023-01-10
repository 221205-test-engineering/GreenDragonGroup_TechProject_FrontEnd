Feature: Team Application and Active status change
  Background:
    Given the player is logged in
    Given the player clicks on the Team Applications button

  Scenario: Apply to join a certain team
    When the user selects a team from the dropdown menu
    And the user clicks the Apply button
    Then an alert saying “Team Application Successful” should appear
    # success alert is shown

  Scenario: Apply to become an active player
    # Feature is not implemented yet?

  Scenario: Apply to become an inactive player
    # Feature is not implemented yet?
