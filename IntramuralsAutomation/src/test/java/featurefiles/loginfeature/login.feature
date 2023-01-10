Feature: login positive and negative

  Background: The user is on the login page
    # test is to match current url to expected

  #Positive test
  Scenario Outline: login with a variety of credentials
    #Alternately the step could be written as a put request is sent to "/login" with valid username and password. Meaningful difference?
    When user enters a valid "<username>"
    When user enters a valid "<password>"
    When user clicks login button/submits data
    Then the database connection is made
      #Test to make sure now sql/database connection exception thrown
        # alternately can/needs to? be made with additional steps:
        #then the user controller is called, which calls the registration service, which calls the user dao, which returns the userobject if credentials match
    Then A user object is return with a username and password matching the entered username and password

    Examples:
      |username | password    |
      |player   | playerpass  |
      |captain  | captain pass|
      |ref      | ref pass    |
      |admin    | admin pass  |

    #Negative test1
  Scenario Outline: login with incorrect password for a variety of users
    When user enters a valid "<username>"
    When user enter an invalid "<password>"
    When user clicks login button/submits data
    Then the database connection is made
    Then passwordMismatchException thrown

    Examples:
      |username | password  |
      |player   | wrong pass|
      |captain  | wrong pass|
      |ref      | wrong pass|
      |admin    | wrong pass|

      #Negative test2
  Scenario Outline: login with incorrect password for a variety of users
    When user enters a valid "<username>"
    When user enter an invalid "<password>"
    When user clicks login button/submits data
    Then the database connection is made
    Then NoUsernameFoundException thrown

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
    When user clicks login button/submits data
    Then the database connection is made
    Then NoUsernameFoundException thrown

    Examples:
      |username | password    |
      |wrong    | playerpass  |
      |wrong    | captain pass|
      |wrong    | ref pass    |
      |wrong    | admin pass  |
