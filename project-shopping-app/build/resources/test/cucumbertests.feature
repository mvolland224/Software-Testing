Feature: Shopping cost calculation
  Scenario: Person is shipping from IL with Standard Shipping
    Given The initial cost was 20.00 dollars
    And The shipping type is "STANDARD"
    And The state is "IL"
    Then The Total cost is 31.20 dollars

  Scenario: Person is shipping from CA with Next_Day Shipping Shipping
      Given The initial cost was 20.0 dollars
      And The shipping type is "NEXT_DAY"
      And The state is "CA"
      Then The Total cost is 50.20 dollars

  Scenario: Person is shipping from PA with Next_Day Shipping Shipping
    Given The initial cost was 100.0 dollars
    And The shipping type is "NEXT_DAY"
    And The state is "PA"
    Then The Total cost is 125.00 dollars

  Scenario: Person is shipping from PA with STANDARD Shipping Shipping
    Given The initial cost was 50.00 dollars
    And The shipping type is "STANDARD"
    And The state is "PA"
    Then The Total cost is 50.00 dollars

  Scenario: Person is shipping from CA with STANDARD Shipping Shipping
    Given The initial cost was 9000.00 dollars
    And The shipping type is "STANDARD"
    And The state is "PA"
    Then The Total cost is 9540.00 dollars

  Scenario: Person is shipping from IL with Next_Day Shipping Shipping
    Given The initial cost was 140.00 dollars
    And The shipping type is "NEXT_DAY"
    And The state is "IL"
    Then The Total cost is 173.40 dollars

  Scenario: Person is shipping from NY with Next_Day Shipping Shipping
    Given The initial cost was 1.00 dollars
    And The shipping type is "NEXT_DAY"
    And The state is "NY"
    Then The Total cost is 26.06 dollars

  Scenario: Person is shipping from NY with STANDARD Shipping Shipping
    Given The initial cost was 12.00 dollars
    And The shipping type is "STANDARD"
    And The state is "NY"
    Then The Total cost is 22.72 dollars

  Scenario: Person is shipping from AZ with Next_Day Shipping Shipping
    Given The initial cost was 20.00 dollars
    And The shipping type is "NEXT_DAY"
    And The state is "AZ"
    Then The Total cost is 22.72 dollars