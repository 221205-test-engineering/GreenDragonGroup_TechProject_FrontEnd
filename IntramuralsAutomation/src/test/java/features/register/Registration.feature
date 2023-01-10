Feature: Account registration
  Background:
    Given The user on the registration page

  Scenario: Register for an account with valid information
    When The user types in Username with g8tor
    And The user types in Password with chomp!
    And The user types in Height with 70
    And The user types in Weight with 200
    And The user types in Profile Picture with
    And The user ticks the checkbox for Show Biometrics
    And The user clicks on the Submit button on the form
    Then An alert saying “Registration Successful” should appear
    # success alert is shown

  Scenario: Register for an account without username
    When The user clicks on the Register button
    Then The user should see the registration form
    When The user types in password with pass123 and leaves username blank
    When The user clicks on the Submit button on the form
    Then No success message should be shown
     # success alert is still shown

  Scenario: Register for an account without password
    When The user clicks on the Register button
    Then The user should see the registration form
    When The user types in username with g8tor and leaves password blank
    When The user clicks on the Submit button on the form
    Then No success message should be shown
     # success alert is still shown
