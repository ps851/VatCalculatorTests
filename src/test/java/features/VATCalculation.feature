Feature: VAT Calculator

  Background:
    Given I am on the VAT Calculator page

  Scenario: Validate VAT Calculator page elements
    Then Page elements are displayed as expected

  Scenario: Validate VAT calculation for a selected country
    When I select "Germany" as the country
    And I select "19" as the VAT rate
    And I enter "100.00" as the net amount
    Then the gross amount should be "119.00"
    And the VAT amount should be "19.00"
    And the Pie Chart is visible

  Scenario: Validate error message for negative net amount input
    When I select "France" as the country
    And I select "20" as the VAT rate
    And I enter "-50.00" as the net amount
    Then the error message should be "Negative values are invalid for a pie chart."