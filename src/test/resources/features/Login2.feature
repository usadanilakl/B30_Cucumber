@TableLogin
Feature: login scenario

  Background:
    Given login page is open

  Scenario: enter valid credentials
    Then enter username Test
    And enter password Tester
    Then verify ural contains word orders

  @param
  Scenario: enter valid credentials with parameterization
    Then enter username "Test" And enter password "Tester"
    Then verify ural contains word orders

  @data
  Scenario: enter valid credentials with parameterization
    Then enter username And enter password
      | Test | Tester |
    Then verify ural contains word orders

  @outline
  Scenario Outline: enter valid credentials with scenario outline
    Then enter "<username>" And "<password>"

    And verify "<urlContains>" word orders
    #Then verify ural contains word orders

    Examples:
      | username | password |urlContains|
      | Test     | Tester   |orders     |