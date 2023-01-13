Feature: Update user fields

  Scenario Outline: valid info given to all update input fields for all users
    Given user is logged in as "<userrole>" with "<username>" username and "<password>" password
    Given user is on the edit profile page
    When user enters "<newValidData>" valid data in "<targetfield>" field
    When user clicks the submit button
    Then an alert appears to confirm user information update
    When user accepts update confirmation alert
    Then an alert appears confirming successful user information update
    Then default value "<defaultvalue>" is reset in "<targetfield>" field

    Examples:
      |newValidData    | defaultvalue| targetfield  |userrole  |username      |password     |
      |jellybean       | pass123      |password     |player    |Bobby202      |pass123      |
      |635             | 55           |height       |player    |Bobby202      |pass123      |
      |444             | 150          |weight       |player    |Bobby202      |pass123      |
      |validUrl        | noUrl        |picture      |player    |Bobby202      |pass123      |
      |                |              |biometrics   |player    |Bobby202      |pass123      |
      |jellybean       | pass123      |password     |ref       |mandy101      |pass123      |
      |635             | 66           | height      |ref       |mandy101      |pass123      |
      |444             | 160          |weight       |ref       |mandy101      |pass123      |
      |validUrl        | oldUrl       |picture      |ref       |mandy101      |pass123      |
      |                |              |biometrics   |ref       |mandy101      |pass123      |
      |jellybean       | chomp!!      | password    |admin     |gatorFan99    |chomp!!      |
      |635             | 70           |height       |admin     |gatorFan99    |chomp!!      |
      |444             | 160          |weight       |admin     |gatorFan99    |chomp!!      |
      |validUrl        | oldPic       |picture      |admin     |gatorFan99    |chomp!!      |
      |                |              |biometrics   |admin     |gatorFan99    |chomp!!      |

      #Need to be able to send object or other non-string invalid input to test string fields
  Scenario Outline: invalid info given to update input fields for all users
    Given user is logged in as "<userrole>" with "<username>" username and "<password>" password
    Given user is on the edit profile page
    When user enters "<newInvalidData>" invalid data in "<targetfield>" field
    When user clicks the submit button
    Then no invalid characters are accepted in "<targetfield>" field

    Examples:
      |newInvalidData | targetfield |userrole  |username      |password     |
      |string         |height       |player    |Bobby202      |pass123      |
      |@1#            |height       |player    |Bobby202      |pass123      |
#      |               |height       |player    |Bobby202      |pass123      | empty values can pass as it will update the field to a default value of 0
      |cheese         |weight       |player    |Bobby202      |pass123      |
      |!!             |weight       |player    |Bobby202      |pass123      |
      |and            | height      |ref       |mandy101      |pass123      |
      |&&             | height      |ref       |mandy101      |pass123      |
      |poptarts       |weight       |ref       |mandy101      |pass123      |
      |$              |weight       |ref       |mandy101      |pass123      |
      |For            |height       |admin     |gatorFan99    |chomp!!      |
      |^^             |height       |admin     |gatorFan99    |chomp!!      |
      |breakfast      |weight       |admin     |gatorFan99    |chomp!!      |
      |~~~            |weight       |admin     |gatorFan99    |chomp!!      |
