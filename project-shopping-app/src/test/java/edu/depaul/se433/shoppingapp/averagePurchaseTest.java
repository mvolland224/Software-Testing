package edu.depaul.se433.shoppingapp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class averagePurchaseTest {

  @Test
  @DisplayName("Evaluating the correctness of the averagePurchase() function, without actually interacting with the database")
  void averagePurchaseNoDataBaseInteractionTest() {
    PurchaseDBO dboMock = mock(PurchaseDBO.class);
    PurchaseAgent fakeAgent = new PurchaseAgent(dboMock);
    ArrayList<Purchase> fakeArray = new ArrayList<>();
    Purchase nextDayShipping = Purchase.make("Lizzie Mcguire", LocalDate.now(), 200.00, "NY", "NEXT_DAY");
    Purchase standardShipping = Purchase.make("Lizzie Mcguire", LocalDate.now(), 100.00, "CA", "STANDARD");
    fakeArray.add(nextDayShipping);
    fakeArray.add(standardShipping);
    when(dboMock.getPurchases("Lizzie Mcguire")).thenReturn(fakeArray);
    double average = (standardShipping.getCost() + nextDayShipping.getCost()) / 2;
    assertEquals(average, fakeAgent.averagePurchase("Lizzie Mcguire"));

  }

  @Test
  @DisplayName("Evaluating whether PurchaseAgent makes the correct call to PurchaseDBO in the save() function. Again do not interact with the actual database")
  void purchaseAgentCorrectCallTest() {
    PurchaseDBO ans = mock(PurchaseDBO.class);
    PurchaseAgent answer = new PurchaseAgent(ans);
    ArrayList<Purchase> arrayAns = new ArrayList<>();
    Bill newBill = new Bill(10,10,0.06, 22.2);
    Purchase nextDayPurchase = Purchase.make("Lizzie Mcguire", LocalDate.now(), newBill.total(), "NY", "NEXT_DAY");
    when(ans.getPurchases("Lizzie Mcguire")).thenReturn(arrayAns);
    answer.save(nextDayPurchase);
    verify(ans).savePurchase(nextDayPurchase);
  }

  @Test
  @DisplayName("Testing what happens when nothing is in the cart ")
  void nothingInCartTest(){
    PurchaseDBO ans = mock(PurchaseDBO.class);
    PurchaseAgent answer = new PurchaseAgent(ans);
    ArrayList<Purchase> arrayAns = new ArrayList<>();
    when(ans.getPurchases("Lizzie Mcguire")).thenReturn(arrayAns);
    assertEquals(0.0, answer.averagePurchase("Lizzie Mcguire"));
  }



}