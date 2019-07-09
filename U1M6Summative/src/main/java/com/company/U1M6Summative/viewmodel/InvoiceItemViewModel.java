package com.company.U1M6Summative.viewmodel;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItemViewModel {
    private int quantity;
    private BigDecimal unitRate;
    private BigDecimal discount;
    private String itemName;
    private String itemDescription;
    private BigDecimal itemDailyRate;
    private int itemId;
    private int invoiceItemId;

    public InvoiceItemViewModel(int quantity, BigDecimal unitRate, BigDecimal discount, String itemName, String itemDescription, BigDecimal itemDailyRate, int itemId, int invoiceItemId) {
        this.quantity = quantity;
        this.unitRate = unitRate;
        this.discount = discount;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemDailyRate = itemDailyRate;
        this.itemId = itemId;
        this.invoiceItemId = invoiceItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(BigDecimal unitRate) {
        this.unitRate = unitRate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BigDecimal getItemDailyRate() {
        return itemDailyRate;
    }

    public void setItemDailyRate(BigDecimal itemDailyRate) {
        this.itemDailyRate = itemDailyRate;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

}
