Feature: Calculator
  In order to avoid silly mistakes As a math idiot I want to be told the sum of two numbers

  Scenario: Add two numbers
    Given I have navigated to the calculator
    Given I have entered 70 into the calculator
    And I have also entered 50 into the calculator
    When I press add
    Then the result should be 120 on the screen

  Scenario: Add two numbers
    Given I have navigated to the calculator
    Given I have entered 80 into the calculator
    And I have also entered 50 into the calculator
    When I press add
    Then the result should be 130 on the screen