package org.example.models.facture;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.models.modifiers.DiscountProportion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LigneFactureTest {

  private LigneFacture ligneFacture;

  @BeforeEach
  void setUp() {
    ligneFacture = new LigneFacture();
    ligneFacture.setOriginalAmount(100.0f);
  }

  @Test
  void testApplyDiscount() {
    DiscountProportion discount = new DiscountProportion();
    discount.setPercentage(0.2f); // 20% discount

    ligneFacture.applyDiscount(discount);

    assertEquals(20.0f, ligneFacture.getAmountSaved());
    assertEquals(80.0f, ligneFacture.getAmountAfterDiscount());
  }

  @Test
  void testSetAndGetOriginalAmount() {
    ligneFacture.setOriginalAmount(150.0f);
    assertEquals(150.0f, ligneFacture.getOriginalAmount());
  }

  @Test
  void testSetAndGetAmountSaved() {
    ligneFacture.setAmountSaved(30.0f);
    assertEquals(30.0f, ligneFacture.getAmountSaved());
  }

  @Test
  void testSetAndGetAmountAfterDiscount() {
    ligneFacture.setAmountAfterDiscount(70.0f);
    assertEquals(70.0f, ligneFacture.getAmountAfterDiscount());
  }
}
