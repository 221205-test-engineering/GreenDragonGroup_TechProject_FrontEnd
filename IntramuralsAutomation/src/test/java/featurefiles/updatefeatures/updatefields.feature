Feature: Update user fields

  Background: The user is logged in (as...)
    Given the user is on the login page
    When the user logs in (re-use steps from general login feature functionality) - how to reduce code when used across different features, but files should stay in separate folders for readability?
    Then the user is logged in on X page

    #Update password, profile pic, height, weight
    #Positive tests
  Scenario Outline: Positive test for update inputs
    Given the user is on "edit user profile" page ( or put request sent to "/users" while logged in)
    When the user enters "<newData>" in the "<targetField>"
    When the user clicks submit
    Then the user should be prompted with an alert to confirm (

    Examples:
      |newData    | targetField  |
      |jellybean  | password     | Intra
      |urlValidPic| profile_pic  |
      |635        | height       |
      |444        | weight       |

      #Negative Tests for update password, profile pic, height, weight
  #password field has no constraints so no restrictions on special characters or empty fields
  Scenario Outline: invalid info given
    Given the user is on "edit user profile" page
    When the user enters "<newData>" in the "<targetField>"
    When the user clicks submit
    Then no confirmation alert pops up

    Examples:
      |newData    | targetField  |
      |jellybean  | password     |
      |urlValidPic| profile_pic  |
      |cheese     | height       |
      | !^#@*S(   | height       |
      | null      | height       |
      |crackers   | weight       |
      | !^#@*S(   | weight       |
      | null      | weight       |

      #Positive test for updating hide biometrics  -- negative test not possible -- update to same values is idempotent and does not need a logic check
  Scenario: hideBiometrics is changed
    Given the user is on the edit user profile page
    When the user clicks the hide biometrics button
    Then the checkbox changes value (how to write this as implementation?)
    When the user clicks submit
    Then a confirmation dialogue box appears

