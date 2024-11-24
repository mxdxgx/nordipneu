package org.example.models.facture;

import lombok.Getter;
import lombok.Setter;
import org.example.models.modifiers.DiscountProportion;

@Getter
@Setter
public class LigneFacture {

  private float amountSaved;
  private float amountAfterDiscount;
  private float originalAmount;

  public void applyDiscount(DiscountProportion term) {

    float savedAmount = this.getOriginalAmount() * term.getPercentage();
    this.setAmountSaved(savedAmount);

    float amountAfterDiscount = this.getOriginalAmount() - this.getAmountSaved();
    this.setAmountAfterDiscount(amountAfterDiscount);
  }
}
