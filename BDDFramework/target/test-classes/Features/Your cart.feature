Feature: Navigation your cart Functionality

  Background: User logged in to the sauceDemo app
    Given user is at login page
    When user enter valid credentials
    And user click on login button
    Then user should be navigated to menu items

  @functional
  Scenario: select low to high and click all items then check cart
    When user change the sort from name A-Z to Z-A
    When user click on all add to cart buttons and print
    And user click on cart shopping button
    Then user should see all items selected
    Then quit the browser

  @functional @homeTocartTohome
  Scenario: Verify adding all the items from and home page and remove in cart
    When user change the sort from name A-Z to low_high
    When user click on all add to cart buttons and print
    And user click on cart shopping button
    Then user should see all items selected
    Then user remove all the items and check the functionality
    Then go back to home page
    Then user change the sort from Z-A to high to low
    Then quit the browser

  @functionality @checkout1
  Scenario: Add one item check out functionality
    When user change the sort from name A-Z to low_high
    When user click on add an item to cart
    And user click on cart shopping button
    Then user verify selected item is present
    And click on checkout button
    Then quit the browser

  @functionality @checkoutAll
  Scenario: Select all items to cart and check for checkout functionality
    When user change the sort from name A-Z to low_high
    When user click on all add to cart buttons and print
    And user click on cart shopping button
    Then user should see all items selected
    Then user verify selected item is present
    And click on checkout button
    Then quit the browser
    
   @functionality @checkoutAddress 
    Scenario: select all items and do check out with address
     When user change the sort from name A-Z to low_high
    When user click on all add to cart buttons and print
    And user click on cart shopping button
    Then user should see all items selected
    Then user verify selected item is present
    And click on checkout button
    When filed Fname, Lname and postal code
    Then click on continue button
    Then quit the browser
    
    @Integration
     Scenario: Check functionality for select all, fill address and cancel button
     When user change the sort from name A-Z to low_high
    When user click on all add to cart buttons and print
    And user click on cart shopping button
    Then user should see all items selected
    Then user verify selected item is present
    And click on checkout button
    When filed Fname, Lname and postal code
    Then click on continue button
    And click on cancel button
    Then quit the browser
    
    
