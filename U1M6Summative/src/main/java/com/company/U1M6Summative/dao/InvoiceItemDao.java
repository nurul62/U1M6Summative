package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.InvoiceItem;

import java.util.List;

public interface InvoiceItemDao {

    InvoiceItem addInvoiceItem(InvoiceItem invoiceItem);

    InvoiceItem getInvoiceItem(int invoiceItemId);

    List<InvoiceItem> getAllInvoiceItem();

    void updateInvoiceItem(InvoiceItem invoiceItem);

    void deleteInvoiceItem(int invoiceItemId);

    List<InvoiceItem> getInvoiceItemsByInvoice(int invoiceId);


}
