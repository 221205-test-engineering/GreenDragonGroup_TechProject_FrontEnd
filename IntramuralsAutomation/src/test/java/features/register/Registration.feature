Feature: Account registration
  Background:
    Given user is on the registration page

  Scenario: Register for an account with valid information
    When user types in Username with g8tor
    And user types in Password with chomp!
    And user types in Height with 70
    And user types in Weight with 200
    And user types in Profile Picture with
    And user ticks the checkbox for Show Biometrics
    And user clicks on the Submit button on the form
    Then An alert saying “Registration Successful” should appear
    # success alert is shown

  Scenario: Register for an account without username
    When user types in password with pass123 and leaves username blank
    When user clicks on the Submit button on the form
    Then No success message should be shown
     # success alert is still shown

  Scenario: Register for an account without password
    When user types in username with g8tor and leaves password blank
    When user clicks on the Submit button on the form
    Then No success message should be shown
     # success alert is still shown
