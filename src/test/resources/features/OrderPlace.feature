@order
Feature: Order place

  Background: open home page
    Given the home page is open

  @dropdown
  Scenario: dropdown
    Then open Order page
    And verify page header contains orders
    Then confirm that product dropdown has following options:
      | MoneyCog   |
      | Familybea  |
      | Screenable |

  @radio
  Scenario: radio buttons
    Then open Order page
    And verify page header contains orders
    Then confirm that the following radio buttons are enabled:
      | Visa             |
      | MasterCard       |
      | American Express |

  @form
  Scenario: fill out the form
    When open Order page


