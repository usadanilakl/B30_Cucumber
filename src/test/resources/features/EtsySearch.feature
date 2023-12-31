@etsy
Feature: etsy search and title

  Background:
    Given etsy home page is open

  Scenario: etsy title verification
    Then expected title is displayed

  Scenario: etsy search functionality
    Then enter Wooden Spoon into the search box and click search button
    And verify page title contains wooden spoon

  Scenario: etsy search functionality with parameterization
    Then enter "Wooden spoon" into the search box and click search button
    And verify page title contains search value from previous step
@dataTable
  Scenario: etsy search functionality with parameterization
    Then enter searchValue into the search box and click search button and verify title
      | Present  |
      | Wedding  |
      | Birthday |

  @scenarioOutline
  Scenario Outline: etsy search functionality with scenario outline
    Then enter "<searchValue>" into the search box
    And verify "<Title>"
    Examples:
    |searchValue|Title|
    |Present    |Present|
    |Wedding    |Wedding|
    |Birthday    |Birthday|