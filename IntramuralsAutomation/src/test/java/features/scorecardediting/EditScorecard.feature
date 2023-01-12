Feature: Edit scorecard

  Scenario: Edit scorecard
    Given user is logged in as referee
    Given user is on the Officiate Games page
    When user clicks an 'add points' button for the home team
    When user inputs a positive number of fouls into the home team foul input
    When user clicks the add button for the home team
    When user clicks an 'add points' button for the away team
    When user inputs a positive number of fouls to the away team foul input
    When user clicks the add button for the away team
    When user clicks the save button
    Then scores should be updated