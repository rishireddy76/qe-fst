@Accounts @RowTest
Feature: Print account names from specific rows in the Accounts table

  Background: 
    Given I open the CRM login page
    When I enter valid username and password
    And I click the login button
    And I navigate to the "Sales" tab
    And I click on "Accounts"
    Then I should see the Accounts table

  @OddRows 
  Scenario: Print first 5 odd-numbered account rows
    And I print the names of the first 5 odd-numbered account rows

  @EvenRows 
  Scenario: Print first 5 even-numbered account rows
    And I print the names of the first 5 even-numbered account rows
