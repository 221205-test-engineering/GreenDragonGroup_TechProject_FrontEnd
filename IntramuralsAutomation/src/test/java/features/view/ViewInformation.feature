Feature: View Information

  Scenario Outline: View all the games
    Given user is logged in using "<username>" and "<password>" as login credentials
    When user clicks Game button
    Then user should see the details of all the games
    # no games are displayed

    Examples:
      | username   | password  |
      | gatorFan99 | chomp!!   |
      | cindy101   | pass123   |
      | Bobby202   | pass123   |
      | eegdell0   | DyAU3y5hLA|


  Scenario Outline: View all the seasons
    Given user is logged in using "<username>" and "<password>" as login credentials
    When user clicks View Seasons button
    Then user should see the season names
    # able to see all seasons

    Examples:
      | username   | password  |
      | gatorFan99 | chomp!!   |
      | cindy101   | pass123   |
      | Bobby202   | pass123   |
      | eegdell0   | DyAU3y5hLA|

  Scenario Outline: View all the venues
    Given user is logged in using "<username>" and "<password>" as login credentials
    When user clicks View Venues button
    Then user should see the venue names
    # able to see all venues

    Examples:
      | username   | password  |
      | gatorFan99 | chomp!!   |
      | cindy101   | pass123   |
      | Bobby202   | pass123   |
      | eegdell0   | DyAU3y5hLA|

  Scenario Outline: View all the schedules
    Given user is logged in using "<username>" and "<password>" as login credentials
    When user is on their homepage
    Then user should see a button to View the Schedule
    # no such button

    Examples:
      | username   | password  |
      | gatorFan99 | chomp!!   |
      | cindy101   | pass123   |
      | Bobby202   | pass123   |
      | eegdell0   | DyAU3y5hLA|

  Scenario: View the Captains of each team as player
    Given user is logged in as player
    When user clicks the Team Applications button
    And user clicks See The Captain button
    Then user should see the captain of the team
    # able to see all team's captains

  Scenario: View the Captains of each team as referee
    Given user is logged in as referee
    When user is on the referee homepage
    Then they should see a button to view Team information
    # nowhere to see captains


  Scenario: View the Captains of each team as admin
    Given user is logged in as admin
    When user is on the admin homepage
    Then they should see a button to view Team information
    # nowhere to see captains

  Scenario: View the Captains of each team as captain
    Given user is logged in as captain
    When user clicks the View Your Team button
    Then user should see the captain of the teams
    # can only see captain of own team



