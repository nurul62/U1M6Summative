package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/store")
public class RentalStoreController {
    @Autowired
    private ServiceLayer service;

    @PostMapping("/items")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Item addItem(@RequestBody @Valid Item item){
        return service.addItem(item);
    }

    @PostMapping("/customers")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody @Valid Customer customer){
        return service.addCustomer(customer);
    }

//    @PostMapping("/invoices")
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel invoiceViewModel){
//        return service.addInvoice(invoiceViewModel);
//    }
//    @GetMapping("/invoices/{invoiceId}")
//    @ResponseStatus(value = HttpStatus.OK)
//    public InvoiceViewModel getInvoice(@PathVariable int invoiceId){
//        return service.getInvoice(invoiceId);
    }




