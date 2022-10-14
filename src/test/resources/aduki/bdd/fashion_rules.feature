Feature: Fashion Rules

  Scenario: Handbag and shoes have to be the same colour
    Given "Brown" "shoes" and a "Red" "handbag"
    Then The fashion police say "FAUX_PAS"

  Scenario: It's OK if the handbag and shoes are both black
    Given "Black" "shoes" and a "Black" "handbag"
    Then The fashion police say "IT_WORKS"