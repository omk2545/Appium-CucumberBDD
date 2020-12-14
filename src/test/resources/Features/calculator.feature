Feature: Calculator Automation tests
  @googleSearh
  Scenario Outline: Perform automation tests for calculator app
    Given Launch Calculator Application
    When  Select a number "<number1>"
    Then  perform addition
    And   Select a number "<number2>"
    Then  verify result "<result>"
    Examples:
      |  number1    |    number2    |   result  |
      |    2        |    5          |     7     |
      |    3        |    7          |     10    |