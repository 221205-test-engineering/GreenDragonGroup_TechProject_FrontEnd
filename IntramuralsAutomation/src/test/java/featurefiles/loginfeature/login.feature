Feature: login positive and negative

  Background: The user is on the login page
    Given user is on the login page

  #Positive test
  Scenario Outline: login with a variety of credentials
    When user enters a valid "<username>"
    When user enters a valid "<password>"
    When user clicks the login button
    Then user is on the "<expected>" homepage

    Examples:
      |username | password    | expected |
      |player   | playerpass  |          |
      |captain  | captain pass|          |
      |ref      | ref pass    |          |
      |admin    | admin pass  |          |


    #Negative test1
  Scenario Outline: login with incorrect password for a variety of users
    When user enters a valid "<username>"
    When user enter an invalid "<password>"
    When user clicks the login button
    Then user remains on login page

    Examples:
      |username | password  |
      |player   | wrong pass|
      |captain  | wrong pass|
      |ref      | wrong pass|
      |admin    | wrong pass|

      #Negative test2
  Scenario Outline: login with incorrect username for a variety of users
    When user enters a invalid "<username>"
    When user enter an valid "<password>"
    When user clicks the login button
    Then user remains on login page

    Examples:
      |username | password    |
      |wrong    | playerpass  |
      |wrong    | captain pass|
      |wrong    | ref pass    |
      |wrong    | admin pass  |

    #Negative test3
  Scenario Outline: login with empty username field
    When user enters a valid "<username>"
    When user enter an invalid "<password>"
    When user clicks the login button
    Then user remains on login page

    Examples:
      |username | password    |
      |         | playerpass  |
      |         | captain pass|
      |         | ref pass    |
      |         | admin pass  |
