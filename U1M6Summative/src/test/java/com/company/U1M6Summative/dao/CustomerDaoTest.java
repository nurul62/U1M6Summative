package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
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
//        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItems();
//        for (InvoiceItem invoiceItem : invoiceItemList) {
//            InvoiceItemDao.d(.getCustomerId());
//        }
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
}
