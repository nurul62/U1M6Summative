package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;

import java.util.List;


public class InvoiceViewModel {
    private Invoice invoice;
    private Customer customer;
    private List<InvoiceItemViewModel> items;

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
