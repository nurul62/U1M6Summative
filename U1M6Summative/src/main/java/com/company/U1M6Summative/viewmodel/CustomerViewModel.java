package com.company.U1M6Summative.viewmodel;


import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;

import java.util.Objects;

public class CustomerViewModel {
    private int id;
    //private String name;
    private Customer customer;//DTO
    private Invoice invoice;//DTO
    private InvoiceItem invoiceItem;//DTO
    private Item item;//DTO

    //getter method
    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public InvoiceItem getInvoiceItem() {
        return invoiceItem;
    }

    public Item getItem() {
        return item;
    }

    //setter method
    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setInvoiceItem(InvoiceItem invoiceItem) {
        this.invoiceItem = invoiceItem;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        CustomerViewModel that = (CustomerViewModel) o;
        return getId() == that.getId() &&
                Objects.equals(getCustomer(), that.getCustomer()) &&
                Objects.equals(getItem(), that.getItem()) &&
                Objects.equals(getInvoice(), that.getInvoice()) &&
                Objects.equals(getInvoiceItem(), that.getInvoiceItem()
                );
    }

    @Override
    public int hashCode() {
        return  Objects.hash(getId(), getCustomer(), getInvoice(), getItem(), getInvoiceItem());
    }
}
