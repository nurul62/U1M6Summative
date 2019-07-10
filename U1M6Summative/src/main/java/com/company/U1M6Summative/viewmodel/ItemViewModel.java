package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.model.Item;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class ItemViewModel {
    @NotEmpty(message = "Item can not be empty.")
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemViewModel that = (ItemViewModel) o;
        return Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
