package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDaoTest {
    @Autowired
    CustomerDao customerDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    InvoiceItemDao invoiceItemDao;
    @Autowired
    ItemDao itemDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItem();
        for (InvoiceItem invoiceItem : invoiceItemList) {
            invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId());
        }
        List<Item> itemList = itemDao.getAllItems();
        for (Item item : itemList) {
            itemDao.deleteItem(item.getItemId());
        }

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        for (Invoice invoice : invoiceList) {
            invoiceDao.deleteInvoice(invoice.getInvoiceId());
        }

        List<Customer> customerList = customerDao.getAllCustomers();
        for (Customer customer : customerList) {
            customerDao.deleteCustomer(customer.getCustomerId());
        }
    }
    @Test
    public void addGetDeleteCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Amy");
        customer.setLastName("Alexa");
        customer.setEmail("amy@gmail.com");
        customer.setCompany("amazon");
        customer.setPhone("111-222-3333");
        customer = customerDao.addCustomer(customer);

        Customer customer1 = customerDao.getCustomer(customer.getCustomerId());

        assertEquals(customer1, customer);

        customerDao.deleteCustomer(customer.getCustomerId());

        customer1 = customerDao.getCustomer(customer.getCustomerId());

        assertNull(customer1);
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Amy");
        customer.setLastName("Alexa");
        customer.setEmail("amy@gmail.com");
        customer.setCompany("amazon");
        customer.setPhone("111-222-3333");
        customer = customerDao.addCustomer(customer);

        customer.setFirstName("Joseph");
        customer.setLastName("Jones");
        customer.setEmail("jj@gmail.com");
        customer = customerDao.addCustomer(customer);

        customerDao.updateCustomer(customer);

        Customer c1 = customerDao.getCustomer(customer.getCustomerId());

        assertEquals(c1, customer);
    }
}
