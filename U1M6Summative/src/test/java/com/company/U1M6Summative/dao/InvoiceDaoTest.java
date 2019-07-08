package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
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

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    CustomerDao customerDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    InvoiceItemDao invoiceItemDao;

    @Before
    public void setUp() throws Exception {

        List<Customer> customerList = customerDao.getAllCustomers();
        for (Customer customer : customerList) {
            customerDao.deleteCustomer(customer.getCustomerId());
        }

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        for (Invoice invoice : invoiceList) {
            invoiceDao.deleteInvoice(invoice.getInvoiceId());
        }
    }

//    public class Customer {
//        private int customerId;
//        private String firstName;
//        private String lastName;
//        private String email;
//        private String company;
//        private String phone;

//    public class Invoice {
//        private int invoiceId;
//        private int customerId;
//        private LocalDate orderDate;
//        private LocalDate pickupDate;
//        private LocalDate returnDate;
//        private BigDecimal lateFee;


    @Test
    public void addGetDeleteInvoice() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("jdoe@email.com");
        customer.setCompany("AWS");
        customer.setPhone("123-456-7890");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 07, 8));
        invoice.setPickupDate(LocalDate.of(2019, 07, 15));
        invoice.setReturnDate(LocalDate.of(2019, 07, 22));
        invoice.setLateFee(new BigDecimal("2.00"));
        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice1, invoice);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());

        invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertNull(invoice1);
    }

    @Test
    public void updateInvoice() {

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("jdoe@email.com");
        customer.setCompany("AWS");
        customer.setPhone("123-456-7890");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 07, 8));
        invoice.setPickupDate(LocalDate.of(2019, 07, 15));
        invoice.setReturnDate(LocalDate.of(2019, 07, 22));
        invoice.setLateFee(new BigDecimal("2.00"));
        invoice = invoiceDao.addInvoice(invoice);

        invoice.setOrderDate(LocalDate.of(2019, 06, 8));
        invoice.setPickupDate(LocalDate.of(2019, 06, 15));
        invoice.setReturnDate(LocalDate.of(2019, 06, 22));

        invoiceDao.updateInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice1, invoice);

    }

    @Test
    public void getAllInvoices() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("jdoe@email.com");
        customer.setCompany("AWS");
        customer.setPhone("123-456-7890");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 07, 8));
        invoice.setPickupDate(LocalDate.of(2019, 07, 15));
        invoice.setReturnDate(LocalDate.of(2019, 07, 22));
        invoice.setLateFee(new BigDecimal("2.00"));
        invoice = invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2018, 07, 7));
        invoice.setPickupDate(LocalDate.of(2018, 07, 10));
        invoice.setReturnDate(LocalDate.of(2018, 07, 20));
        invoice.setLateFee(new BigDecimal("3.00"));
        invoice = invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2012, 01, 8));
        invoice.setPickupDate(LocalDate.of(2012, 01, 15));
        invoice.setReturnDate(LocalDate.of(2012, 01, 22));
        invoice.setLateFee(new BigDecimal("5.00"));
        invoice = invoiceDao.addInvoice(invoice);

        List<Invoice> iList = invoiceDao.getAllInvoices();

        assertEquals(iList.size(), 3);
    }

    @Test
    public void getInvoicesByCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("jdoe@email.com");
        customer.setCompany("AWS");
        customer.setPhone("123-456-7890");
        customer = customerDao.addCustomer(customer);

        Customer customer1 = new Customer();
        customer1.setFirstName("Alex");
        customer1.setLastName("Mack");
        customer1.setEmail("amack@email.com");
        customer1.setCompany("Google");
        customer1.setPhone("987-654-3210");
        customer1 = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 07, 8));
        invoice.setPickupDate(LocalDate.of(2019, 07, 15));
        invoice.setReturnDate(LocalDate.of(2019, 07, 22));
        invoice.setLateFee(new BigDecimal("2.00"));
        invoice = invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setCustomerId(customer1.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2016, 01, 8));
        invoice.setPickupDate(LocalDate.of(2016, 01, 15));
        invoice.setReturnDate(LocalDate.of(2016, 01, 22));
        invoice.setLateFee(new BigDecimal("4.00"));
        invoice = invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setCustomerId(customer1.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2012, 11, 1));
        invoice.setPickupDate(LocalDate.of(2012, 11, 10));
        invoice.setReturnDate(LocalDate.of(2012, 11, 30));
        invoice.setLateFee(new BigDecimal("3.00"));
        invoice = invoiceDao.addInvoice(invoice);

        List<Invoice> iList = invoiceDao.getInvoicesByCustomer(customer.getCustomerId());
        assertEquals(iList.size(), 1);

        iList = invoiceDao.getInvoicesByCustomer(customer1.getCustomerId());
        assertEquals(iList.size(), 2);
    }
}
