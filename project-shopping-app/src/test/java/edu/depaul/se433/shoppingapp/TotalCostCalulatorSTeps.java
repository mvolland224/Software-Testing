package edu.depaul.se433.shoppingapp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalCostCalulatorSTeps {

  double initialCost;
  String state;
  ShippingType type;

  @Given("The initial cost was {double} dollars")
  public void initialCostTester(Double doub1) {
    initialCost = doub1;
  }

  @And("The shipping type is {string}")
  public void shippingTypeTester(String state1) {
    if (state1 == "STANDARD"){
      this.type = ShippingType.STANDARD;
    }else {
      this.type = ShippingType.NEXT_DAY;
    }
  }

  @Given("The state is {string}")
  public void stateNameTester(String test1) {
    this.state = test1;
  }

  @Then("The Total cost is {double} dollars")
  public void totalCostTester(double wantedAns) {
    double ans = TotalCostCalculator.calculate(initialCost, state, type);
    assertEquals(wantedAns, ans);
  }
}
