Feature: The user can open the application as a website

  As a user,
  I want to open,
  So than I can see Customers Applications

  Scenario: Open Customers Applications
    Given Address to the Application
    When Page is loaded
    Then I can see the following Customers
      | id | name      | email                | city      |
      | 1  | Alabaster | office@alabaster.com | Melbourne |
      | 2  | Postimex  | conatact@postimex.pl | Carthage  |
      | 3  | Bondir    | info@bond.ir         | Belfast   |
