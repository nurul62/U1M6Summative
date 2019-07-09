package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.dao.InvoiceDao;
import com.company.U1M6Summative.dao.InvoiceItemDao;
import com.company.U1M6Summative.dao.ItemDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component //creates a list of components (DAOs)
public class ServiceLayer {
    private CustomerDao customerDao;
    private InvoiceDao invoiceDao;
    private InvoiceItemDao invoiceItemDao;
    private ItemDao itemDao;

    @Autowired //dependency injection
    public ServiceLayer(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao, ItemDao itemDao) {
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }

//    public Customer addCustomer(Customer customer) {
//        return customerDao.addCustomer(customer);
//    }
//
//    public Item addItem(Item item) {
//        return itemDao.addItem(item);
//    }

    //CUSTOMER API

    @Transactional //take data from viewModel, persist to DAO, communicate w/ DAO
    public CustomerViewModel saveCustomer(CustomerViewModel viewModel) {

        //persist Customer
        Customer customer = new Customer();
        customer.setFirstName(viewModel.getFirstName());
        customer.setLastName(viewModel.getLastName());
        customer.setEmail(viewModel.getEmail());
        customer.setCompany(viewModel.getCompany());
        customer.setPhone(viewModel.getPhone());
        customer = customerDao.addCustomer(customer);
        viewModel.setCustomerId(customer.getCustomerId());

        return viewModel;
    }

    public CustomerViewModel findCustomer(int customerId) {
        Customer customer = customerDao.getCustomer(customerId);

        return buildCustomerViewModel(customer);
    }

    //Helpers

    private CustomerViewModel buildCustomerViewModel(Customer customer) {
        //Assemble CustomerViewModel
        CustomerViewModel cvm = new CustomerViewModel();
        cvm.setCustomerId(customer.getCustomerId());
        cvm.setFirstName(customer.getFirstName());
        cvm.setLastName(customer.getLastName());
        cvm.setEmail(customer.getEmail());
        cvm.setCompany(customer.getCompany());
        cvm.setPhone(customer.getPhone());

        return cvm;
    }

}

