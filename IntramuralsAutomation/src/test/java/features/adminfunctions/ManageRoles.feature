Feature: Manage Roles

Scenario: Create New Admin
    Given user is logged in as admin
    When user clicks Manage User Roles button
    Then user should be on the User Manager page
    When user clicks on Promote to Admin button on any given User
    Then user should appear with admin role

Scenario: Create new Referee
    Given user is logged in as admin
    When user clicks Manage User Roles button
    Then user should be on the User Manager page
    When user clicks on Promote to Referee button on any given User
    Then user should appear with referee role