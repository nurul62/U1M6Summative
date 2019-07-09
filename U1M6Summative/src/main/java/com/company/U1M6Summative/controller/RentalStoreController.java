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
        customer.setCustomerId(2);
        customer.setFirstName("Nurmmmmm");
        customer.setLastName("AlamMMMMMMM");
        customer.setEmail("abcdw@gmail.com");
        customer.setCompany("ABCED");
        customer.setPhone("400-400-4000");

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
        customer.setEmail("abc@gmail.com");
        customer.setCompany("ABC");
        customer.setPhone("200-200-2000");

        return customer;
    }
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") int customerId) {
        //code
       customerDao.deleteCustomer(customerId);
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateCustomer(@Valid Customer customer, @PathVariable("customerId") int customerId) {
        if (customerId != customer.getCustomerId()) {
            throw new IllegalArgumentException("Customer ID on path must match.");
        }
    }
    //itemDao
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Item createItem(Item item) {
        Item item1 = new Item();
        item1.setItemId(2);
        item1.setName("XXX");
        item1.setDailyRate(new BigDecimal(100.99));
        item1.setDescription("This is a item");

        return item1;
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

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delItem(@PathVariable("itemId") int itemId) {
        itemDao.deleteItem(itemId);
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Item updateItem(@RequestBody Item itemId) {
        return itemDao.updateItem(itemId);
    }

    /* Create and delete Invoices, including the associated Invoice Items
       Find Invoices by Customer */

    //InvoiceDao & invoiceItemDao
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createInvoice(Invoice invoice) {
        return invoiceDao.addInvoice(invoice);
    }

    @RequestMapping(value = "/invoice/{invoiceId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteInvoice(@PathVariable("invoiceId") int invoiceId) {
        invoiceDao.deleteInvoice(invoiceId);
    }

    @RequestMapping(value = "/invoice/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoiceByCustomer(@PathVariable("id") int customerId){
        return invoiceDao.getInvoice(customerId);
    }
}
