Feature: Login functionality for SuiteCRM
 
  Scenario: Login
    Given the user is on the login page
    When the user logs in with username "<username>" and password "<password>"
    Then the login result should be "<expectedResult>"

  Examples:
      | username | password   | expectedResult |
      | admin    | pa$$w0rd   | success        |
      | admin    | wrongpass  | failure        |


