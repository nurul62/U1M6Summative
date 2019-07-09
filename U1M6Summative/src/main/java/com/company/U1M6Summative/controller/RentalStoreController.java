package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.dao.InvoiceDao;
import com.company.U1M6Summative.dao.InvoiceItemDao;
import com.company.U1M6Summative.dao.ItemDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;


@RestController
public class RentalStoreController {

    @Autowired
    CustomerDao customerDao;
    InvoiceDao invoiceDao;
    InvoiceItemDao invoiceItemDao;
    ItemDao itemDao;

    //customerDao
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        customer = customerDao.addCustomer(customer);
        return customer;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer getCustomer(@PathVariable("id") int customerId) {
        if(customerId < 1) {
            throw  new IllegalArgumentException("Customer must not be empty.");
        }
        if (customerDao != null) {
            System.out.println(customerDao + "------");
        } else {
            System.out.println("null");
        }
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setFirstName("Nur");
        customer.setLastName("Alam");
        customer.setCompany("ABC");
        customer.setEmail("abc@gmail.com");
        customer.setPhone("200-200-2000");

        return customer;
    }
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Customer deleteCustomer(@PathVariable("id") int customerId) {
        //code
        return deleteCustomer(customerId);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Customer updateCustomer(@Valid Customer customer, @PathVariable("id") int customerId) {
        if (customerId != customer.getCustomerId()){
            throw new IllegalArgumentException("Customer ID on path must match.");
        }
        return customer;
    }
    //itemDao
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Item createItem(Item item) {
        item = itemDao.addItem(item);
        return item;
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Item getItem(@PathVariable("id") int itemId) {
        if(itemId < 1) {
            throw  new IllegalArgumentException("Item must not be empty.");
        }
        if (itemDao != null) {
            System.out.println(itemDao + "------");
        } else {
            System.out.println("null");
        }

        Item item = new Item();
        item.setItemId(itemId);
        item.setName("BB");
        item.setDailyRate(BigDecimal.valueOf(2.99));
        item.setDescription("Item is item");

        return item;
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public Item deleteItem(@PathVariable("id") int itemId) {
        return deleteItem(itemId);
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Item updateItem(@PathVariable("id") int itemId) {
        return updateItem(itemId);
    }

    /* Create and delete Invoices, including the associated Invoice Items
       Find Invoices by Customer */

    //InvoiceDao & invoiceItemDao
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createInvoice(Invoice invoice) {
        return invoiceDao.addInvoice(invoice);
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice deleteInvoice(@PathVariable("id") int invoiceId) {
        return deleteInvoice(invoiceId);
    }

    @RequestMapping(value = "/invoice/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoiceByCustomer(@PathVariable("id") int customerId){
        return invoiceDao.getInvoice(customerId);
    }
}
