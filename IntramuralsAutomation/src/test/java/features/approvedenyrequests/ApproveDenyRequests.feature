Feature: Captain can approve or deny requests for their teams

  #positive tests - that it works
  Scenario: Captain can approve a team request
    Given user is on the captain homepage
    Then user should see an approve deny team requests link
    #edited text of above step to remove '/' from between approve and deny
    When user clicks the approve deny team requests link
    Then user should be on the team requests page
    When user clicks the approve button
    Then an alert appears to confirm request approval
    Then player request status shows approved

  Scenario: Captain can deny a team request
    Given user is on the captain homepage
    Then user should see an approve deny team requests link
    When user clicks the approve deny team requests link
    Then user should be on the team requests page
    When user clicks the deny button
    Then an alert appears to confirm request denial
    Then player request status shows denied


  #negative tests -- that it doesn't work for other users
  Scenario Outline: non-captains cannot approve or deny team requests
    Given user is on the login page and enters a valid "<username>" username and valid "<password>" password
    Then user is on the "<expectedUser>" homepage
    Then user should not see an approve deny team requests link

    Examples:
      |expectedUser    |username   |password   |
      |Player Page     |slafoy1    |3hOS1nh    |
      |Referee Page    |mandy101   |pass123    |
      |Admin Page      |gatorFan99 |chomp!!    |