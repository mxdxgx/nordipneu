package org.example.models.pneus;

import lombok.Getter;
import lombok.Setter;
import org.example.models.modifiers.Discountable;

import java.util.function.Predicate;

@Getter
@Setter
public class Pneu extends Discountable<Pneu> {
    private int largeur;
    private int ratio;
    private TypePneu typePneu;
    private int diametre;

    public Pneu(int largeur, int ratio, TypePneu typePneu, int diametre, Predicate<Pneu> predicate) {
        this.ratio = ratio;
        this.largeur = largeur;
        this.typePneu = typePneu;
        this.diametre = diametre;
        super.discountable = predicate;
    }
}
