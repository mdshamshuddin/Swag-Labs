Feature: Checkout Info page Functionality

  Background: User logged in to the sauceDemo app
    Given user is at login page
    When user enter valid credentials
    And user click on login button
    Then user should be navigated to menu items
    When user change the sort from name A-Z to low_high
    When user click on all add to cart buttons and print
    And user click on cart shopping button
    Then user should see all items selected
    Then user verify selected item is present
    And click on checkout button

  @functional @checkoutAddress
  Scenario: select all items and do check out with address
    When filed Fname, Lname and postal code
    Then click on continue button
    Then quit the browser

  @Integration @checkoutcancelbtn
  Scenario: Check functionality for select all, fill address and cancel button
    When filed Fname, Lname and postal code
    Then click on continue button
    And click on cancel button
    Then quit the browser

  @functional @errormsg
  Scenario: go to checkout your info page and verify Fname error message
    Then click on continue button
    And user should get first name is required error message
    Then quit the browser

  @functional @errormsg
  Scenario: go to checkout your info page and verify Lname error message
    Then click on continue button
    And user should get Last name is required error message
    Then quit the browser

  @functional @errormsg
  Scenario: go to checkout your info page and verify Postalcode error message
    Then click on continue button
    And user should get Postal code is required error message
    Then quit the browser

  @functional
  Scenario: verify selected items are in checkout page
    When filed Fname, Lname and postal code
    Then click on continue button
    And verify checkout item overview
    Then quit the browser
