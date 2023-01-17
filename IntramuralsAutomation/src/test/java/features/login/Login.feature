Feature: login positive and negative

  Background: The user is on the login page
    Given user is on the login page

  #Positive test
  Scenario Outline: login with a variety of credentials
    When user enters a valid "<username>" username
    When user enters a valid "<password>" password
    When user clicks the login button
    Then user is on the "<expected>" homepage

    Examples:
      |username   | password | expected     |
      |Bobby202   | pass123  | Player Page  |
      |mandy101   | pass123  | Referee Page |
      |gatorFan99 | chomp!!  | Admin Page   |

    #Negative test1
  Scenario Outline: login with incorrect or empty password for a variety of users
    When user enters a valid "<username>" username
    When user enters an invalid "<password>" password
    When user clicks the login button
    Then user remains on login page

    Examples:
      |username   | password  |
      |Bobby202   | silentBob |
      |mandy101   | 123456    |
      |gatorFan99 | alabama   |
      |Bobby202   |           |
      |mandy101   |           |
      |gatorFan99 |           |

      #Negative test2
  Scenario Outline: login with incorrect or empty username for a variety of users
    When user enters an invalid "<username>" username
    When user enters a valid "<password>" password
    When user clicks the login button
    Then user remains on login page

    Examples:
      |username       | password    |
      |wrongplayer    | pass123     |
      |wrongref       | pass123     |
      |wrongadmin     | chomp!!     |
      |               | pass123     |
      |               | chomp!!     |

