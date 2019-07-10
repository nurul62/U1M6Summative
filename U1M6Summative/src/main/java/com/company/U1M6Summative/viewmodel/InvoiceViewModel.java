package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;


import javax.validation.constraints.NotNull;
import java.util.List;


public class InvoiceViewModel {
    @NotNull
    private Invoice invoice;
    @NotNull
    private Customer customer;
<<<<<<< HEAD
    private List<InvoiceItemViewModel> items;
=======
    @NotNull
    private InvoiceItem invoiceItem;
    @NotNull
    private Item item;
>>>>>>> origin/master

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InvoiceItemViewModel> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItemViewModel> items) {
        this.items = items;
    }
}
