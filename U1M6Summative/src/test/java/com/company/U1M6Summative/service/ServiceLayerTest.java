package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
import static org.mockito.Mockito.*;
import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import com.company.U1M6Summative.viewmodel.ItemViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ServiceLayerTest {

    ServiceLayer service;
    CustomerDao customerDao;
    InvoiceItemDao invoiceItemDao;
    InvoiceDao invoiceDao;
    ItemDao itemDao;


    @Before
    public void setUp() throws Exception {
        setUpCustomerDaoMock();
        setUpItemDaoMock();
        setUpInvoiceMock();
        service = new ServiceLayer(customerDao, invoiceDao, invoiceItemDao, itemDao);
    }

    @Test
    public void saveCustomer() {
        CustomerViewModel cvm = new CustomerViewModel();

        cvm.setFirstName("John");
        cvm.setLastName("Doe");
        cvm.setEmail("jd@gmail.com");
        cvm.setCompany("Google");
        cvm.setPhone("123-456-7890");
        cvm = service.saveCustomer(cvm);

        CustomerViewModel fromService = service.findCustomer(cvm.getCustomerId());

        assertEquals(cvm, fromService);
    }

    @Test
    public void updateCustomer() {
    }

    @Test
    public void removeCustomer() {
    }

//    @Test
//    public void saveItem() {
//        ItemViewModel ivm = new ItemViewModel();
//        ivm.setName("Pen");
//        ivm.setDescription("A Black pen");
//        ivm.setDailyRate(new BigDecimal("1.00"));
//        ivm = service.saveItem(ivm);
//
//        ItemViewModel fromService = service.findItem(ivm.getItemId());
//
//        assertEquals(ivm, fromService);

//    }

    private void setUpCustomerDaoMock() {
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
        Customer customer = new Customer();
        customer.setFirstName("Jojo");
        customer.setLastName("South");
        customer.setPhone("2221113333");
        customer.setEmail("jojos@gmail.com");
        customer.setCompany("Great");

        Customer customer1 = new Customer();
        customer1.setFirstName("Jojo");
        customer1.setLastName("South");
        customer1.setPhone("2221113333");
        customer1.setEmail("jojos@gmail.com");
        customer1.setCompany("Great");

        List<Customer> cList = new ArrayList<>();
        cList.add(customer);

        doReturn(customer).when(customerDao).addCustomer(customer1);
        doReturn(customer).when(customerDao).getCustomer(1);
        doReturn(cList).when(customerDao).getAllCustomers();
    }


    private void setUpInvoiceMock(){


    }
        private void setUpItemDaoMock(){
            itemDao = mock(ItemDaoJdbcTemplateImpl.class);
            Item item = new Item();
            item.setName("Jojo");
            item.setDescription("good");
            item.setDailyRate(new BigDecimal("4.99"));


            Item item1 = new Item();
            item1.setName("Jojo");
            item1.setDescription("good");
            item1.setDailyRate(new BigDecimal("4.99"));

            List<Item> tList = new ArrayList<>();
            tList.add(item);

            doReturn(item).when(itemDao).addItem(item1);
            doReturn(item).when(itemDao).getItem(1);
            doReturn(tList).when(itemDao).getAllItems();

        }
    }


