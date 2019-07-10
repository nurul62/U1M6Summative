package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.dao.InvoiceDao;
import com.company.U1M6Summative.dao.InvoiceItemDao;
import com.company.U1M6Summative.dao.ItemDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;

import com.company.U1M6Summative.viewmodel.InvoiceItemViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Component //creates a list of components (DAOs)
public class ServiceLayer {
    CustomerDao customerDao;
    InvoiceDao invoiceDao;
    InvoiceItemDao invoiceItemDao;
    ItemDao itemDao;

    @Autowired
    public ServiceLayer(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao, ItemDao itemDao) {
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }

    public InvoiceViewModel getInvoice(int invoiceId) {
        Invoice invoice = invoiceDao.getInvoice(invoiceId);
        Customer customer = customerDao.getCustomer(invoice.getCustomerId());
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getInvoiceItemsByInvoice(invoiceId);
        List<InvoiceItemViewModel> invoiceItems = new ArrayList<>();
        for (InvoiceItem invoiceItem : invoiceItemList) {
            Item item = itemDao.getItem(invoiceItem.getItemId());
            InvoiceItemViewModel itemView = new InvoiceItemViewModel(
                    invoiceItem.getQuantity(),
                    invoiceItem.getUnitRate(),
                    invoiceItem.getDiscount(),
                    item.getName(),
                    item.getDescription(),
                    item.getDailyRate(),
                    item.getItemId(),
                    invoiceItem.getInvoiceItemId()
            );
            invoiceItems.add(itemView);
        }
        InvoiceViewModel viewModel = new InvoiceViewModel();
        viewModel.setCustomer(customer);
        viewModel.setInvoice(invoice);
        viewModel.setItems(invoiceItems);
        return viewModel;
    }

    public Customer addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    public Item addItem(Item item){
        return itemDao.addItem(item);
    }

    public InvoiceViewModel addInvoice(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = invoiceDao.addInvoice(invoiceViewModel.getInvoice());
        List<InvoiceItemViewModel> invoiceItemViewModels = new ArrayList<>();
        for (InvoiceItemViewModel itemViewModel : invoiceViewModel.getItems()) {
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setDiscount(itemViewModel.getDiscount());
            invoiceItem.setUnitRate(itemViewModel.getUnitRate());
            invoiceItem.setQuantity(itemViewModel.getQuantity());
            invoiceItem.setItemId(itemViewModel.getItemId());
            invoiceItem.setInvoiceId(invoice.getInvoiceId());
            invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
            InvoiceItemViewModel invoiceItemViewModel = new InvoiceItemViewModel(
                    itemViewModel.getQuantity(),
                    itemViewModel.getUnitRate(),
                    itemViewModel.getDiscount(),
                    itemViewModel.getItemName(),
                    itemViewModel.getItemDescription(),
                    itemViewModel.getItemDailyRate(),
                    itemViewModel.getItemId(),
                    invoiceItem.getInvoiceItemId()
            );
            invoiceItemViewModels.add(invoiceItemViewModel);
        }
        invoiceViewModel.setInvoice(invoice);
        invoiceViewModel.setItems(invoiceItemViewModels);
        return invoiceViewModel;
    }

}



