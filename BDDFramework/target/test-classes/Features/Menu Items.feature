Feature: Navigation Menu Functionality

  Background: User logged in to the sauceDemo app
    Given user is at login page
    When user enter valid credentials
    And user click on login button
    Then user should be navigated to menu items

  @functional
  Scenario: Test menu Items price from low to high
    Then user should see low to high prices
    And user click open menu button
    Then user click logout button
    Then quit the browser

  @smoke
  Scenario: Click on add button
    When user click on add to cart button
    And click on remove button
    And user click open menu button
    Then user click logout button
    Then quit the browser

  @allItems @functional @usability
  Scenario: Verify that users can interact with product items.
    When user click on all add to cart buttons
    And click on all remove buttons
    And user click open menu button
    Then user click logout button
    Then quit the browser

  @regression
  Scenario: Validate by changing the sort by Name (Z-A) and high to low
    When user change the sort from name A-Z to Z-A 
    When user click on all add to cart buttons and print
    And click on all remove buttons
    Then user change the sort from Z-A to high to low 
    When user click on all add to cart buttons and print
    And click on all remove buttons
    Then quit the browser
    
    @functional @allitem1
    Scenario: Checking the functionality of all item button is present and working
    And user click open menu button
    Then click on About button
    And verify url 
    Then  quit the browser
    
    @functional @allitem2
    Scenario: Checking the functionality of all item button is present and working
    And user click open menu button
    Then verify all item button is present
    And click on all item button
    Then check for the items present in all item and print items
    Then  quit the browser 
    
   
    
    
    
    
    
    
    
    
    
    
    
