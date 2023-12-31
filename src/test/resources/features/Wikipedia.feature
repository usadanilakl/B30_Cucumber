@wip
Feature: Wikipedia search
  Background:
    Given user is on Wikipedia Home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button


    Scenario: Title
      Then  User sees Searched value is in the wiki title

      Scenario: Header
        Then User sees Searched value is in the main header

        Scenario: Image header
        Then User sees Searched value is in the image header
