Feature: Manage Roles

Scenario: Create New Admin
    Given User is logged in as admin
    When User clicks Manage User Roles button
    Then User should be on the User Manager page
    When User clicks on Promote to Admin button on any given User
    Then User should appear with admin role

Scenario: Create new Referee
    Given User is logged in as admin
    When User clicks Manage User Roles button
    Then User should be on the User Manager page
    When User clicks on Promote to Referee button on any given User
    Then User should appear with referee role