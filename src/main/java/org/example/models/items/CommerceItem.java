package org.example.models.items;

import lombok.Getter;
import lombok.Setter;
import org.example.models.modifiers.Discountable;

@Getter
@Setter
public class CommerceItem<E extends Discountable<E>> {
    private float price;
    private boolean available;
    private E item;

    public CommerceItem(E item) {
        this.item = item;
    }
}
