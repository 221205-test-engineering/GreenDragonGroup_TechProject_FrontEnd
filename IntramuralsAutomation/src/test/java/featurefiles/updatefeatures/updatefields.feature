Feature: Update user fields

  Scenario Outline: valid info given to all update input fields for all users
    Given user is logged in as "<userrole>"
    Given user is on "<userrole>" profile page
    When user enters "<newValidData>" in "<targetfield>" field
    When user clicks the submit button
    Then an alert appears to confirm user update
    Then user is on "<userrole>" profile page and the "<newValidData>" appears in the "<targetfield>" field

    Examples:
      |newValidData    | targetfield  |userrole  |
      |jellybean       | password     |player    |
      |validUrl        | profile_pic  |player    |
      |635             | height       |player    |
      |444             | weight       |player    |
      |jellybean       | password     |captain   |
      |validUrl        | profile_pic  |captain   |
      |635             | height       |captain   |
      |444             | weight       |captain   |
      |jellybean       | password     |ref       |
      |validUrl        | profile_pic  |ref       |
      |635             | height       |ref       |
      |444             | weight       |ref       |
      |jellybean       | password     |admin     |
      |validUrl        | profile_pic  |admin     |
      |635             | height       |admin     |
      |444             | weight       |admin     |

      #Negative Tests for update password, profile pic, height, weight
  #password field has no constraints so no restrictions on special characters or empty fields
  Scenario Outline: invalid info given to update input fields for all users
    Given user is logged in as "<userrole>"
    Given user is on "<userrole>" profile page
    When user enters "<newInvalidData>" in "<targetfield>" field
    When user clicks the submit button
    Then no alert appears to confirm user update

    Examples:
      |newInvalidData    | targetfield  |userrole  |
      |jellybean         | password     |player    |
      |invalidURL        | profile_pic  |player    |
      |635               | height       |player    |
      |444               | weight       |player    |
      |jellybean         | password     |captain   |
      |invalidUrl        | profile_pic  |captain   |
      |635               | height       |captain   |
      |444               | weight       |captain   |
      |jellybean         | password     |ref       |
      |invalidUrl        | profile_pic  |ref       |
      |635               | height       |ref       |
      |444               | weight       |ref       |
      |jellybean         | password     |admin     |
      |invalidUrl        | profile_pic  |admin     |
      |635               | height       |admin     |
      |444               | weight       |admin     |

      #Positive test for updating hide biometrics  -- #is there a negative test?
  Scenario Outline: hidebiometrics checkbox can be updated for all roles
    Given user is logged in as "<userrole>"
    Given user is on "<userrole>" profile page
    When user clicks the hide biometrics button
    Then hidebiometrics checkbox changes value
    When user clicks the submit button
    Then an alert appears to confirm checkbox update
    Then user is on "<userrole>" profile page and the checkbox value has been changed

    Examples:
    |userrole|
    |player  |
    |captain |
    |ref     |
    |admin   |