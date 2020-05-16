Feature: The user can search customers

  As a user,
  I want to open,
  So than I can search Customers

  Scenario Outline: Open Customers Applications and Search
    Given Address to the Application
    When I search <text>
    And I select <category>
    Then I can see the following Customers
      | id   | name   | email   | city   |
      | <id> | <name> | <email> | <city> |

    Examples:
      | text         | category | id | name      | email                | city      |
      | 1            | Id       | 1  | Alabaster | office@alabaster.com | Melbourne |
      | Postimex     | Name     | 2  | Postimex  | conatact@postimex.pl | Carthage  |
      | info@bond.ir | Email    | 3  | Bondir    | info@bond.ir         | Belfast   |
      | Melbourne    | City     | 1  | Alabaster | office@alabaster.com | Melbourne |