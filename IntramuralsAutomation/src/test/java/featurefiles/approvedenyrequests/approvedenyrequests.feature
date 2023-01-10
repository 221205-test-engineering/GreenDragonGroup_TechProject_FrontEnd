Feature: Captain can approve or deny requests for their teams

  #positive tests - that it works
  Scenario: Captain can approve a team request
    Given the user is logged in as captain (implement with input captain username and input captain steps)
    Given the user is on the main page
    Then the user should see an approve/deny team requests link (xpath: "//a[contains(text(), 'Approve/Deny')]);
    When the user clicks the approve/deny link
    Then the user is on the approve/deny page ("team-request-approvedeny/team-request-approvedeny.html")
    #here requests cannot be created so unsure how the GUI wants to order requests to select for approval/denial
  #When the user clicks 'approve' next to a request
  #Then a success message shows up saying request approved

  Scenario: Captain can deny a team request
    Given the user is logged in as captain (implement with input captain username and input captain steps)
    Given the user is on the main page
    Then the user should see an approve/deny team requests link (xpath: "//a[contains(text(), 'Approve/Deny')]);
    When the user clicks the approve/deny link
    Then the user is on the approve/deny page ("team-request-approvedeny/team-request-approvedeny.html")
    #here requests cannot be created so unsure how the GUI wants to order requests to select for approval/denial
  #When the user clicks 'deny' next to a request
  #Then a success message shows up saying request denied


  #negative tests -- that it doesn't work for other users
  Scenario Outline: non-captains cannot approve or deny team requests
    Given the user is logged in as "<userrole>"
      #sub step implementation is to send username and password
    Given the user is on the main page (option-page/option-page.html)
    Then the user should not see an approve/deny team requests link (xpath: "//a[contains(text(), 'Approve/Deny')]");

    Examples:
      |userrole   |username   |password   |
      |player     |Candice202 |pass123    |
      |referee    |refName    |refPass    |
      |admin      |adminName  |adminPass  |