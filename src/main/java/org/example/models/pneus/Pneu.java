package org.example.models.pneus;

import java.util.function.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.example.models.modifiers.Discountable;

@Getter
@Setter
public class Pneu extends Discountable<Pneu> {

  private final int largeur;
  private final int ratio;
  private final int diametre;
  private final TypePneu typePneu;
  private final SaisonPneu saisonPneu;

  public Pneu() {
    this.ratio = 0;
    this.largeur = 0;
    this.typePneu = TypePneu.N;
    this.diametre = 0;
    this.saisonPneu = SaisonPneu.N;
    super.discountable = null;
  }

  public Pneu(int largeur, int ratio, TypePneu typePneu, int diametre, SaisonPneu saisonPneu,
      Predicate<Pneu> predicate) {
    this.ratio = ratio;
    this.largeur = largeur;
    this.typePneu = typePneu;
    this.diametre = diametre;
    this.saisonPneu = saisonPneu;
    super.discountable = predicate;
  }

  public static Pneu fromUserInput(String userInput) {
    String[] parts = userInput.split("/");
    if (parts.length != 3) {
      return new Pneu();
    }
    try {
      int largeur = Integer.parseInt(parts[0]);
      int ratio = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));
      TypePneu typePneu = TypePneu.valueOf(parts[1].substring(parts[1].length() - 1));
      int diametre = Integer.parseInt(parts[2].substring(0, parts[2].length() - 1));
      SaisonPneu saisonPneu = SaisonPneu.valueOf(parts[2].substring(parts[2].length() - 1));
      return new Pneu(largeur, ratio, typePneu, diametre, saisonPneu, null);
    } catch (NumberFormatException e) {
      return new Pneu();
    }
  }

  @Override
  public String toString() {
    return "Pneu{" +
        "largeur=" + largeur +
        ", ratio=" + ratio +
        ", diametre=" + diametre +
        ", typePneu=" + typePneu +
        ", saisonPneu=" + saisonPneu +
        '}';
  }
}
