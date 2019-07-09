//package com.company.U1M6Summative.controller;
//
//import com.company.U1M6Summative.model.Customer;
//import com.company.U1M6Summative.model.Item;
//import com.company.U1M6Summative.service.ServiceLayer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/store")
//public class RentalStoreController {
//    @Autowired
//    private ServiceLayer service;
//
//    @PostMapping("/items")
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Customer createCustomer(@RequestBody Customer customer) {
//        customer.setCustomerId(2);
//        customer.setFirstName("Nurmmmmm");
//        customer.setLastName("AlamMMMMMMM");
//        customer.setEmail("abcdw@gmail.com");
//        customer.setCompany("ABCED");
//        customer.setPhone("400-400-4000");
//
//        customer = customerDao.addCustomer(customer);
//        return customer;
//    }
//
//    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Customer getCustomer(@PathVariable("id") int customerId) {
//        if(customerId < 1) {
//            throw  new IllegalArgumentException("Customer must not be empty.");
//        }
//        if (customerDao != null) {
//            System.out.println(customerDao + "------");
//        } else {
//            System.out.println("null");
//        }
//        Customer customer = new Customer();
//        customer.setCustomerId(customerId);
//        customer.setFirstName("Nur");
//        customer.setLastName("Alam");
//        customer.setEmail("abc@gmail.com");
//        customer.setCompany("ABC");
//        customer.setPhone("200-200-2000");
//
//        return customer;
//    }
//    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteCustomer(@PathVariable("customerId") int customerId) {
//        //code
//       customerDao.deleteCustomer(customerId);
//    }
//
//    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.PUT)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void updateCustomer(@Valid Customer customer, @PathVariable("customerId") int customerId) {
//        if (customerId != customer.getCustomerId()) {
//            throw new IllegalArgumentException("Customer ID on path must match.");
//        }
//    }
//    //itemDao
//    @RequestMapping(value = "/item", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Item createItem(Item item) {
//        Item item1 = new Item();
//        item1.setItemId(2);
//        item1.setName("XXX");
//        item1.setDailyRate(new BigDecimal(100.99));
//        item1.setDescription("This is a item");
//
//        return item1;
//=======
//    public Item addItem(@RequestBody @Valid Item item){
//        return service.addItem(item);
//    }
//
//    @PostMapping("/customers")
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Customer addCustomer(@RequestBody @Valid Customer customer){
//        return service.addCustomer(customer);
//>>>>>>> 4398a7a0b22e34476a9fc11dcd994cd04be6a4a1
//    }
//
////    @PostMapping("/invoices")
////    @ResponseStatus(value = HttpStatus.CREATED)
////    public InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel invoiceViewModel){
////        return service.addInvoice(invoiceViewModel);
////    }
////    @GetMapping("/invoices/{invoiceId}")
////    @ResponseStatus(value = HttpStatus.OK)
////    public InvoiceViewModel getInvoice(@PathVariable int invoiceId){
////        return service.getInvoice(invoiceId);
//    }
//
//    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void delItem(@PathVariable("itemId") int itemId) {
//        itemDao.deleteItem(itemId);
//    }
//
//    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.PUT)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Item updateItem(@RequestBody Item itemId) {
//        return itemDao.updateItem(itemId);
//    }
//
//    /* Create and delete Invoices, including the associated Invoice Items
//       Find Invoices by Customer */
//    @RequestMapping(value = "/invoice/{invoiceId}", method = RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void deleteInvoice(@PathVariable("invoiceId") int invoiceId) {
//        invoiceDao.deleteInvoice(invoiceId);
//    }
//
