Feature: Schedule Games

Scenario: Schedule Games in Season
    Given User is logged in as admin
    When User clicks Schedule Game button
    Then User should be on the Game Scheduling Form page
    When User selects Venue
    When User selects Time
    When User selects Season
    When User selects Sport
    When User selects Home Team
    When User selects Away Team
    When User clicks Schedule button
    When User clicks Back button
    When User clicks Games button
    Then User should see game added to list

Scenario: Game is scheduled for past date
    Given User is logged in as admin
    When User clicks Schedule Game button
    When User selects Venue
    When User selects a time three days prior to the current date
    When User selects Season
    When User selects Sport
    When User selects Home Team
    When User selects Away Team
    When User clicks Schedule button
    When User clicks Back Button
    When User clicks Games Button
    Then User should not see game added to list
