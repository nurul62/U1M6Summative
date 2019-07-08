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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceItemTest {
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
    public void addGetDeleteInvoice(){
        Customer customer = new Customer();
        customer.setFirstName("Amy");
        customer.setLastName("Alexa");
        customer.setEmail("amy@gmail.com");
        customer.setCompany("amazon");
        customer.setPhone("111-222-3333");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2010,1,1));
        invoice.setPickupDate(LocalDate.of(2010,2,1));
        invoice.setReturnDate(LocalDate.of(2010,3,1));
        invoice.setLateFee(new BigDecimal(10));
        invoice = invoiceDao.addInvoice(invoice);

        Item item = new Item();
        item.setName("Pen");
        item.setDescription("A black pen.");
        item.setDailyRate(new BigDecimal(8));
        item = itemDao.addItem(item);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(200);
        invoiceItem.setUnitRate(new BigDecimal(100));
        invoiceItem.setDiscount(new BigDecimal(10));
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        InvoiceItem invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertEquals(invoiceItem1, invoiceItem);

        invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId());

        invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertNull(invoiceItem1);
    }
}
