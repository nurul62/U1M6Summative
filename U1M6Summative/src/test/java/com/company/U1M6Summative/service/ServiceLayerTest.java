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

        cvm.setFirstName("Jojo");
        cvm.setLastName("South");
        cvm.setPhone("2221113333");
        cvm.setEmail("jojos@gmail.com");
        cvm.setCompany("Great");
        cvm = service.saveCustomer(cvm);

        CustomerViewModel fromService = service.findCustomer(cvm.getCustomerId());

        assertEquals(cvm, fromService);
    }

    @Test
<<<<<<< HEAD
    public void findCustomer() {
        CustomerViewModel cvm = new CustomerViewModel();

        cvm.setFirstName("Jojo");
        cvm.setLastName("South");
        cvm.setEmail("jojos@gmail.com");
        cvm.setCompany("Great");
        cvm.setPhone("2221113333");
        cvm = service.saveCustomer(cvm);

        CustomerViewModel fromServiceLayer = service.findCustomer(cvm.getCustomerId());

        assertEquals(cvm, fromServiceLayer);

    }

    @Test
    public void findAllCustomers() {
        CustomerViewModel cvm = new CustomerViewModel();

        cvm.setFirstName("Jojo");
        cvm.setLastName("South");
        cvm.setEmail("jojos@gmail.com");
        cvm.setCompany("Great");
        cvm.setPhone("2221113333");

        cvm = service.saveCustomer(cvm);

        List<CustomerViewModel> cList = service.findAllCustomers();

        assertEquals(1, cList.size());
        assertEquals(cvm, cList.get(0));
    }

//    @Test
//    public void updateCustomer() {
//        CustomerViewModel cvm = new CustomerViewModel();
//
//        cvm.setFirstName("Jojo");
//        cvm.setLastName("South");
//        cvm.setEmail("jojos@gmail.com");
//        cvm.setCompany("Great");
//        cvm.setPhone("2221113333");
//
//        cvm = service.saveCustomer(cvm);
//
//        cvm.setFirstName("Jill");
//        cvm.setLastName("North");
//        cvm.setEmail("jilln@gmail.com");
//
//        service.updateCustomer(cvm);
//
//        CustomerViewModel requestCustomer = service.updateCustomer(cvm.getCustomerId());
//        assertEquals(requestCustomer, cvm);
//
//    }

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
//
//    }

    private void setUpItemDaoMock() {
        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
        Item item = new Item();
        item.setName("Jojo");
        item.setDescription("good");
        item.setDailyRate(new BigDecimal("4.99"));


        Item item1 = new Item();
        item1.setName("Jill");
        item1.setDescription(" very good");
        item1.setDailyRate(new BigDecimal("6.99"));

        List<Item> tList = new ArrayList<>();
        tList.add(item);

        doReturn(item).when(itemDao).addItem(item1);
        doReturn(item).when(itemDao).getItem(1);
        doReturn(tList).when(itemDao).getAllItems();

    }

    private void setUpCustomerDaoMock() {
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
        Customer responseFromDB = new Customer();
        responseFromDB.setCustomerId(1);
        responseFromDB.setFirstName("Jojo");
        responseFromDB.setLastName("South");
        responseFromDB.setPhone("2221113333");
        responseFromDB.setEmail("jojos@gmail.com");
        responseFromDB.setCompany("Great");


        Customer requestC = new Customer();
        requestC.setFirstName("Jojo");
        requestC.setLastName("South");
        requestC.setPhone("2221113333");
        requestC.setEmail("jojos@gmail.com");
        requestC.setCompany("Great");
=======
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
>>>>>>> origin/master

        List<Customer> cList = new ArrayList<>();
        cList.add(responseFromDB);

        doReturn(responseFromDB).when(customerDao).addCustomer(requestC);
        doReturn(responseFromDB).when(customerDao).getCustomer(1);
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


