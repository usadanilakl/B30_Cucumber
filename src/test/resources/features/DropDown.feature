
Feature: Test DropDown menu
  User Story: Verify that drop down menu for month contains 12 months

  Background:
    When dropdown page is open

  Scenario:
    Then month can be selected:
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |