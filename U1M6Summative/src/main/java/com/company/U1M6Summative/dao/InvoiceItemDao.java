package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.InvoiceItem;

import java.util.List;

public interface InvoiceItemDao {

    InvoiceItem addItem(InvoiceItem invoiceItem);

    InvoiceItem getInvoiceItem(int id);

    List<InvoiceItem> getAllInvoiceItems();

    void updateItem(InvoiceItem invoiceItem);

    void deleteInvoiceItem(int id);


}
