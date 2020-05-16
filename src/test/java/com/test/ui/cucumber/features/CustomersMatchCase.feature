Feature: The user can Match case customers

  As a user,
  I want to open,
  So than I can Match case Customers

  Scenario Outline: Open Customers Applications and Match case
    Given Address to the Application
    When I search <text>
    And I select <category>
    And I Match case
    Then I can see none Customers

    Examples:
      | text                 | category |
      | postimex             | Name     |
      | Office@alabaster.com | Email    |
      | belfast              | City     |