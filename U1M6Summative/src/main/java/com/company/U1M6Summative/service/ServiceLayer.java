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
<<<<<<< HEAD
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
=======
>>>>>>> 40023ea75e1884dd5a5efde79a60055963f520c9
import com.company.U1M6Summative.viewmodel.ItemViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
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

    public List<CustomerViewModel> findAllCustomers() {
        List<Customer> cList = customerDao.getAllCustomers();
        List<CustomerViewModel> cvmList = new ArrayList<>();

        for (Customer c : cList) {
            CustomerViewModel cvm = buildCustomerViewModel(c);
            cvmList.add(cvm);
        }

        return cvmList;
    }


    // INVOICE API

    public Invoice saveInvoice(@Valid InvoiceViewModel invoice) {
        return invoiceDao.addInvoice(invoice);
    }

    public Invoice findInvoice(int invoiceId) {
        return invoiceDao.getInvoice(invoiceId);
    }

    public List<Invoice> findAllInvoices() {
        return invoiceDao.getAllInvoices();
    }

    public void updateInvoice(Invoice invoice) { //change to public Invoice updateInvoice(Invoice invoice){
        invoiceDao.updateInvoice(invoice); //return invoiceDao.updateInvoice(invoice);
        //**MUST CHANGE METHOD IN InvoiceDao TO RETURN AN OBJECT (Invoice) in order to work correctly
    }

    public void removeInvoice(int invoiceId) {
        invoiceDao.deleteInvoice(invoiceId);

    }

    public List<Invoice> findInvoiceByCustomer(int customerId) {
        return invoiceDao.getInvoicesByCustomer(customerId);
    }

    // ITEM API

<<<<<<< HEAD
    public ItemViewModel saveItem(@Valid ItemViewModel itemViewModel) {
        return itemDao.addItem(itemViewModel);
=======
    public Item saveItem(ItemViewModel item) {
        return itemDao.addItem(item);
>>>>>>> 40023ea75e1884dd5a5efde79a60055963f520c9
    }

    public Item findItem (int itemId) {
        return itemDao.getItem(itemId);
    }

    public List<Item> findAllItems() {
        return itemDao.getAllItems();
    }

    public void updateItem(Item item) { //change to public Invoice updateInvoice(Invoice invoice){
        itemDao.updateItem(item); //return invoiceDao.updateInvoice(invoice);
        //**MUST CHANGE METHOD IN InvoiceDao TO RETURN AN OBJECT (Invoice) in order to work correctly
    }

    public void removeItem(int itemId) {
        itemDao.deleteItem(itemId);

    }

    //INVOICE ITEM API

    public InvoiceItem saveInvoiceItem(InvoiceItem invoiceItem) {
        return invoiceItemDao.addInvoiceItem(invoiceItem);
    }

    public InvoiceItem findInvoiceItem(int invoiceItemId) {
        return invoiceItemDao.getInvoiceItem(invoiceItemId);
    }

    public List<InvoiceItem> findAllInvoiceItems() {
        return invoiceItemDao.getAllInvoiceItem();
    }

    public void updateInvoiceItem (InvoiceItem invoiceItem) { //change to public Invoice updateInvoice(Invoice invoice){
        invoiceItemDao.updateInvoiceItem(invoiceItem); //return invoiceDao.updateInvoice(invoice);
        //**MUST CHANGE METHOD IN InvoiceDao TO RETURN AN OBJECT (Invoice) in order to work correctly
    }

    public void removeInvoiceItem(int invoiceItemId) {
        invoiceItemDao.deleteInvoiceItem(invoiceItemId);
    }

    public List<InvoiceItem> findInvoiceItemByInvoice(int invoiceId) {
        return invoiceItemDao.getInvoiceItemsByInvoice(invoiceId);
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

