Feature: Captain can approve or deny requests for their teams

  #positive tests - that it works
  Scenario: Captain can approve a team request
    Given user is logged in as captain
    Given user is on the captain homepage
    Then user should see an approve/deny team requests link
    When user clicks the approve button
    Then an alert appears to confirm request approval

  Scenario: Captain can deny a team request
    Given user is logged in as captain
    Given user is on the captain homepage
    Then user should see an approve/deny team requests link
    When user clicks the deny button
    Then an alert appears to confirm request denial


  #negative tests -- that it doesn't work for other users
  Scenario Outline: non-captains cannot approve or deny team requests
    Given user is on the login page
    When user enters a valid "<username>"
    When user enters a valid "<password>"
    Then user is on the "<userrole>" homepage
    Then user should not see an approve/deny team requests link

    Examples:
      |userrole   |username   |password   |
      |player     |Candice202 |pass123    |
      |referee    |refName    |refPass    |
      |admin      |adminName  |adminPass  |