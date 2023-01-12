Feature: Update user fields

  Scenario Outline: valid info given to all update input fields for all users
    Given user is logged in as "<userrole>" with "<username>" username and "<password>" password
    Given user is on "<userrole>" profile page
    When user enters "<newValidData>" in "<targetfield>" field
    When user clicks the submit button
    Then an alert appears to confirm user information update
    When user accepts update confirmation alert
    Then an alert appears confirming successful user information update

    Examples:
      |newValidData    | targetfield  |userrole  |username      |password     |
      |jellybean       | password     |player    |Bobby202      |pass123      |
      |validUrl        | profile_pic  |player    |Bobby202      |pass123      |
      |635             | height       |player    |Bobby202      |pass123      |
      |444             | weight       |player    |Bobby202      |pass123      |
      |jellybean       | password     |ref       |mandy101      |pass123      |
      |validUrl        | profile_pic  |ref       |mandy101      |pass123      |
      |635             | height       |ref       |mandy101      |pass123      |
      |444             | weight       |ref       |mandy101      |pass123      |
      |jellybean       | password     |admin     |gatorFan99    |chomp!!      |
      |validUrl        | profile_pic  |admin     |gatorFan99    |chomp!!      |
      |635             | height       |admin     |gatorFan99    |chomp!!      |
      |444             | weight       |admin     |gatorFan99    |chomp!!      |

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