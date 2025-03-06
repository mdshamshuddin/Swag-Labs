Feature: End to End testing functionality

  Background: User logged in to the sauceDemo app
    Given user is at login page
    When user enter valid credentials
    And user click on login button
    Then user should be navigated to menu items
    When user change the sort from name A-Z to low_high

  @system @functional @End-To-End
  Scenario: select all items and do check out with address
    When user click on all add to cart buttons and print
    And user click on cart shopping button
    Then user should see all items selected
    Then user verify selected item is present
    And click on checkout button
    When filed Fname, Lname and postal code
    Then click on continue button
    Then calculate Items total price
    And Verify actual and expected prices are same
    And click on finish button
    And user click open menu button
    Then user click logout button
    Then quit the browser

  # @system @functional @End-To-End
  Scenario: select one item and do check out with address
    When user click on add an item to cart
    And user click on cart shopping button
    Then user should see all items selected
    Then user verify selected item is present
    And click on checkout button
    When filed Fname, Lname and postal code
    Then click on continue button
    Then calculate Items total price
    And Verify actual and expected prices are same
    And click on finish button
    And user click open menu button
    Then user click logout button
    Then quit the browser

  #@functional @shippingInfo
  Scenario: Checking shipping info visiblitty
    When user click on add an item to cart
    And user click on cart shopping button
    Then user should see all items selected
    Then user verify selected item is present
    And click on checkout button
    When filed Fname, Lname and postal code
    Then click on continue button
    And Check shipping info message
    And user click open menu button
    Then user click logout button
    Then quit the browser

 # @system @totalPrice1
  Scenario: mathematical calculation  of price, tax and total for single item
    When user click on add an item to cart
    And user click on cart shopping button
    Then user should see all items selected
    Then user verify selected item is present
    And click on checkout button
    When filed Fname, Lname and postal code
    Then click on continue button
    And calculate item total tax equals to total price
    And user click open menu button
    Then user click logout button
    Then quit the browser

 # @system @totalPriceAll
  Scenario: mathematical calculation of price, tax and total for all items
    When user click on all add to cart buttons and print
    And user click on cart shopping button
    Then user should see all items selected
    Then user verify selected item is present
    And click on checkout button
    When filed Fname, Lname and postal code
    Then click on continue button
    And calculate item total tax equals to total price
    And user click open menu button
    Then user click logout button
    Then quit the browser

  #@system @cancelbtn
  Scenario: On the Checkout Overview page, click the Cancel button and verify that the user is redirected to the Home page.
    When user click on all add to cart buttons and print
    And user click on cart shopping button
    Then user should see all items selected
    Then user verify selected item is present
    And click on checkout button
    When filed Fname, Lname and postal code
    Then click on continue button
    And click on cancel button
    Then user is navigated to the Home page 
    Then quit the browser
