package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.model.Item;

<<<<<<< HEAD
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class ItemViewModel {
    @NotEmpty(message = "Item can not be empty.")
    private Item item;
=======
import java.math.BigDecimal;
import java.util.Objects;

public class ItemViewModel {
    private int itemId;
    private String name;
    private String description;
    private BigDecimal dailyRate;
>>>>>>> 40023ea75e1884dd5a5efde79a60055963f520c9

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemViewModel that = (ItemViewModel) o;
        return itemId == that.itemId &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(dailyRate, that.dailyRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, description, dailyRate);
    }
}
