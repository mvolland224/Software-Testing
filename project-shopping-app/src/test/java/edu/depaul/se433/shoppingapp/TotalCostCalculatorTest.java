package edu.depaul.se433.shoppingapp;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class TotalCostCalculatorTest {

  @Test
  @DisplayName("Gotta see if the cart is empty")
  void verifyEmptyShoppingCart() {
    ShoppingCart test = new ShoppingCart();
    if (test.itemCount() <= 0) {
      assertThrows(IllegalArgumentException.class, () -> TotalCostCalculator.calculate(test, "AR", ShippingType.STANDARD));
    }
  }

  @Test
  @DisplayName("Miniumum Boundary Test For Inital Cost/NoTax/StandardShipping")
  void minBoundTestInitalCostNoTaxStandardShipping(){
    double ans = TotalCostCalculator.calculate(1.00, "AR", ShippingType.STANDARD);
    assertEquals(11, ans,2);
  }

  @Test
  @DisplayName("Just Above Min Boundary Test For Inital Cost/NoTax/StandardShipping")
  void justAboveMinBoundTestInitalCostNoTaxStandardShipping(){
    double ans = TotalCostCalculator.calculate(2.00, "AR", ShippingType.STANDARD);
    assertEquals(12, ans, 2);
  }

  @Test
  @DisplayName("Nominal Value Boundary Test For Inital Cost/NoTax/StandardShipping")
  void nomialBoundTestInitalCostNoTaxStandardShipping(){
    double ans = TotalCostCalculator.calculate(50000.00, "AR", ShippingType.STANDARD);
    assertEquals(50000, ans, 2);
  }

  @Test
  @DisplayName("Just Below Max Boundary Test For Inital Cost/NoTax/StandardShipping")
  void belowMaxBoundTestInitalCostNoTaxStandardShipping(){
    double ans = TotalCostCalculator.calculate(99990.00, "AR", ShippingType.STANDARD);
    assertEquals(99990.00, ans, 2);
  }

  @Test
  @DisplayName("Max Boundary Test For Inital Cost/NoTax/StandardShipping")
  void maxBoundTestInitalCostNoTaxStandardShipping(){
    double ans = TotalCostCalculator.calculate(99999.99, "AR", ShippingType.STANDARD);
    assertEquals(99999.99, ans, 2);
  }

  @Test
  @DisplayName("Miniumum Boundary Test For Inital Miniumum Boundary Test For Inital Cost/Tax/StandardShipping\nCost/Tax/StandardShipping\n")
  void minBoundTestInitalCostTaxStandardShipping(){
    double ans = TotalCostCalculator.calculate(1.00, "IL", ShippingType.STANDARD);
    assertEquals(11.06, ans, 2);
  }

  @Test
  @DisplayName("Just Above Min Boundary Test For Inital Cost/Tax/StandardShipping\n")
  void aboveMinBoundTestInitalCostTaxStandardShipping(){
    double ans = TotalCostCalculator.calculate(2.00, "IL", ShippingType.STANDARD);
    assertEquals(12.12, ans, 2);
  }

  @Test
  @DisplayName("Nominal Value  Boundary Test For Inital Cost/Tax/StandardShipping\n")
  void nominalBoundTestInitalCostTaxStandardShipping(){
    double ans = TotalCostCalculator.calculate(50000.00, "IL", ShippingType.STANDARD);
    assertEquals(53000.00, ans, 2);
  }

  @Test
  @DisplayName("just below Max Value  Boundary Test For Inital Cost/Tax/StandardShipping\n")
  void belowMaxBoundTestInitalCostTaxStandardShipping(){
    double ans = TotalCostCalculator.calculate(99990.00, "IL", ShippingType.STANDARD);
    assertEquals(105989.4, ans, 2);
  }

  @Test
  @DisplayName("Max Value  Boundary Test For Inital Cost/Tax/StandardShipping\n")
  void maxBoundTestInitalCostTaxStandardShipping(){
    double ans = TotalCostCalculator.calculate(99999.99, "IL", ShippingType.STANDARD);
    assertEquals(105998.94, ans, 2);
  }

  @Test
  @DisplayName("Miniumum Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void minBoundTestInitalCostNoTaxNextDayShipping(){
    double ans = TotalCostCalculator.calculate(1.00, "AR", ShippingType.NEXT_DAY);
    assertEquals(26.00, ans, 2);
  }

  @Test
  @DisplayName("Just Above Miniumum Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void aboveMinBoundTestInitalCostNoTaxNextDayShipping(){
    double ans = TotalCostCalculator.calculate(2.00, "AR", ShippingType.NEXT_DAY);
    assertEquals(27.00, ans, 2);
  }

  @Test
  @DisplayName("Just Above Nomial Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void nomialBoundTestInitalCostNoTaxNextDayShipping(){
    double ans = TotalCostCalculator.calculate(50000.00, "AR", ShippingType.NEXT_DAY);
    assertEquals(50025.00, ans, 2);
  }

  @Test
  @DisplayName("Just Below Max Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void belowMaxBoundTestInitalCostNoTaxNextDayShipping(){
    double ans = TotalCostCalculator.calculate(99990.00, "AR", ShippingType.NEXT_DAY);
    assertEquals(100015.00, ans, 2);
  }

  @Test
  @DisplayName("Max Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void maxBoundTestInitalCostNoTaxNextDayShipping(){
    double ans = TotalCostCalculator.calculate(99999.99, "AR", ShippingType.NEXT_DAY);
    assertEquals(100024.00, ans, 2);
  }

  @Test
  @DisplayName("Miniumum Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void minBoundTestInitalCostTaxNextDayShipping(){
    double ans = TotalCostCalculator.calculate(1.00, "IL", ShippingType.NEXT_DAY);
    assertEquals(26.06, ans, 2);
  }

  @Test
  @DisplayName("Above Miniumum Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void aboveMinBoundTestInitalCostTaxNextDayShipping(){
    double ans = TotalCostCalculator.calculate(2.00, "IL", ShippingType.NEXT_DAY);
    assertEquals(27.12, ans, 2);
  }

  @Test
  @DisplayName("Nominal Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void nominalBoundTestInitalCostTaxNextDayShipping(){
    double ans = TotalCostCalculator.calculate(50000.00, "IL", ShippingType.NEXT_DAY);
    assertEquals(53025.00, ans, 2);
  }

  @Test
  @DisplayName("Below Max Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void belowMaxBoundTestInitalCostTaxNextDayShipping(){
    double ans = TotalCostCalculator.calculate(99990.00, "IL", ShippingType.NEXT_DAY);
    assertEquals(106014.4, ans, 2);
  }

  @Test
  @DisplayName("Max Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void maxBoundTestInitalCostTaxNextDayShipping(){
    double ans = TotalCostCalculator.calculate(99999.99, "IL", ShippingType.NEXT_DAY);
    assertEquals(106023.94, ans, 2);
  }

  @Test
  @DisplayName("Miniumum Boundary Test For Inital Cost/NoTax/NextDayShipping \n")
  void minBoundTestInitalCostTaxNextDayShippingCA(){
    double ans = TotalCostCalculator.calculate(1.00, "CA", ShippingType.NEXT_DAY);
    assertEquals(26.06, ans, 2);
  }

  @Test
  @DisplayName("Above Miniumum Boundary Test For Inital Cost/NoTax/NextDayShipping CA \n")
  void aboveMinBoundTestInitalCostTaxNextDayShippingCA(){
    double ans = TotalCostCalculator.calculate(2.00, "CA", ShippingType.NEXT_DAY);
    assertEquals(27.12, ans, 2);
  }

  @Test
  @DisplayName("Nominal Boundary Test For Inital Cost/NoTax/NextDayShipping CA \n")
  void nominalBoundTestInitalCostTaxNextDayShippingCA(){
    double ans = TotalCostCalculator.calculate(50000.00, "CA", ShippingType.NEXT_DAY);
    assertEquals(53025.00, ans, 2);
  }

  @Test
  @DisplayName("Below Max Boundary Test For Inital Cost/NoTax/NextDayShipping CA \n")
  void belowMaxBoundTestInitalCostTaxNextDayShippingCA(){
    double ans = TotalCostCalculator.calculate(99990.00, "CA", ShippingType.NEXT_DAY);
    assertEquals(106014.4, ans, 2);
  }

  @Test
  @DisplayName("Max Boundary Test For Inital Cost/NoTax/NextDayShipping CA \n")
  void maxBoundTestInitalCostTaxNextDayShippingCA(){
    double ans = TotalCostCalculator.calculate(99999.99, "CA", ShippingType.NEXT_DAY);
    assertEquals(106023.94, ans, 2);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/WeakRobust.csv", numLinesToSkip = 1)
  @DisplayName("Final Weak Robust Tests") //InitalCost,State,ShippingType,Result
  public void weakRobustTests(double initialCost, String state, String shippingType, double wantedResult) {
    ShippingType testShip;
    if (shippingType.equals("STANDARD"))
      testShip = ShippingType.STANDARD;
    else if (shippingType.equals("NEXT_DAY"))
      testShip = ShippingType.NEXT_DAY;
    else {
      assertEquals(wantedResult, -1);
      return;
    }
    if (wantedResult > 0) {
      double resultExpected = TotalCostCalculator.calculate(initialCost, state, testShip);
      assertEquals(wantedResult, resultExpected, 2);
    } else {
      assertThrows(IllegalArgumentException.class, () ->  TotalCostCalculator.calculate(initialCost, state, testShip));
    }
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/FinalStrongRobustTests.csv", numLinesToSkip = 1)
  @DisplayName("Final Strong Normal Tests")
  void strongNormalTests(double initialCost, String state, String shipType, double wantedResult) {
    ShippingType testShip;
    if (shipType.equals("STANDARD"))
      testShip = ShippingType.STANDARD;
    else {
      testShip = ShippingType.NEXT_DAY;
    }
    double result = TotalCostCalculator.calculate(initialCost, state, testShip);
    assertEquals(wantedResult, result, 2);
  }



}
