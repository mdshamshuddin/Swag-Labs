Feature: Login page automation of saucedemo app

Background:  login page
 Given user is on login page

  @ValidUser @smoke @Integration
  Scenario: check login is successful with valid credentials
    When user enters valid username and password
    And click on login button
    Then user is navigated to Home page
    When click on open Menu button
    Then click on logout button
    And close the browser

  @InvalidUser @smoke
  Scenario: check login is successful with invalid credentials
    When user enters invalid username and password
    And click on login button
    Then user found error message
    And close the browser

  @MultipleValidUser @smoke @Integration
  Scenario Outline: check login is successful with multiple valid credentials
    When user enters valid "<username>" and "<password>"
    And click on login button
    Then user is navigated to Home page
     When click on open Menu button
    Then click on logout button
    And close the browser

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
