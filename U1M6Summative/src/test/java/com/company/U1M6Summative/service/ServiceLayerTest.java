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

    private ServiceLayer service;
    private InvoiceDao invoiceDao;
    private CustomerDao customerDao;
    private InvoiceItemDao invoiceItemDao;
    private ItemDao itemDao;

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
}




