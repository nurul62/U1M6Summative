package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
import static org.mockito.Mockito.*;
import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.junit.Before;
import org.junit.Test;

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



    private void setUpCustomerDaoMock() {
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
        Customer customer = new Customer();
        customer.setFirstName("Jojo");
        customer.setLastName("South");
        customer.setPhone("2221113333");
        customer.setEmail("jojos@gmail.com");
        customer.setCompany("Great");
        ;

        Customer customer1 = new Customer();
        customer1.setFirstName("Jill");
        customer1.setLastName("North");
        customer1.setPhone("4441115555");
        customer1.setEmail("jilln@gmail.com");
        customer1.setCompany("Hits");

        List<Customer> cList = new ArrayList<>();
        cList.add(customer);

        doReturn(customer).when(customerDao).addCustomer(customer1);
        doReturn(customer).when(customerDao).getCustomer(1);
        doReturn(cList).when(customerDao).getAllCustomers();
    }
}
