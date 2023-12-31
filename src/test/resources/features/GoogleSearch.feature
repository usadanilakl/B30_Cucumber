@regression
Feature: Google Search functionality
  Agile story: As a user I should be able to use google search

  Background: open Google page
  When user is on the Google search page

@googleSearch
  Scenario: Search page default title verification
    Then user should see title is Google

  Scenario:
    When user types "Wooden Spoon" into the search and hits enter
    Then google search displays page with search results and title of the page contains the input value
