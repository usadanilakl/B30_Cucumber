
Feature: Search for apple using google search function
  User Story: Use google serarch to look up apple

  Background: open google search page
    When google search page is opened

  Scenario: test search function
    Then input "SDET" into google search field and press enter

    And verify page title contains search value