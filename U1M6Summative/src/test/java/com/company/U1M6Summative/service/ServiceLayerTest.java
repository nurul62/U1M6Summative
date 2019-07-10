package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;

import static org.mockito.Mockito.*;

import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceItemViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ServiceLayerTest {

    ServiceLayer service;
    CustomerDao customerDao;
    InvoiceItemDao invoiceItemDao;
    InvoiceDao invoiceDao;
    ItemDao itemDao;

    @Before
    public void setup() {
        setupMockInvoiceDao();
        setupMockCustomerDao();
        setupMockInvoiceItemDao();
        setupMockItemDao();
        service = new ServiceLayer(customerDao, invoiceDao, invoiceItemDao, itemDao);
    }

    private void setupMockItemDao() {
        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
        Item item = new Item();
        item.setDailyRate(BigDecimal.valueOf(2.67));
        item.setDescription("Test");
        item.setName("Test Name");
        item.setItemId(1);
        doReturn(item).when(itemDao).addItem(item);
    }

    private void setupMockInvoiceItemDao() {
        invoiceItemDao = mock(InvoiceItemDaoJdbcTemplateImpl.class);
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setItemId(1);
        invoiceItem.setQuantity(10);
        invoiceItem.setUnitRate(BigDecimal.valueOf(2.45));
        invoiceItem.setDiscount(BigDecimal.valueOf(1.23));
        doReturn(invoiceItem).when(invoiceItemDao).addInvoiceItem(invoiceItem);
        doReturn(invoiceItem).when(invoiceItemDao).getInvoiceItem(1);
    }

    private void setupMockCustomerDao() {
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setLastName("Last name");
        customer.setFirstName("First name");
        customer.setPhone("651 256 0899");
        customer.setCompany("Company");
        customer.setEmail("e@mail.com");
        doReturn(customer).when(customerDao).addCustomer(customer);
        doReturn(customer).when(customerDao).getCustomer(1);
    }

    private void setupMockInvoiceDao() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
        Invoice invoice1 = new Invoice();
        invoice1.setLateFee(BigDecimal.valueOf(2.78));
        invoice1.setReturnDate(LocalDate.of(2019, 7, 1));
        invoice1.setOrderDate(LocalDate.of(2019, 7, 1));
        invoice1.setPickupDate(LocalDate.of(2019, 7, 1));
        invoice1.setInvoiceId(1);
        invoice1.setCustomerId(1);

        Invoice invoice2 = new Invoice();
        invoice2.setLateFee(BigDecimal.valueOf(2.78));
        invoice2.setReturnDate(LocalDate.of(2019, 7, 1));
        invoice2.setOrderDate(LocalDate.of(2019, 7, 1));
        invoice2.setPickupDate(LocalDate.of(2019, 7, 1));
        invoice2.setInvoiceId(2);
        invoice2.setCustomerId(1);
        List<Invoice> invoiceList = Arrays.asList(invoice1, invoice2);

        doReturn(invoice1).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoice1).when(invoiceDao).getInvoice(1);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
        doNothing().when(invoiceDao).deleteInvoice(1);
        doNothing().when(invoiceDao).updateInvoice(invoice1);
    }

    @Test
    public void testAddInvoice() {
        Invoice invoice1 = new Invoice();
        invoice1.setLateFee(BigDecimal.valueOf(2.78));
        invoice1.setReturnDate(LocalDate.of(2019, 7, 1));
        invoice1.setOrderDate(LocalDate.of(2019, 7, 1));
        invoice1.setPickupDate(LocalDate.of(2019, 7, 1));
        invoice1.setCustomerId(1);
        invoice1.setInvoiceId(1);
        InvoiceViewModel invoiceViewModel1 = new InvoiceViewModel();
        invoiceViewModel1.setInvoice(invoice1);
        List<InvoiceItemViewModel> invoiceItemViewModels = new ArrayList<>();

        InvoiceItemViewModel invoiceItemViewModel = new InvoiceItemViewModel(10, BigDecimal.valueOf(2.45),
                BigDecimal.valueOf(1.23), "Item name", "Description",
                BigDecimal.valueOf(1.56), 1, 1);
        invoiceItemViewModels.add(invoiceItemViewModel);
        invoiceViewModel1.setItems(invoiceItemViewModels);
        InvoiceViewModel invoiceViewModel2 = service.addInvoice(invoiceViewModel1);
        Assert.assertEquals( 1, invoiceViewModel2.getItems().size());
    }


//    @Before
//    public void setUp() throws Exception {
//        setUpCustomerDaoMock();
//        setUpItemDaoMock();
//        setUpInvoiceMock();
//        service = new ServiceLayer(customerDao, invoiceDao, invoiceItemDao, itemDao);
//    }

//    @Test
//    public void saveCustomer() {
//        CustomerViewModel cvm = new CustomerViewModel();
//
//        cvm.setFirstName("John");
//        cvm.setLastName("Doe");
//        cvm.setEmail("jd@gmail.com");
//        cvm.setCompany("Google");
//        cvm.setPhone("123-456-7890");
//        cvm = service.saveCustomer(cvm);
//
//        CustomerViewModel fromService = service.findCustomer(cvm.getCustomerId());
//
//        assertEquals(cvm, fromService);
//    }
//
//    @Test
//    public void updateCustomer() {
//    }
//
//    @Test
//    public void removeCustomer() {
//    }
//
//
//    @Test
//    public void saveInvoice() {
//
//
//    }
//    @Test
//    public void updateInvoice() {
//    }
//
//    @Test
//    public void removeInvoice() {
//    }
//
//
//    private void setUpCustomerDaoMock() {
//        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
//        Customer customer = new Customer();
//        customer.setCustomerId(1);
//        customer.setFirstName("Jojo");
//        customer.setLastName("South");
//        customer.setPhone("2221113333");
//        customer.setEmail("jojos@gmail.com");
//        customer.setCompany("Great");
//
//        Customer customer1 = new Customer();
//        customer.setCustomerId(1);
//        customer1.setFirstName("Jojo");
//        customer1.setLastName("South");
//        customer1.setPhone("2221113333");
//        customer1.setEmail("jojos@gmail.com");
//        customer1.setCompany("Great");
//
//        List<Customer> cList = new ArrayList<>();
//        cList.add(customer);
//
//        doReturn(customer).when(customerDao).addCustomer(customer1);
//        doReturn(customer).when(customerDao).getCustomer(1);
//        doReturn(cList).when(customerDao).getAllCustomers();
//    }
//
//
//    private void setUpInvoiceMock() {
//        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceId(1);
//        invoice.setCustomerId(2);
//        invoice.setOrderDate(LocalDate.of(2000,10,10));
//        invoice.setPickupDate(LocalDate.of(2000,10,20));
//        invoice.setReturnDate(LocalDate.of(2000,10,30));
//        invoice.setLateFee(new BigDecimal(2.72));
//
//        Invoice invoice1 = new Invoice();
//        invoice1.setInvoiceId(1);
//        invoice1.setCustomerId(2);
//        invoice1.setOrderDate(LocalDate.of(2000,10,10));
//        invoice1.setPickupDate(LocalDate.of(2000,10,20));
//        invoice1.setReturnDate(LocalDate.of(2000,10,30));
//        invoice1.setLateFee(new BigDecimal(2.72));
//
//        List<Invoice> invoiceList = new ArrayList<>();
//        invoiceList.add(invoice);
//
//        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
//        doReturn(invoice).when(invoiceDao).getInvoice(1);
//        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
//        doNothing().when(invoiceDao).updateInvoice(invoice);
//        doNothing().when(invoiceDao).deleteInvoice(1);
//    }
//
//    private void setUpItemDaoMock() {
//        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
//        Item item = new Item();
//        item.setName("Jojo");
//        item.setDescription("good");
//        item.setDailyRate(new BigDecimal("4.99"));
//
//
//        Item item1 = new Item();
//        item1.setName("Jojo");
//        item1.setDescription("good");
//        item1.setDailyRate(new BigDecimal("4.99"));
//
//        List<Item> tList = new ArrayList<>();
//        tList.add(item);
//
//        doReturn(item).when(itemDao).addItem(item1);
//        doReturn(item).when(itemDao).getItem(1);
//        doReturn(tList).when(itemDao).getAllItems();
//
//    }
}




