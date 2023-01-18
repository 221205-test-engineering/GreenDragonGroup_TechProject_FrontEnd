Feature: Edit scorecard

  Scenario: Edit scorecard
    Given user is logged in as referee
    Given user is officiating a game
    Given user is on the Officiate Games page
    When user clicks on update scores button for a game
    When user clicks an add points button for the home team
    When user clicks the add button for the home team
    When user clicks an add points button for the away team
    When user clicks the add button for the away team
    When user clicks the save button
    When user clicks on back button
    When user clicks on games button
    Then scores should be updated