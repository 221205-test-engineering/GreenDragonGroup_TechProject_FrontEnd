Feature: View Information


  Scenario Outline: View all the games
    Given user is logged in using "<username>" and <"password"> as login credentials
    When the user clicks on the Game button
    Then the user should see the details of all the games
    # no games are displayed

    Examples:
      | username   | password  |
      | gatorFan99 | chomp!!   |
      | cindy101   | pass123   |
      | Bobby202   | pass123   |
      | eegdell0   | DyAU3y5hLA|


  Scenario Outline: View all the seasons
    Given user is logged in using "<username>" and <"password"> as login credentials
    When the user clicks on the View Seasons button
    Then the user should see the season names
    # able to see all seasons

    Examples:
      | username   | password  |
      | gatorFan99 | chomp!!   |
      | cindy101   | pass123   |
      | Bobby202   | pass123   |
      | eegdell0   | DyAU3y5hLA|

  Scenario Outline: View all the venues
    Given user is logged in using "<username>" and <"password"> as login credentials
    When the user clicks on the View Venues button
    Then the user should see the venue names
    # able to see all venues

    Examples:
      | username   | password  |
      | gatorFan99 | chomp!!   |
      | cindy101   | pass123   |
      | Bobby202   | pass123   |
      | eegdell0   | DyAU3y5hLA|

  Scenario Outline: View all the schedules
    Given user is logged in using "<username>" and <"password"> as login credentials
    When The user is on their homepage
    Then the user should see a button to View the Schedule
    # no such button

    Examples:
      | username   | password  |
      | gatorFan99 | chomp!!   |
      | cindy101   | pass123   |
      | Bobby202   | pass123   |
      | eegdell0   | DyAU3y5hLA|

  Scenario: View the Captains of each team as player
    Given user is logged in as player
    When user clicks on the Team Applications button
    And user clicks on See The Captain button
    Then user should see the captain of the team
    # able to see all team's captains

  Scenario: View the Captains of each team as referee
    Given user is logged in as referee
    When the referee is on their homepage
    Then they should see a button to view Team information
    # nowhere to see captains


  Scenario: View the Captains of each team as admin
    Given user is logged in as admin
    When admin is on their homepage
    Then they should see a button to view Team information
    # nowhere to see captains

  Scenario: View the Captains of each team as captain
    Given user is logged in as captain
    When user clicks on the View Your Team button
    Then user should see the captain of the team
    # can only see captain of own team



