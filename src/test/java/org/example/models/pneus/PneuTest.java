package org.example.models.pneus;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PneuTest {

  static String pneuString;

  @BeforeAll
  static void setUp() {
    pneuString = "195/65R/15H";
  }

  @Test
  void fromUserInput() {
    Pneu pneu = Pneu.fromUserInput(pneuString);
    assert pneu.getLargeur() == 195;
    assert pneu.getRatio() == 65;
    assert pneu.getTypePneu() == TypePneu.R;
    assert pneu.getDiametre() == 15;
    assert pneu.getSaisonPneu() == SaisonPneu.H;
  }
}